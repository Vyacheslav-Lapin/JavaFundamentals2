package com.epam.training.java.fundamentals.threads;

public class Daemon extends Thread {
    @Override
    public void run() {
        for(int i=0;i<10; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Start main thread.");
        Daemon daemon = new Daemon();
        daemon.setDaemon(true);
        daemon.start();

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End main thread.");
    }
}
