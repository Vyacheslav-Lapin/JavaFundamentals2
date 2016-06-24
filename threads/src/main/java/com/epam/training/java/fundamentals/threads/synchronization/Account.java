package com.epam.training.java.fundamentals.threads.synchronization;

public interface Account {
    void deposit(int amount);
    void withdraw(int amount);
    int getBalance();

    default int getOperationsResult() throws InterruptedException {
        OperatorDeposit opD = new OperatorDeposit(this);
        OperatorWithdraw opW = new OperatorWithdraw(this);

        opD.start();
        opW.start();

        opD.join();
        opW.join();

        return getBalance();
    }
}
