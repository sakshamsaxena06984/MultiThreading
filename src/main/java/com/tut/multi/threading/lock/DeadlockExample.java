package com.tut.multi.threading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    public static void main(String[] args) {
        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Try to acquire lock1
                lock1.lock();
                try {
                    System.out.println("Thread 1: Holding lock 1...");

                    // Simulate some work with lock1
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {}

                    System.out.println("Thread 1: Waiting for lock 2...");

                    // Try to acquire lock2
                    lock2.lock();
                    try {
                        System.out.println("Thread 1: Holding lock 1 & 2...");
                    } finally {
                        lock2.unlock();
                    }
                } finally {
                    lock1.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Try to acquire lock2
                lock2.lock();
                try {
                    System.out.println("Thread 2: Holding lock 2...");

                    // Simulate some work with lock2
                    try { Thread.sleep(50); } catch (InterruptedException e) {}

                    System.out.println("Thread 2: Waiting for lock 1...");

                    // Try to acquire lock1
                    lock1.lock();
                    try {
                        System.out.println("Thread 2: Holding lock 1 & 2...");
                    } finally {
                        lock1.unlock();
                    }
                } finally {
                    lock2.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
