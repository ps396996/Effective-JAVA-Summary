package kata.effective.java.item31;

import com.google.common.collect.Iterables;
import org.junit.jupiter.api.Test;

class StackTest {


  @Test
  void testStack() {
    Stack<Number> numberStack = new Stack<>();
    Iterable<Integer> integers = Iterables.cycle(1, 4, 5);
    numberStack.pushAll(integers);
  }

}