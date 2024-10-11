package com.tut.multi.threadingv1.lockstut.lockwithsynchro;

import com.tut.multi.threadingv1.lockstut.lockwithsynchro.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(20);
            }
        };
        Thread t1=new Thread(task,"Thread-1");
        Thread t2=new Thread(task,"Thread-2");
        t1.start();
        t2.start();
    }
}
