package kata.effective.java.item32;

import java.util.ArrayList;
import java.util.List;

public class Vargs {

  static <T> T[] toArray(T... args) {
    return args;
  }

  // Mixing generics and varargs can violate type safety!
  static void dangerous(List<String>... stringLists) {
    List<Integer> intList = List.of(42);
    Object[] objects = stringLists;
    objects[0] = intList;// Heap pollution
    String s = stringLists[0].get(0); // ClassCastException
  }


  // Safe method with a generic varargs parameter
  @SafeVarargs
  static <T> List<T> flatten(List<? extends T>... lists) {
    List<T> result = new ArrayList<>();
    for (List<? extends T> list : lists) {
      result.addAll(list);
    }
    return result;
  }
}