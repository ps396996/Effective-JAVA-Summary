package kata.effective.java.item33;


import java.util.HashMap;
import java.util.Map;

public class FavoritesImpl implements Favorites {

  private Map<Class<?>, Object> favorites = new HashMap<>();

  @Override
  public <T> void putFavorites(Class<T> type, T instance) {
    if (type == null) {
      throw new NullPointerException("Type is null");
    }
    favorites.put(type, type.cast(instance));//runtime safety with a dynamic cast
  }

  @Override
  public <T> T getFavorite(Class<T> type) {
    return type.cast(favorites.get(type));
  }
}