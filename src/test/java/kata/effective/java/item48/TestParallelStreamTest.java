package kata.effective.java.item48;

import org.junit.jupiter.api.Test;

class TestParallelStreamTest {

  private final static long LONG_VALUE = 10_000_000;

  @Test
  void worstCase() {
    TestParallelStream.worstCase(false);
  }

  @Test
  void bestCaseParallel() {
    System.out.println(TestParallelStream.bestCase(true, LONG_VALUE));

  }

  @Test
  void bestCaseNonParallel() {
    System.out.println(TestParallelStream.bestCase(false, LONG_VALUE));
  }
}