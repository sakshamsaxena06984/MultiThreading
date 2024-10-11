package com.tut.multi.threading;

/***
 * run
 * start
 * sleep
 * join
 * setPriority : MIN | MAX | NORM
 * interrupt : after this function, Thread will be terminated
 * yield : a hint to the scheduler that the current thread is willing to yield its current use of a processor.
 * setDaemon : Back-ground running thread
 *
 */
public class ThreadMethod extends Thread{

    public ThreadMethod(String name){
        super(name);
    }

    @Override
    public void run() {
//        System.out.println("Thread is running");
//        for (int i=0;i<1;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }


//        for (int i=0;i<5;i++){
//            System.out.println(Thread.currentThread().getName() +" -Priority:  "+Thread.currentThread().getPriority()+" -count: "+ i);
//            try {
//                Thread.sleep(100);
//            }catch (Exception e){
//
//            }
//        }

//        try {
//            Thread.sleep(1000);
//            System.out.println("Thread is running....");
//        }catch (Exception e){
//            System.out.println(e);
//        }

        // yield
//        for(int i=0;i<50;i++){
//            System.out.println(Thread.currentThread().getName());
//            Thread.yield();
//        }

        while (true){
            System.out.println("Hello world");
        }


    }

    public static void main(String[] args) throws InterruptedException {
//        ThreadMethod obj=new ThreadMethod();
//        obj.start();
//        obj.join();
//        System.out.println("Terminated");

//        ThreadMethod t1=new ThreadMethod("Hello_v1");
//        ThreadMethod t2=new ThreadMethod("Hello_v2");
//        ThreadMethod t3=new ThreadMethod("Hello_v3");
//        t1.setPriority(Thread.NORM_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
//        t3.setPriority(Thread.MIN_PRIORITY);
//        t1.start();
//        t2.start();
//        t3.start();

//        ThreadMethod obj=new ThreadMethod("Hello");
//        obj.start();
//        obj.interrupt();

        // yield
//        ThreadMethod t1=new ThreadMethod("First");
//        ThreadMethod t2=new ThreadMethod("Second");
//        t1.start();
//        t2.start();

        // daemon
        ThreadMethod obj=new ThreadMethod("Daemon-Example");
        obj.setDaemon(true);
        obj.start();
        System.out.println("Main Done!");


    }
}
