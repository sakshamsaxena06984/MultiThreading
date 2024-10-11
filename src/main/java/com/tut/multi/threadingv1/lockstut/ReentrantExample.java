package com.tut.multi.threadingv1.lockstut;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock=new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try {
            System.out.println("Outer Method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try{
            System.out.println("Inner Method");
            System.out.println(LocalDateTime.now());
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example=new ReentrantExample();
        example.outerMethod();
    }
}
