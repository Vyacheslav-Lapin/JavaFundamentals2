package com.epam.training.java.fundamentals.threads;

public class Join implements Runnable {

    private Thread t;

    public Join(String threadName) {
        t = new Thread(this, threadName);
        System.out.println("New thread: " + t);
        t.start(); // Start the thread
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(t.getName() + ": " + i);
                Thread.sleep(1_000);
            }
        } catch (InterruptedException e) {
            System.out.println(t.getName() + " interrupted.");
        }
        System.out.println(t.getName() + " exiting.");
    }

    public static void main(String[] args) {
        Join ob1 = new Join("One");
        Join ob2 = new Join("Two");
        Join ob3 = new Join("Three");

        System.out.println("Thread One is alive: " + ob1.t.isAlive());
        System.out.println("Thread Two is alive: " + ob2.t.isAlive());
        System.out.println("Thread Three is alive: " + ob3.t.isAlive());

        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Thread One is alive: " + ob1.t.isAlive());
        System.out.println("Thread Two is alive: " + ob2.t.isAlive());
        System.out.println("Thread Three is alive: " + ob3.t.isAlive());
        System.out.println("Main thread exiting.");
    }
}
