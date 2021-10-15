package com.company;

import java.io.*;

public class JavaCopyFile {
    public static void main(String[] args) throws InterruptedException, IOException {
        File source = new File("source.txt"); //файл с текстом
        File dest = new File("dest.txt"); //файл, в который будет копироваться
        File source1 = new File("source1.txt"); //файл с текстом
        File dest1 = new File("dest1.txt"); //файл, в который будет копироваться

        long start = System.nanoTime();
        copyFile(source, dest);
        copyFile(source1, dest1);
        System.out.println("Время копирования файла с помощью потоков = "+(System.nanoTime()-start));
    }
    public static void copyFile(File source, File dest) throws IOException {

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
