package com.tut.multi.threadingv1.byinterface;

public class World implements Runnable{
    @Override
    public void run() {
       for (; ;){
           System.out.println(Thread.currentThread().getName());
       }
    }
}
