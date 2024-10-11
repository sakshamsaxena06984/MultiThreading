package com.tut.multi.threadingv1.lambdaexpr;

public class LambdaExpression {
    public static void main(String[] args) {
        Runnable runnable= () -> System.out.println("Hello");
//        Runnable runnable1 = () -> System.out.println("Hello1");
//        Thread t=new Thread(runnable);

        Thread t1=new Thread(()-> System.out.println("Hello, Anonymous"));
        t1.start();

        Thread t2=new Thread(() -> {
            for (int i=0;i<10;i++){
                System.out.println("Hello World!");
            }
        });
        t2.start();
    }
}
