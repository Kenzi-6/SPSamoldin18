package com.company;
import java.io.*;
import java.util.ArrayList;

public class Obfuscator {
    private static final String JAVA_FILE = "src/com/company/downloadMP.java";
    private static final String PATH = "src/com/company/";

    public static void main(String[] args) {
        String str = "";
        downloadMP c = new downloadMP();
        Class cls = c.getClass();

        String sname = cls.getSimpleName(); //получение имени класса
        String rname = sname.substring(0,3); //обрезание имени класса

        try(BufferedReader read = new BufferedReader(new FileReader(JAVA_FILE))){
            String cod;
            boolean prov = false;
            while ((cod = read.readLine()) != null){
                cod = cod.replace(sname,rname); // переименование класса
                cod = cod.replaceAll("\\s+", " "); // удаление лишних пробелов
                boolean comment = cod.matches("^(//.*)|(.*/\\*.*)|(.*\\*/)|$"); // проверка строки на комменты
                //проверка на начало и конец многострочного коммента
                if(comment){
                    boolean Comment = cod.matches("^(.*\\*/)$");
                    boolean Comment_1 = cod.matches("^(.*/\\*.*)$");
                    if(Comment){
                        prov = false;
                    }
                    else if (Comment_1){
                        prov = true;
                    }
                    else{
                        prov = false;
                    }
                }
                else if (!prov){
                    str = str + cod;
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        str = str.replace("(", " (");
        String[] strArray = {str};
        String inputStr = "="; // по = будут определятся переменные
        ArrayList<String> varArray = new ArrayList<>(); // массив для переменных
        String metStr = "void"; // по void будут определяться методы
        ArrayList <String> metArray = new ArrayList<>(); // массив для методов

        // находит и записывает в массив переменные и методы
        for (int i = 0; i < strArray.length; i++) {
            String[] contents = strArray[i].split(" ");
            for (int j = 0; j < contents.length; j++) {
                if (inputStr.equals(contents[j])) { // заполнение массива переменными
                    varArray.add(contents[j-1]);
                }
                if (metStr.equals(contents[j])) { // заполнение массива методами
                    metArray.add(contents[j+1]);
                }
            }
        }

        // переименовывание переменных
        for (int z = 1; z < varArray.size() - 1; z++){
            if (varArray.get(z).length() > 1){
                str = str.replaceAll(varArray.get(z), varArray.get(z).substring(0,2));
            }
        }

        // переименовывание методов
        for (int d = 0; d < metArray.size(); d++){
                String nameM = metArray.get(d);
                String newnameM = "";
                if (nameM.equals("main")){ // метод main нельзя переименовывать
                    newnameM = metArray.get(d);
                }
                else {newnameM = metArray.get(d).replaceAll(", ","").replaceAll(",","").substring(0, 2);}
                str = str.replace(nameM, newnameM);
            }
        str = str.replace(" (", "(");

        //запись в файл
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(PATH + rname + ".txt", true))){
            wr.write(str);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}