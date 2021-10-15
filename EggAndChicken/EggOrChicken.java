package com.company;


public class EggOrChicken extends Thread{
    String name;
    int priority;

    public EggOrChicken(String name, int priority) {

        this.name = name;
        this.priority = priority;
    }
    @Override
    public  void run() {
        Thread.currentThread().setName(name);
        Thread.currentThread().setPriority(priority);
        for(int i = 1;i <= 10; i ++){
            try {
                Thread.sleep(400);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
