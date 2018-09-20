/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_4.exam;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gonners
 */
public class Tester {
    
    public static void main(String[] args) throws InterruptedException {
        
    ArrayBlockingQueue<Long> fibNumber = new ArrayBlockingQueue(5);
    
    ExecutorService es = Executors.newCachedThreadPool();
    //Create and start four producers (P1-P4 in the exercise-figure)
    es.execute(new Producer(fibNumber));
    es.execute(new Producer(fibNumber));
    es.execute(new Producer(fibNumber));
    es.execute(new Producer(fibNumber));
     
    //Create and start single consumer (C1 in the exercise-figure)
    Consumer consumer = new Consumer(fibNumber);
    es.execute(consumer);    
    
    
    es.shutdown();
    es.awaitTermination(10, TimeUnit.SECONDS);
    
    System.out.println("Sum of Fibonacci: " + consumer.getSumTotal()/4);
    System.out.println("List of Fibonacci: " + consumer.getMyFibNumbers());
    
    }    
}
