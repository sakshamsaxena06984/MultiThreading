package com.tut.multi.threadingv1.threadpooling;

import java.util.concurrent.*;

class DependentService implements Callable<String>{
    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public String call() throws Exception{
        System.out.println(Thread.currentThread().getName()+ " service started...");
        try {
            Thread.sleep(1000);
        }finally {
            latch.countDown();
        }
        return "OK";
    }
}
public class CountDownLatchTut {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService= Executors.newFixedThreadPool(3);
//        Future<String> f1= executorService.submit(new DependentService());
//        Future<String> f2= executorService.submit(new DependentService());
//        Future<String> f3= executorService.submit(new DependentService());
//
//        f1.get();
//        f2.get();
//        f3.get();
//        System.out.println("All dependencies done");
//        executorService.shutdown();

        int numberOfService=3;
        ExecutorService executorService= Executors.newFixedThreadPool(numberOfService);
        CountDownLatch latch = new CountDownLatch(numberOfService);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.wait();
        System.out.println("Main");
        executorService.shutdown();

    }

}
