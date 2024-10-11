package com.tut.multi.threadingv1.threadpooling.executerframework;

import java.util.concurrent.*;

public class FutherMethod {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future=executorService.submit(() -> {
            try {
                Thread.sleep(2000);

            }catch (InterruptedException e){
                System.out.println("Exception occurred : "+e);
            }
            return 42;
        });

        //****** use of get {with/without time}
//        Integer i =null;
//        try {
//            System.out.println(future.isDone());
////            i = future.get(); // get() without waiting the time
//            i = future.get(1, TimeUnit.SECONDS); // get() with waiting time
//            System.out.println(future.isDone());
//            System.out.println(i);
//        }catch (InterruptedException | ExecutionException e){
//            System.out.println(e.getCause());
//        } catch (TimeoutException e) {
//            throw new RuntimeException(e);
//        }

        // ****** use of Future Cancel method
        future.cancel(true);
        System.out.println(future.isCancelled());
        executorService.shutdown();
    }
}
