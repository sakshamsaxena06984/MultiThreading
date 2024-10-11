package com.tut.multi.threadingv1.threadpooling.executerframework;

import java.util.concurrent.Callable;

public class CollableTest implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(122);
        return null;
    }
}
