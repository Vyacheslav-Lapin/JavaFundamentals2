package com.epam.training.java.fundamentals.threads.synchronization;

public class DeadLockFreeOperator extends DeadLockOperator {

    @SuppressWarnings("WeakerAccess")
    public DeadLockFreeOperator(Account account1, Account account2) {
        super(  account1.hashCode() > account2.hashCode() ? account1: account2,
                account1.hashCode() > account2.hashCode() ? account2: account1);
    }

    public static void main(String[] args) {
        Account acc1 = new NotThreadSafeAccount(200);
        Account acc2 = new NotThreadSafeAccount(300);

        Thread op1 = new Thread(new DeadLockFreeOperator(acc1, acc2));
        Thread op2 = new Thread(new DeadLockFreeOperator(acc2, acc1));

        op1.start();
        op2.start();
    }
}
