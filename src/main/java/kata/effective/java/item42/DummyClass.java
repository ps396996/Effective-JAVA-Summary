package kata.effective.java.item42;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DummyClass {


  static class Card {

    Rank rank;
    Suit suit;

    public Card(Rank rank, Suit suit) {
      this.rank = rank;
      this.suit = suit;
    }
  }

  static class Suit {

    static Suit[] values() {
      return new Suit[0];
    }


  }

  static class Rank {

    static Rank[] values() {
      return new Rank[1];
    }
  }

  private static List<Card> newDeck() {
    List<Card> result = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        result.add(new Card(rank, suit));
      }
    }
    return result;
  }

  private static List<Card> newDeckByStream() {
    return Stream.of(Suit.values())
        .flatMap(suit -> Stream.of(Rank.values())
            .map(rank -> new Card(rank, suit)))
        .collect(Collectors.toList());
  }

  // Adapter from Iterable<E> to Stream<E>
  public static <E> Stream<E> streamOf(Iterable<E> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false);
  }
}
