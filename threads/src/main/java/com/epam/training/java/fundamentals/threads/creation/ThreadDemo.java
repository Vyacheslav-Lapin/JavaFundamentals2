package com.epam.training.java.fundamentals.threads.creation;

public class ThreadDemo {
    public static void main(String[] args) {
        Talk talk  = new Talk();
        Thread walk = new Thread(new Walk());
        talk.start();
        walk.start();

        //com.epam.training.java.fundamentals.threads.creation.Walk w = new com.epam.training.java.fundamentals.threads.creation.Walk(); // просто объект, не поток
        // w.run(); //выполнится метод, но поток не запустится!
    }
}
