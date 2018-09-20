/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ownDeadlock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alek
 */
public class Tester {

    public static void main(String[] args) throws InterruptedException {

        final Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();

    }
}
