package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SyncAccount implements Account {
    private int balance;

    @Override
    public synchronized void deposit(int amount) {
        balance += amount;
    }

    @Override
    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public static void main(String[] args) throws InterruptedException {
        //noinspection unchecked
        System.out.println(
                new SyncAccount(200)
                        .getOperationsResult(DepositOperator::new, WithdrawOperator::new));
    }
}