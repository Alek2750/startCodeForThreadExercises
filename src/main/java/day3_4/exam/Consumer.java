/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_4.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonners
 */
public class Consumer implements Runnable {

    ArrayBlockingQueue<Long> numbersProduced;

    public Consumer(ArrayBlockingQueue<Long> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }

    int sumTotal = 0;
    List<Long> MyFibNumbers = new ArrayList();
    
    @Override
    public void run() {
        //In this exercise, we start four threads, each producing x numbers, so we know how much to consume
        for (int i = 0; i < 40; i++) {
            
            try {
                Long currNumber = numbersProduced.take();
                MyFibNumbers.add(currNumber);
                sumTotal += currNumber;
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }

    public int getSumTotal() {
        return sumTotal;
    }

    public List<Long> getMyFibNumbers() {
        return MyFibNumbers;
    }
    
    

}
