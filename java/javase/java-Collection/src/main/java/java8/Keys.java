package java8;

/**
 * @author zack
 * @create 2019-11-17 12:52
 * @function
 */
public class Keys {

  private static final int MAX_KEY = 10000000;

  private static final Key[] KEY_CACHE = new Key[MAX_KEY];

  static {
    for (int i = 0; i < MAX_KEY; ++i) {
      KEY_CACHE[i] = new Key(i);
    }
  }

  public static Key index(int value) {
    return KEY_CACHE[value];
  }
}
