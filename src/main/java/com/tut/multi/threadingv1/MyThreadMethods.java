package com.tut.multi.threadingv1;

import java.awt.image.ImagingOpException;

public class MyThreadMethods extends Thread {

    public MyThreadMethods(String name){
        super.setName(name);
    }

    @Override
    public void run(){

//        for(int i=0;i<5;i++){
//            try {
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            System.out.println(i);
//        }


        // -********** setPriority Method
//        for (int i=0;i<5;i++){
//            for (int j=0;j<100000000;j++){
//
//            }
//            System.out.println(Thread.currentThread().getName()+" - Priority: "
//                    + Thread.currentThread().getPriority() +
//                    " - count is : "+i);
//        }

        // ********* Interrupt
//        for(int i=0;i<5;i++){
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+" - Priority: "
//                    + Thread.currentThread().getPriority() +
//                    " - count is : "+i);
//        }

        // ********* yield
//        for(int i=0;i<5;i++){
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+ " - " + i);
//        }

        //  daemon thread
        while (true){
            System.out.println("Working daemon thread...........");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadMethods myThreadMethods=new MyThreadMethods("Low");
        MyThreadMethods myThreadMethods_v1=new MyThreadMethods("Medium");
        MyThreadMethods myThreadMethods_v2=new MyThreadMethods("High");
//        myThreadMethods.start();
//        myThreadMethods.join(); // main thread is waiting for the myThreadMethod
//
//        System.out.println("Join method use ");

//        myThreadMethods.setPriority(Thread.MIN_PRIORITY); // **** using SetPriority Method
//        myThreadMethods_v1.setPriority(Thread.NORM_PRIORITY);
//        myThreadMethods_v2.setPriority(Thread.MAX_PRIORITY);
//
//        myThreadMethods.start();
//        myThreadMethods_v1.start();
//        myThreadMethods_v2.start();


//        myThreadMethods.start();
//        myThreadMethods.interrupt();  // ****** using Interrupt Method

//        MyThreadMethods t1=new MyThreadMethods("first");
//        MyThreadMethods t2=new MyThreadMethods("second");
//        t1.start();
//        t2.start();

        MyThreadMethods t3=new MyThreadMethods("Daemon"); // daemon thread
        t3.setDaemon(true);
        MyThreadMethods t4=new MyThreadMethods("User"); // user thread
        t3.start();
        t4.start();
        System.out.println("Main Done !!!");





    }
}
