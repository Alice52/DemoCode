package java8;

/**
 * @author zack
 * @create 2019-11-17 12:57
 * @function
 */
public class Key {

    private final int value;

    public Key(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;

        Key key = (Key) o;

        return value == key.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
