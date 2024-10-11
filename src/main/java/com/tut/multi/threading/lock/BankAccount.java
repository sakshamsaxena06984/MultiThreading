package com.tut.multi.threading.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    // achieving lock via synchronized keyword

//    public synchronized void withdraw(int amount){
//        System.out.println(Thread.currentThread().getName()+" attempting the withdraw "+amount);
//        if (balance>=amount){
//            System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal "+amount);
//            try{
//                Thread.sleep(1000);
//
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//            this.balance=this.balance-amount;
//            System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance "+this.balance);
//        }else {
//            System.out.println(Thread.currentThread().getName()+" insufficient balance");
//        }
//    }


    // now, we achieve the Lock via explicit


    private final Lock lock=new ReentrantLock();

    /**
     * lock.lock() : similar to the synchronized keyword..
     * lock.tryLock() : using in below code..
     * @param amount
     */

    public  void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting the withdraw "+amount);
       try {
           if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
               if(balance>=amount){

                   try{
                       System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal "+amount);
                       Thread.sleep(3000);
                       balance-=amount;

                       System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance "+this.balance);


                   }catch (InterruptedException e){
                       Thread.currentThread().interrupt();
                   }finally {
                       lock.unlock();
                   }

               }else{
                   System.out.println(Thread.currentThread().getName()+" insufficient balance");

               }

           }else{
               System.out.println(Thread.currentThread().getName()+" could not acquire the lock, will try later");

           }
       }catch (Exception e){
           Thread.currentThread().interrupt();

       }
    }
}
