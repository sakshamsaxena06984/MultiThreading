package com.tut.multi.threading;

public class TestThread extends Thread{

    @Override
    public void run() {
        for(; ;){
//            System.out.println("World");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
