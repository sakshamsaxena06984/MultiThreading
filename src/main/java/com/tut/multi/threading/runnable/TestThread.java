package com.tut.multi.threading.runnable;

public class TestThread implements Runnable{
    @Override
    public void run() {
        for (; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
