package com.tut.multi.threadingv1.threadpooling.executerframework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MainV1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<?> future= executorService.submit(() -> System.out.println("Hello"));
//        future.get();
//        executorService.shutdown();
//        Future<String> submit= executorService.submit(() -> System.out.println("Hello"), "abc");

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Future<Integer> submit= executorService.submit(() -> 1 + 2);
//        Integer i = submit.get();
//        System.out.println("sum is "+i);
//        executorService.shutdown();
//        System.out.println(executorService.isShutdown());
//        Thread.sleep(12);
//        System.out.println(executorService.isTerminated());

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        Callable callable = () -> {
//            System.out.println("task-1");
//            return 1;
//        };
//        Callable callable1 = () -> {
//            System.out.println("task-2");
//            return 2;
//        };
//        Callable callable2 = () -> {
//            System.out.println("task-3");
//            return 3;
//        };
//
//        List<Callable<Integer>> lists= Arrays.asList(callable, callable1, callable2);
//
//        List<Future<Integer>> futures= executorService.invokeAll(lists);
//
//        for (Future<Integer> f:futures){
//            System.out.println(f.get());
//        }
//
//
//        executorService.shutdown();



//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        Callable callable = () -> {
//            Thread.sleep(1000);
//            System.out.println("task-1");
//            return 1;
//        };
//        Callable callable1 = () -> {
//            Thread.sleep(1000);
//            System.out.println("task-2");
//            return 2;
//        };
//        Callable callable2 = () -> {
//            Thread.sleep(1000);
//            System.out.println("task-3");
//            return 3;
//        };
//
//        List<Callable<Integer>> lists= Arrays.asList(callable, callable1, callable2);
//
//        List<Future<Integer>> futures= executorService.invokeAll(lists,1, TimeUnit.SECONDS);
//
//        for (Future<Integer> f:futures){
//            System.out.println(f.get());
//        }
//
//
//        executorService.shutdown();


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable callable = () -> {
            Thread.sleep(1000);
            System.out.println("task-1");
            return 1;
        };
        Callable callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("task-2");
            return 2;
        };
        Callable callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("task-3");
            return 3;
        };

        List<Callable<Integer>> lists= Arrays.asList(callable, callable1, callable2);

        try {
            Integer i= executorService.invokeAny(lists);
            System.out.println(i);
        }catch (InterruptedException e){

        }catch (ExecutionException e){

        }



        executorService.shutdown();

    }
}
