package com.tut.multi.threadingv1.lockstut.lockwithsynchro;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName()+
                " attempting to withdraw "+ amount);
        if (this.balance>= amount){
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+ " completed withdrawal, Remaining balance: "+ this.balance);
        }else{
            System.out.println(Thread.currentThread().getName()+ " insufficient balance..");
        }
    }
}
