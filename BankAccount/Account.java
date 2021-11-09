package com.company;

import java.util.Scanner;

public class Account extends Thread {
    int balance;
    public Account(int balance){
        this.balance = balance;
    }
    //пополнение счета
    public void addMoney (int am){
        balance += am;
        System.out.println("Счет пополнен");
    }
    //списание счета
    public void getMoney (int gm){
        if (balance < gm){
            System.out.println("На вашем счету недостаточно средств");
        }
        else {
            balance -= gm;
            System.out.println("Деньги успешно сняты");
        }
    }
    public void start() {
        Scanner in = new Scanner(System.in);
        while (true){
            try {
                Thread.sleep(1500); //задержка меню
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------------------");
            System.out.println("Баланс: " + balance + '$');
            System.out.println("Введите номер пункта, который хотите выполнить");
            System.out.println("1) Пополнить счет");
            System.out.println("2) Снять деньги");
            System.out.println("3) Выйти");
            System.out.println("---------------------");
            int n = in.nextInt();
            if (n == 1){
                System.out.println("Введите сумму, которую вы хотите положить на счет");
                int am = in.nextInt();
                addMoney(am);
            }
            else if (n == 2){
                System.out.println("Введите сумму, которую вы хотите снять со счета");
                int gm = in.nextInt();
                getMoney(gm);
            }
            else if (n == 3){
                System.out.println("Всего доброго, уважаемый клиент!");
                break;
            }
            else {System.out.println("ВВЕДИТЕ НОМЕР ПУНКТА ИЗ СПИСКА НИЖЕ!");}
        }
    }
}