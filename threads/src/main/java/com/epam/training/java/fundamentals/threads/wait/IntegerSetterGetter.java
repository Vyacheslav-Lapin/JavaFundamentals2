package com.epam.training.java.fundamentals.threads.wait;

import java.util.Random;

public class IntegerSetterGetter extends Thread {

    private final SharedResource resource;
    private boolean run = true;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
    }

    public void stopThread() {
        run = false;
    }

    @Override
    public void run() {
        try {
            while (run)
                if (rand.nextInt(1_000) % 2 == 0)
                    getIntegersFromResource();
                else
                    setIntegersIntoResource();
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {

        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName() + " хочет извлечь число.");

            number = resource.getELement();
            while (number == null) {
                System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
                resource.wait();
                System.out.println("Поток " + getName() + " возобновил работу.");
                number = resource.getELement();
            }
            System.out.println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notifyAll();
            resource.wait();
        }
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        for (int i = 1; i <= 10; i++) {
            new IntegerSetterGetter(Integer.toString(i), resource)
                    .start();
        }
    }
}