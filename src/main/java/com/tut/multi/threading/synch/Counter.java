package com.tut.multi.threading.synch;

public class Counter {
    private int count=0;

    public synchronized void increment(){
        count++;
    }

//    public  void increment(){
//        synchronized (this){
//            count++;
//        }
//    }
    public int getCount(){
        return count;
    }
}
