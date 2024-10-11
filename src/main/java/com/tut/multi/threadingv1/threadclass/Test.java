package com.tut.multi.threadingv1.threadclass;

public class Test {
    public static void main(String[] args) {
        World world=new World();
        world.start();
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
