/**
 *
 */
@FunctionalInterface
public interface FilterInterface<T>{
        public boolean condition(T t);
}