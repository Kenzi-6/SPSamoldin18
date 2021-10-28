package com.company;

import java.io.*;
import java.nio.channels.FileChannel;

public class JavaCopyFile {
    public static void main(String[] args) throws InterruptedException, IOException {
        File source = new File("source.txt"); //файл с текстом
        File dest = new File("dest.txt"); //файл, в который будет копироваться
        File source1 = new File("source1.txt"); //файл с текстом
        File dest1 = new File("dest1.txt"); //файл, в который будет копироваться

        long start = System.nanoTime();
        copyFile(source,dest);
        copyFile(source1, dest1);
        System.out.println("Время копирования файла = " + (System.nanoTime()-start));
    }
    public static  void copyFile( File source,  File dest)  throws IOException {

        FileChannel is= null;
        FileChannel os = null;
        try {
            is = new FileInputStream(source).getChannel();
            os = new FileOutputStream(dest).getChannel();
            os.transferFrom(is, 0, is.size());
        } finally {
            is.close();
            os.close();
        }
    }
}