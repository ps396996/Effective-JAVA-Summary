package kata.effective.java.item33;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FavoritesImplTest {


  @Test
  void testFavorites() {
    Favorites f = new FavoritesImpl();
    f.putFavorites(String.class, "JAVA");
    f.putFavorites(Integer.class, 0xcafecace);
    f.putFavorites(Class.class, Favorites.class);

    String s = f.getFavorite(String.class);
    int i = f.getFavorite(Integer.class);
    Class<?> c = f.getFavorite(Class.class);


    assertEquals(s, "JAVA");
    assertEquals(i, 0xcafecace);
    assertEquals(c, Favorites.class);
  }

}