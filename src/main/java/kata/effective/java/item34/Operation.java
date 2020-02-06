package kata.effective.java.item34;

public enum Operation {
  PLUS {
    double apply(double x, double y) {
      return x + y;
    }
  },
  MINUS {
    double apply(double x, double y) {
      return x - y;
    }
  },
  TIMES {
    double apply(double x, double y) {
      return x * y;
    }
  },
  DIVIDE {
    double apply(double x, double y) {
      return x / y;
    }
  };

  // The abstract method force us not to forget to implement the method.
  abstract double apply(double x, double y);

}
