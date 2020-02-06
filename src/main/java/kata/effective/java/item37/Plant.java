package kata.effective.java.item37;

class Plant {

  enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

  final String name;
  final LifeCycle lifeCycle;

  Plant(String name, LifeCycle lifeCycle) {
    this.name = name;
    this.lifeCycle = lifeCycle;
  }

  @Override
  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }

  public LifeCycle getLifeCycle() {
    return lifeCycle;
  }
}
