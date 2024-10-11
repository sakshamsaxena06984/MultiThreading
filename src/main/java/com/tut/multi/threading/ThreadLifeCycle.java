package com.tut.multi.threading;

public class ThreadLifeCycle extends Thread{
    @Override
    public void run() {
        System.out.println("Running");
        try {
            Thread.sleep(1000); // It is the ThreadLifeCycle thread class
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifeCycle obj=new ThreadLifeCycle();
        System.out.println(obj.getState()); // It is in the NEW state
        obj.start();
        System.out.println(obj.getState()); // RUNNABLE
        Thread.sleep(100); // It is the main class Thread
        System.out.println(obj.getState()); // TIMED_WAITING
        obj.join();
        System.out.println(obj.getState()); // TERMINATED


    }
}
