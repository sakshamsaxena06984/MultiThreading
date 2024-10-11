package com.tut.multi.threadingv1.threadpooling;

import java.util.concurrent.Executors;

public class ExecuterTut {
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(1);
        Executors.newFixedThreadPool(2);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool(); // use for load variable
    }
}
