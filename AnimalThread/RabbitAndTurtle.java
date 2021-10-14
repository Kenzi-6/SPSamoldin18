package com.company;

public class RabbitAndTurtle {

    public static void main(String[] args) {
        AnimalThread rabbit = new AnimalThread("Кролик", Thread.MIN_PRIORITY);
        AnimalThread turtle = new AnimalThread("Черепаха", Thread.MAX_PRIORITY);

        rabbit.start();
        turtle.start();
    }
}