package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.AllArgsConstructor;

@SuppressWarnings("WeakerAccess")
@AllArgsConstructor
public class ThreadSafeWithdrawOperator implements Operator {

    private Account account;

    @Override
    public void operation() {
        synchronized (this) {
            account.withdraw(50);
        }
    }
}