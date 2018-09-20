package day1.ex;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alek
 */

public class Ex2 {
    public static void main(String[] args) throws InterruptedException {
        boolean isRunning = true;
        int counter = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
               
            }
        };
        Thread t1 = new Thread(new MyTask(counter, isRunning), "Thread1");
        Thread t2 = new Thread(new MyTask(counter, isRunning), "Thread2");
        //Thread t3 = new Thread(() -> {System.out.println("From inside the 3rd thread");});
        //Thread t1 = new Thread(r);
        t1.start();  // .run gør at det kører på samme Thread, skal man være opmærksom på det ikke skal ske. t1.run();
        Thread.sleep(5000);
        t2.start();
        //t3.start();
        t1.join();
        t2.join();
        //t3.join();
        System.out.println("Ending the program....");
    }
    static class MyTask implements Runnable{
        private boolean shouldRun = true;     
        private int counter;
        public MyTask (int counter, boolean isRunning) {
            this.counter = counter;
            this.shouldRun = isRunning;
        }
        public void stop(){
            shouldRun = false;
        }
        @Override
        public void run() {
            for (int i =  0; i < 100; i++) {
        counter++;
     System.out.println("Thread" +Thread.currentThread().getName()+ "Counter: " +counter);
        
//            while (shouldRun) {
//                System.out.println("Working....");
//        }
        }
    }
}
}
