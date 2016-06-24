package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OperatorWithdraw extends Thread {

    private Account account;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            account.withdraw(50);
    }
}
