package kata.effective.java.item39;

public class Sample2 {

  @ExceptionTest(ArithmeticException.class)
  public static void m1() {
    int i = 0;
    i = i / i;
  }

  @ExceptionTest(ArithmeticException.class)
  @ExceptionTest(ArrayIndexOutOfBoundsException.class)
  public static void m2() {
    throw new ArrayIndexOutOfBoundsException("asd");
  }

  @ExceptionTest(RuntimeException.class)
  public static void m3() {    // Test fail
    throw new RuntimeException("Boom");
  }

  @ExceptionTest(ArithmeticException.class)
  public void m5() {

  }
}
