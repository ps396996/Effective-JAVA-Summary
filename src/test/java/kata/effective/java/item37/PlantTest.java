package kata.effective.java.item37;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import kata.effective.java.item37.Plant.LifeCycle;
import org.junit.jupiter.api.Test;

class PlantTest {

  private final static List<Plant> GARDEN = List.of(
      new Plant("A", LifeCycle.ANNUAL),
      new Plant("B", LifeCycle.BIENNIAL),
      new Plant("C", LifeCycle.PERENNIAL),
      new Plant("D", LifeCycle.ANNUAL),
      new Plant("E", LifeCycle.BIENNIAL),
      new Plant("P", LifeCycle.PERENNIAL),
      new Plant("K", LifeCycle.PERENNIAL)

  );

  @Test
  void toMapWithListValueTraditional() {
    Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
    for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
      plantsByLifeCycle.put(lc, new HashSet<>());
    }
    for (Plant p : GARDEN) {
      plantsByLifeCycle.get(p.lifeCycle).add(p);
    }
    System.out.println(plantsByLifeCycle);
  }

  @Test
  void toMapWithListValue(){
    final Map<LifeCycle, List<Plant>> collectedMap = GARDEN.stream().collect(Collectors.groupingBy(Plant::getLifeCycle));
    System.out.println(collectedMap);
  }

  @Test
  void toEnumMapWithListValue(){
    final EnumMap<LifeCycle, List<Plant>> collectedEnumMapWithList = GARDEN.stream()
        .collect(Collectors.groupingBy(
            Plant::getLifeCycle,
            () -> new EnumMap<>(LifeCycle.class),
            Collectors.toList())
        );
    System.out.println(collectedEnumMapWithList);
  }

  @Test
  void toEnumMapWithSetValue(){
    final EnumMap<LifeCycle, Set<Plant>> collectedEnumMap = GARDEN.stream()
        .collect(Collectors.groupingBy(
            Plant::getLifeCycle,
            () -> new EnumMap<>(LifeCycle.class),
            Collectors.toSet())
        );
    System.out.println(collectedEnumMap);
  }

}