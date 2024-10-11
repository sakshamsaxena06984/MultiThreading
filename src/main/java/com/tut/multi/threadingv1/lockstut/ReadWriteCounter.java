package com.tut.multi.threadingv1.lockstut;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count=0;
    private final ReadWriteLock lock=new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.lock();
        }
    }

    public int getCount(){
        readLock.lock();
        try{
            return  count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter=new ReadWriteCounter();
        Runnable readTask=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName() + " read: "+ counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    counter.increment();
                    System.out.println(Thread.currentThread().getName()+ " increemented");
                }
            }
        };


        Thread writeThread = new Thread(writeTask);
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);

        writeThread.start();
        readerThread1.start();
        readerThread2.start();

        writeThread.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("Final Count : "+ counter.getCount());

    }
}