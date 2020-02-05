package kata.effective.java.item31;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class StackTest {


  @Test
  void testStack() {
    Stack<Number> numberStack = new Stack<>();
    Iterable<Integer> integers = Iterables.cycle(1, 4, 5);
    numberStack.pushAll(integers);
    numberStack.popAll(Collections.emptyList());
  }

  @Test
  void testUnion() {
    Set<Integer> integers = Sets.newHashSet(1, 2, 3);
    Set<Double> doubles = Sets.newHashSet(1.9, 2.3, 3.4);

    Set<Integer> numbers = union(integers, integers);
    Set<Number> numbers2 = union(integers, doubles);
  }


  public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>();
    result.addAll(s1);
    result.addAll(s2);
    return result;
  }


  @Test
  void testMax() {
    List<Integer> integers = List.of(1, 3, 4, 5);
    List<Double> doubles = List.of(1.2, 3.3, 5.6, 6.7);

    Number asd = max(integers);
    Number asd2 = max(doubles);

  }

  public static <T extends Comparable<T>> T max(List<T> list) {
    return Collections.max(list);
  }

}