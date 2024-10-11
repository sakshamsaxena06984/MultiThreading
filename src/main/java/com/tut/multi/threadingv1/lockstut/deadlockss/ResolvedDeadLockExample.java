package com.tut.multi.threadingv1.lockstut.deadlockss;


class PaperV1{
    public synchronized void writeWithPaperAndPen(PenV1 pen){
        System.out.println(Thread.currentThread().getName()+ " is using paper "+ this + " and trying ");
        pen.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finished using paper "+this);
    }

}

class PenV1 {
    public synchronized void writeWithPenAndPaper(PaperV1 paper){
        System.out.println(Thread.currentThread().getName()+" is using pen "+ this + "and trying ");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finished using pen "+this);
    }
}
class Task1V1 implements Runnable{
    private PenV1 penV1;
    private PaperV1 paperV1;

    public Task1V1(PenV1 penV1, PaperV1 paperV1){
        this.penV1=penV1;
        this.paperV1=paperV1;
    }

    @Override
    public void run(){
        penV1.writeWithPenAndPaper(paperV1); //thread1 locks paper and tries to lock pen
    }

}

class Task2V1 implements Runnable{
    private PenV1 penV1;
    private PaperV1 paperV1;

    public Task2V1(PenV1 penV1, PaperV1 paperV1){
        this.penV1=penV1;
        this.paperV1=paperV1;
    }

    @Override
    public void run(){
        synchronized (penV1){
            paperV1.writeWithPaperAndPen(penV1);
        }

    }
}


public class ResolvedDeadLockExample {
    public static void main(String[] args) {
        PenV1 penV1=new PenV1();
        PaperV1 paperV1=new PaperV1();
        Thread thread1=new Thread(new Task1V1(penV1, paperV1), "Thread-1");
        Thread thread2 = new Thread(new Task2V1(penV1, paperV1), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
