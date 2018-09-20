/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1.ex;

/**
 *
 * @author Alek
 */
public class Even {
  private static int n = 0;
  public int next() {
    n++;
    n++;
    return n;
  }
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " - Number: " + n);
            }
        };
        Thread t1 = new Thread(new Thread(r), "Thread1");
        t1.start(); // .run gør at det kører på samme Thread, skal man være opmærksom på det ikke skal ske. t1.run();
        //t1.join();
        Thread t2 = new Thread(new Thread(r), "Thread2");
        t2.start();
        //t2.join();
        
    }

    }

