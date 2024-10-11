package com.tut.multi.threadingv1.threadpooling.scheduleexcutorser;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        //**** below one for schedule delay
//        scheduler.schedule(
//                () -> System.out.println("Task executed after 5 second delay !"),
//                5,
//                TimeUnit.SECONDS);
//                scheduler.shutdown();

        //**** below one for schedule delay with period interval
        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Task executed after 5 second delay !"),
                5,
                 5,
                TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture= scheduler.scheduleWithFixedDelay(() -> System.out.println("Task executed after 5 second delay !"),
                5,
                5, // delay....
                TimeUnit.SECONDS);


        scheduler.schedule(() -> {
             System.out.println("Initiating shutdown....");
             scheduler.shutdown();
         }, 20, TimeUnit.SECONDS);
    }
}
