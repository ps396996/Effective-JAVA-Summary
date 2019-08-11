package kata.effective.java.item7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Adult {

  private static final Logger logger = LoggerFactory.getLogger(Adult.class);

  public static void main(String[] args) {
    try (Room room = new Room(7)) {
      logger.info("Goodbye!!!");
    } catch (Exception e) {
      logger.error(e.getMessage(), e.getCause());
    } finally {
      logger.info("Finally!!!");
    }
  }
}
