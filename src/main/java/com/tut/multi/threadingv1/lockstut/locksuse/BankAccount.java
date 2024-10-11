package com.tut.multi.threadingv1.lockstut.locksuse;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private Lock lock=new ReentrantLock();

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName()+
                " attempting to withdraw "+ amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){ // locking for one thread
                if(balance>=amount){

                    try {
                        Thread.sleep(3000);
                        balance-=amount;
                        System.out.println(Thread.currentThread().getName()+ " completed withdrawal, Remaining balance: "+ this.balance);
                    }catch (InterruptedException e){
//                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }finally {
                        // unlock to apply Lock
                        lock.unlock();
                    }


                }else {
                    System.out.println(Thread.currentThread().getName()+ " insufficient balance .....");
                }

            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }

        if(Thread.currentThread().isInterrupted()){
            System.out.println("****** saxena123saksham@gmail.com  **********");
        }
    }
}
