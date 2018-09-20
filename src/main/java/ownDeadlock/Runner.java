/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ownDeadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Alek
 * 
 * Der er 2 løsninger til en Deadlock situation.
 *  1. Sørg for at lock sker i samme rækkefølge.
 *  2. Lav en metode der kan tage sig af det.
 */
public class Runner {
    
    private Account acc1 = new Account();
    private Account acc2 = new Account();
    
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    
//    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
//        while(true) {
//            // get Locks
//            boolean gotFirstLock = false;
//            boolean gotSecondLock = false;
//            
//            try {
//                gotFirstLock = firstLock.tryLock();
//                gotSecondLock = secondLock.tryLock();
//            }
//            finally {
//                if(gotFirstLock && gotSecondLock) {
//                    return;
//                }
//                if(gotFirstLock) {
//                    firstLock.unlock();
//                }
//                if(gotSecondLock) {
//                    secondLock.unlock();
//                }
//            }
//            
//            // Did not get Locks
//            Thread.sleep(1);
//        }
//    }
    
    public void firstThread() throws InterruptedException {
        Random rand = new Random();
    
        for (int i = 0; i < 10000; i++) {
            
            lock1.lock();
            lock2.lock();
            
//            acquireLocks(lock1, lock2);
            
            try {
          Account.transfer(acc1, acc2, rand.nextInt(100));
        }
        finally {
            lock1.unlock();
            lock2.unlock();
        }
    }
    }
    
    public void secondThread() throws InterruptedException {
        Random rand = new Random();
    
        for (int i = 0; i < 10000; i++) {
            
            lock2.lock();
            lock1.lock();
            
//            acquireLocks(lock2, lock1);
            
            try {
          Account.transfer(acc2, acc1, rand.nextInt(100));  
        }
            finally {
                lock2.unlock();
                lock1.unlock();
            }
    }
    }
    
    public void finished() {
        
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}
