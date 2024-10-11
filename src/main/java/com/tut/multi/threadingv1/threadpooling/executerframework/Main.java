package com.tut.multi.threadingv1.threadpooling.executerframework;

public class Main {
    private static long factorial(int n) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        long result = 1;
        for(int i=1;i<=n;i++){
            result*=i;
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {

        long startTime=System.currentTimeMillis(); // 1 jan 1970
        Thread[] threads=new Thread[9];
        for(int i=1;i<10;i++){
//            int finalI = i;
//            Thread thread= new Thread(() -> {
//
//                try {
//                   long result = factorial(finalI);
//                    System.out.println(result);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            });
//            thread.start();

            int finalans=i;
            threads[i-1]= new Thread(
                    ()->{
                            long result = factorial(finalans);
                            System.out.println(result);
                    }
            );
            threads[i-1].start();
        }
        for(Thread thread:threads){
            try {
                thread.join();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
//        System.out.println(factorial(i));

        System.out.println("Total time: "+ (System.currentTimeMillis() - startTime));

    }
}
