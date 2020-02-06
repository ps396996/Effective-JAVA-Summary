package kata.effective.java.item39;

public class Sample {

  @Test
  public static void m1() {
  }    // Test pass

  public static void m2() {
  }      // Not test applied

  @Test
  public static void m3() {    // Test fail
    throw new RuntimeException("Boom");
  }

  @Test
  public void m4() {
  }      // Invalid use. Non static method.
}
