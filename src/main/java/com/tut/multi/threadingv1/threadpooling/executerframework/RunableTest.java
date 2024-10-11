package com.tut.multi.threadingv1.threadpooling.executerframework;

public class RunableTest implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(122);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
