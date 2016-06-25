package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BlockAccount implements Account {
    private int balance;

    @Override
    public void deposit(int amount) {
        synchronized (this) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(int amount) {
        synchronized (this) {
            balance -= amount;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println(
                new BlockAccount(200)
                        .getOperationsResult());
    }
}