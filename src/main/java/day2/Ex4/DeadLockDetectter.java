/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2.Ex4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author Gonners
 */
public class DeadLockDetectter extends Thread {

    ThreadMXBean bean = ManagementFactory.getThreadMXBean();

    @Override
    public void run() {
        while (true) {
            long[] threadIds = bean.findDeadlockedThreads();
            if (threadIds == null) {
                System.out.println("DeadLock Detected!");
            } else {
                System.out.println("No deadlocks");
            }
        }
    }

}
