package queue;

public interface pool<T> {
  void put(T item);
  T get();
}