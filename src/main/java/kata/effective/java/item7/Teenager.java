package kata.effective.java.item7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Teenager {

  private static final Logger logger = LoggerFactory.getLogger(Teenager.class);

  public static void main(String[] args) {
    new Room(9);
    System.gc();
    logger.info("Peace out!!!");
  }
}
