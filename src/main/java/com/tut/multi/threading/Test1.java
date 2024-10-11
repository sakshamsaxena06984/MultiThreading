package com.tut.multi.threading;

public class Test1 {
    public static void main(String[] args) {
//        System.out.println("Hello");

        TestThread obj=new TestThread();
        obj.start();

        for(; ;){
//            System.out.println("Hello");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
