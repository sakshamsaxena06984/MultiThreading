package com.tut.multi.threading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    /**
     * with the help of ReentrantLock, we are preventing the death-lock condition in the below code...
     * In below code, lock.unlock is working as key-pair value form...
     *
     * Summery of Lock tutorial:
     * Lock
     * unlock(__)
     * trylock(__,__)
     * deadlock preventing way
     *
     */
    private final Lock lock=new ReentrantLock();

    public void outerMethod(){
//        lock.lock();
//        lock.lockInterruptibly();
        try{
            System.out.println("Outer method");
            innerMethod();

        }finally {
//            System.out.println("Callling final method");
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try {
            System.out.println("Inner Mthode");
        }finally {
            lock.unlock();
//            lock.unlock();
        }

    }


    public static void main(String[] args) {
        ReentrantLockExample ex=new ReentrantLockExample();
        ex.outerMethod();

    }
}
