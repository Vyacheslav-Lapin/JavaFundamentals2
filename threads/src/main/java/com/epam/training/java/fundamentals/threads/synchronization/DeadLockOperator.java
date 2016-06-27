package com.epam.training.java.fundamentals.threads.synchronization;

import lombok.RequiredArgsConstructor;

import static java.lang.Thread.yield;

@RequiredArgsConstructor
public class DeadLockOperator implements Operator {

    private static final int DEPOSIT_SUM = 50;
    private final Account account1;
    private final Account account2;

    @Override
    public void operation() {
        operation(DEPOSIT_SUM);
        yield();
    }

    private void operation(int depositSum) {
        synchronized (account1) {
            System.out.println("[" + hashCode() + "] Заблокирован первый счет.");
            synchronized (account2) {
                System.out.println("[" + hashCode() + "] Заблокирован второй счет.");
                account1.deposit(depositSum);
                account2.withdraw(depositSum);
            }
        }
    }

    public static void main(String[] args) {
        Account acc1 = new NotThreadSafeAccount(200);
        Account acc2 = new NotThreadSafeAccount(300);

        Thread op1 = new Thread(new DeadLockOperator(acc1, acc2));
        Thread op2 = new Thread(new DeadLockOperator(acc2, acc1));

        op1.start();
        op2.start();
    }
}