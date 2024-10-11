package com.tut.multi.threadingv1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclickBarrierExample {
    public static void main(String[] args) {
        int numberOfSubSystem=4;
        CyclicBarrier barrier = new CyclicBarrier(numberOfSubSystem, new Runnable() {
            @Override
            public void run() {
                System.out.println("All subsystems are up and running. System startup complete..");
            }
        });

        Thread webServerThread = new Thread(new Subsystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new Subsystem("Database", 4000, barrier));
        Thread cacheThread = new Thread(new Subsystem("Cache", 3000, barrier));
        Thread messagingServiceThread = new Thread(new Subsystem("Messaging Service", 3500, barrier));
        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();

    }
}
class Subsystem implements Runnable{
    private CyclicBarrier barrier;
    private String name;
    private int initializationTime;

    public Subsystem(String name, int initializationTime, CyclicBarrier barrier){
        this.name=name;
        this.initializationTime=initializationTime;
        this.barrier=barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+ " initialization started ....");
            Thread.sleep(initializationTime);
            System.out.println(name + " initialization completed....");
            barrier.await();
        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
