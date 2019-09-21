/** */
@FunctionalInterface
public interface FilterInterface<T> {
  boolean condition(T t);
}
