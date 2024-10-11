package com.tut.multi.threading.runnable;

import com.tut.multi.threading.TestThread;

public class Test1 {
    public static void main(String[] args) {
//        System.out.println("Hello");

        TestThread obj=new TestThread();
        Thread t1=new Thread(obj);
        t1.start();


        for(; ;){
//            System.out.println("Hello");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
