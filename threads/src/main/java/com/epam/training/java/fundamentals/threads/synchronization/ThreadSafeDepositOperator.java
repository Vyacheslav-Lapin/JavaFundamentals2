package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.AllArgsConstructor;

@SuppressWarnings("WeakerAccess")
@AllArgsConstructor
public class ThreadSafeDepositOperator implements Operator {

    private Account account;

    @Override
    public void operation() {
        synchronized (this) {
            account.deposit(100);
        }
    }
}