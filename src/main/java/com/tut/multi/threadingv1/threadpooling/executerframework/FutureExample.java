package com.tut.multi.threadingv1.threadpooling.executerframework;

//import java.util.concurrent.Executo rService;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Callable callable = () -> "Hello";
//        Future<Integer> future= executorService.submit(() -> 42);
        Future<Integer> future= executorService.submit(callable);
        System.out.println(future.get());
        if (future.isDone()){
            System.out.println("Working fine.........");
        }
        executorService.shutdown();
    }
}
