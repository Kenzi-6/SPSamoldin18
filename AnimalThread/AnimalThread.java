package com.company;


public class AnimalThread extends Thread{
    String name;
    int priority;

    public AnimalThread(String name, int priority) {

        this.name = name;
        this.priority = priority;
    }
    @Override
    public  void run() {
        Thread.currentThread().setName(name);
        Thread.currentThread().setPriority(priority);
        int distance = 30;
        for(int metr = 1;metr <= distance; metr ++){
            try {
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " пробежал " + metr + 'м');
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
