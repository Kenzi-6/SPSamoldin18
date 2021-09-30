package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("TextWithNum.txt"))) {
            String str = br.readLine();
            String[] mas = str.split("\\*");
            int chislo1 = Integer.parseInt(mas[0]);
            int chislo2 = Integer.parseInt(mas[1]);
            Num chisla = new Num(chislo1, chislo2);
            System.out.println(chisla.umnozhenie(chislo1, chislo2));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}