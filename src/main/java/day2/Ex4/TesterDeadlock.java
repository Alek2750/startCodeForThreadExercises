package Day2.Ex4;

import java.util.logging.Level;
import java.util.logging.Logger;


public class TesterDeadlock {
  public static void main(String[] args) {
      
    try {
        
      DeadLockDetectter deadlockDetecter = new DeadLockDetectter();
      Thread dl1 = new Thread(deadlockDetecter);
      Thread dl2 = new Thread(deadlockDetecter);
      
      dl1.start();
      dl2.start();
      
      dl2.join();
      dl2.join();
        
      ResourceContainer resources = new ResourceContainer();
      ResourceUser1 t1 = new ResourceUser1(resources);
      ResourceUser2 t2 = new ResourceUser2(resources);
      
      t1.start();
      t2.start();
          
      t1.join();
      t2.join();
      
      System.out.println("Done");
      System.out.println("Words produced: "+resources.getResourceWords().size());
      System.out.println("Numbers produced: "+resources.getResourceNumbers().size());
    } catch (InterruptedException ex) {
      Logger.getLogger(TesterDeadlock.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
