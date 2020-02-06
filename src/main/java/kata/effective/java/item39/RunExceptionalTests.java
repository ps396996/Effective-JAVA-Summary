package kata.effective.java.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RunExceptionalTests {

  public static void main(String[] args) throws Exception {
    int tests = 0;
    int passed = 0;
    Class testClass = Class.forName("kata.effective.java.item39.Sample2");
    for (Method m : testClass.getDeclaredMethods()) {
      if (m.isAnnotationPresent(ExceptionTest.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
        tests++;
        try {
          m.invoke(null);
          System.out.println(m + " failed: no exception");
        } catch (InvocationTargetException wrappedExc) {
          Throwable exc = wrappedExc.getCause();
          final ExceptionTest[] excTypes = m.getAnnotationsByType(ExceptionTest.class);

          if (Arrays.stream(excTypes).anyMatch(excType -> excType.value().isInstance(wrappedExc.getCause()))) {
            passed++;
          } else {
            System.out.printf("%s failed with %s \n", m, wrappedExc.getCause());
          }
        } catch (Exception exc) {
          System.out.println("INVALID @Test: " + m);
        }
      }
    }
    System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
  }
}
