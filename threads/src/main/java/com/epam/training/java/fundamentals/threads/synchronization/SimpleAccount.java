package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SimpleAccount implements Account {
    private int balance;

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(
                new SimpleAccount(200)
                        .getOperationsResult());
    }
}