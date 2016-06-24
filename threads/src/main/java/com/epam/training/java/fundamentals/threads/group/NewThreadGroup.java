package com.epam.training.java.fundamentals.threads.group;

public class NewThreadGroup extends ThreadGroup {

    public NewThreadGroup(String n) {
        super(n);
    }

    public NewThreadGroup(ThreadGroup parent, String n) {
        super(parent, n);
    }

    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " has unhandled exception:" + e);
    }

}
