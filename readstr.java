package com.company;

import java.io.*;
// чтение из файла и использование класса
public class readstr {
    public static class Num {
        int X;
        int Y;

        public Num(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }
    static int umnozhenie(Num chisla) {
        if (chisla.X == 0 || chisla.Y == 0) {
            return 0;
        } else if (chisla.X == 1) {
            return chisla.Y;
        } else if (chisla.Y == 1) {
            return chisla.X;
        } else {
            return (int) Math.pow(10, (Math.log10(chisla.X) + Math.log10(chisla.Y)));
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("TextWithNum.txt"))) {
            String str = br.readLine();
            String[] mas = str.split("\\*");
            int chislo1 = Integer.parseInt(mas[0]);
            int chislo2 = Integer.parseInt(mas[1]);
            Num chisla = new Num(chislo1, chislo2);
            System.out.println(umnozhenie(chisla));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}