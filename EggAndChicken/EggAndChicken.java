package com.company;

public class EggAndChicken {

    public static void main(String[] args) {
        EggOrChicken egg = new EggOrChicken("Яйцо", Thread.NORM_PRIORITY);
        EggOrChicken chicken = new EggOrChicken("Курица", Thread.NORM_PRIORITY);

        egg.start();
        chicken.start();
        while(true){
            egg.isAlive();
            chicken.isAlive();
            if(egg.isAlive() == false){
                System.out.println("Спор окончен. Победила курица");
                break;
            }
            else if (chicken.isAlive() == false){
                System.out.println("Спор окончен. Победило яйцо");
                break;
            }
        }
    }
}