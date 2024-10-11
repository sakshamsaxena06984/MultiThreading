package com.tut.multi.threadingv1;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Running State.....");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
        System.out.println(myThread.getState()); // NEW state
        myThread.start();
        System.out.println(myThread.getState()); // RUNNABLE after the starting the thread object
        Thread.sleep(100);
        System.out.println(myThread.getState());
        myThread.join(); // it is waiting for the main state
        System.out.println(myThread.getState());
    }
}
