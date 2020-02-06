package kata.effective.java.item38;

public enum ExtendedOperation implements Operation {
  MOD("%") {
    @Override
    public double apply(double x, double y) {
      return x % y;
    }
  },
  EXP("^") {
    @Override
    public double apply(double x, double y) {
      return Math.pow(x, y);
    }
  };


  private final String symbol;

  ExtendedOperation(String symbol) {
    this.symbol = symbol;
  }
}
