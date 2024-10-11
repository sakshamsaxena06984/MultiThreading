package com.tut.multi.threadingv1.threadpooling.executerframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainExecutors {
    private static long factorial(int n) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        long result = 1;
        for(int i=1;i<=n;i++){
            result*=i;
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {

        long startTime=System.currentTimeMillis(); // 1 jan 1970
//        ExecutorService executor= Executors.newFixedThreadPool(9);
        ExecutorService executor= Executors.newFixedThreadPool(3);
        Thread[] threads=new Thread[9];
        for(int i=1;i<10;i++){

            int finalans=i;

            Future<?> future= executor.submit(() -> {
                long result = factorial(finalans);
                System.out.println(result);
            });

        }
        executor.shutdown();
//        executor.awaitTermination(100, TimeUnit.SECONDS); // wait for the 100 seconds
        while (!executor.awaitTermination(10,TimeUnit.MILLISECONDS)){ // now, It is waiting for the infinite time
            System.out.println("Waiting ............");
        }


        System.out.println("Total time: "+ (System.currentTimeMillis() - startTime));

    }
}
