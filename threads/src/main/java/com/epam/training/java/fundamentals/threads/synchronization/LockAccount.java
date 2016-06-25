package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LockAccount implements Account {
    private int balance;
    private Object lock;

    @Override
    public void deposit(int amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(int amount) {
        synchronized (lock) {
            balance -= amount;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(
                new LockAccount(200, new Object())
                        .getOperationsResult());
    }
}