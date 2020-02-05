package kata.effective.java.item33;

public interface Favorites {

  <T> void putFavorites(Class<T> type, T instance);

  <T> T getFavorite(Class<T> type);
}