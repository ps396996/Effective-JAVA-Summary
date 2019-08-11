package kata.effective.java.item7;

import java.lang.ref.Cleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Room implements AutoCloseable {

  private static final Logger logger = LoggerFactory.getLogger(Room.class);
  private static final Cleaner cleaner = Cleaner.create();
  // The state of this room, shared with our cleanable
  private final State state;
  // Our cleanable. Cleans the room when it’s eligible for gc
  private final Cleaner.Cleanable cleanable;

  public Room(int numJunkPiles) {
    state = new State(numJunkPiles);
    cleanable = cleaner.register(this, state);
  }

  @Override
  public void close() throws Exception {
    cleanable.clean();
  }

  // Resource that requires cleaning. Must not refer to Room!
  private static class State implements Runnable {

    int numJunkPiles; // Number of junk piles in this room

    State(int numJunkPiles) {
      this.numJunkPiles = numJunkPiles;
    }

    // Invoked by close method or cleaner
    @Override
    public void run() {
      logger.info("Cleaning room");
      numJunkPiles = 0;
    }
  }
}
