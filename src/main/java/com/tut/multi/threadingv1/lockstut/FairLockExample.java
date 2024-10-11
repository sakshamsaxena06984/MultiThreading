package com.tut.multi.threadingv1.lockstut;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private final Lock lock = new ReentrantLock(true);

    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+ " acquired the lock");
            Thread.sleep(1000);

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+ " released the lock..");
        }
    }

    public static void main(String[] args) {
        FairLockExample example=new FairLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        try {

            thread1.start();
            Thread.sleep(500);
            thread2.start();
            Thread.sleep(500);
            thread3.start();
        }catch (Exception e){
            e.getMessage();
        }

    }
}
