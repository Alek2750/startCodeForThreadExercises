package day3_4.exam;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//This is the class template for the four Producer Threads P1-P4 in the exercise figure
public class Producer implements Runnable {

    public static final int MAX_NUMBERS_TO_PRODUCE = 10;
    public static final int MAX_RANDOM = 100;
    
      private int fib(int n) {
      if ((n == 0) || (n == 1)) {
          return n;
      } else {
          return fib(n - 1) + fib(n - 2);
      }
  }
    
  BlockingQueue<Long> queue;

  public Producer(BlockingQueue queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
      Random rand = new Random();
      for (int i = 0; i < MAX_NUMBERS_TO_PRODUCE; i++) {
          long fibNumb = fib(i);
      try {
          queue.put(fibNumb);
          
      } catch(Exception ex) {
        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    }
    
  }

