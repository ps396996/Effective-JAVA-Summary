package kata.effective.java.item32;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class VargsTest {


  @Test()
  void vargsTest() {
    assertThrows(ClassCastException.class, () -> Vargs.dangerous(List.of("asd"), List.of("asd")));
  }

  @Test
  void vargsTest2() {
    final String[] response = Vargs.toArray("ONE", "TWO");
    assertEquals(response[0], "ONE");
    assertEquals(response[1], "TWO");

    final Integer[] response2 = Vargs.toArray(2, 3);
    assertEquals(response2[0], 2);
    assertEquals(response2[1], 3);
  }

}