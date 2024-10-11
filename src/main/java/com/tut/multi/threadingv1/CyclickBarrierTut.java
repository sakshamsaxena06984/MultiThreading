package com.tut.multi.threadingv1;

import java.util.concurrent.*;

class DependentService implements Callable<String>{
    private final CyclicBarrier barrier;

    public DependentService(CyclicBarrier barrier){
        this.barrier=barrier;
    }

    @Override
    public String call() throws Exception{

            System.out.println(Thread.currentThread().getName()+ " service started...");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+ " is waiting at the barrier ...");
            barrier.await(); // At this point, These are waiting for other threads.....

        return "OK";
    }
}
public class CyclickBarrierTut {
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
        CyclicBarrier barrier = new CyclicBarrier(numberOfService);
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        System.out.println("Main");
//        barrier.reset(); // for re-set
        executorService.shutdown();

    }

}
