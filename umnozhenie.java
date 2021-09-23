package com.company;

import java.util.Scanner;
import java.lang.Math;

class main {
    static double umnozhenie(double Chislo1, double Chislo2) {
        if (Chislo1 == 0 || Chislo2 == 0){
            return 0;
        }
        else if (Chislo1 == 1){
            return Chislo2;
        }
        else if (Chislo2 == 1){
            return Chislo1;
        }
        else{
            return (int) Math.pow(10, (Math.log10(Chislo1) + Math.log10(Chislo2)));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double chislo1 = in.nextInt();
        double chislo2 = in.nextInt();
        System.out.print(umnozhenie(chislo1, chislo2));
    }
}
