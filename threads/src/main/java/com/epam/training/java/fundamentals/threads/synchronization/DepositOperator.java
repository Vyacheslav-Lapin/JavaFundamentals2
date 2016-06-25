package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.AllArgsConstructor;

@SuppressWarnings("WeakerAccess")
@AllArgsConstructor
public class DepositOperator implements Operator {
    private Account account;

    @Override
    public void operation() {
        account.deposit(100);
    }
}