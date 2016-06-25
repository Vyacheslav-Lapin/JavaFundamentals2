package com.epam.training.java.fundamentals.threads.synchronization;

import com.epam.courses.jf.common.Private;

import java.util.function.Function;

@SuppressWarnings("WeakerAccess")
public interface Account {

    void deposit(int amount);
    void withdraw(int amount);
    int getBalance();

    @SuppressWarnings("unchecked")
    default int getOperationsResult(Function<Account, Runnable>... operatorConstructors) throws InterruptedException {

        Thread[] operators = toThreads(operatorConstructors);

        for (Thread operator: operators)
            operator.start();

        for (Thread operator: operators)
            operator.join();

        return getBalance();
    }

    @Private
    @SuppressWarnings("unchecked")
    default Thread[] toThreads(Function<Account, Runnable>... operatorConstructors) {
        Thread[] operators = new Thread[operatorConstructors.length];
        int i = 0;
        for (Function<Account, Runnable> operatorConstructor : operatorConstructors)
            operators[i++] = new Thread(operatorConstructor.apply(this));
        return operators;
    }
}