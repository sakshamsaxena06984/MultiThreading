package com.tut.multi.threadingv1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CF {
    public static void main(String[] args) {

//        CompletableFuture<String> complete_Future= CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//                System.out.println("Worker Thread");
//            } catch (Exception e) {
//
//            }
//            return "OK";
//        });
//        String s=null;
//        try {
//            s=complete_Future.get();
//        }catch (InterruptedException | ExecutionException e){
//            throw new RuntimeException(e);
//        }
//        System.out.println(s);
//        System.out.println("Main");


        CompletableFuture<String> task1= CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker Thread-1");
            } catch (Exception e) {

            }
            return "OK_FIRST";
        });

        CompletableFuture<String> task2= CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker Thread-2");
            } catch (Exception e) {

            }
            return "OK_SECOND";
        });

        CompletableFuture<Void> voidCompletableFuture= CompletableFuture.allOf(task1, task1);
        System.out.println(voidCompletableFuture.join());
        System.out.println("Main");


    }
}
