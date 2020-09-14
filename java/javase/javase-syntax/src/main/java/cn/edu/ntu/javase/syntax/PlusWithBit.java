package cn.edu.ntu.javase.syntax;

/**
 * @author zack <br>
 * @create 2020-09-12 14:08 <br>
 * @project javase <br>
 */
public class PlusWithBit {

  public static int[] add(String a, String b) {
    String[] strs = prepare(a, b);
    a = strs[0];
    b = strs[1];

    int n = a.length();
    // may gt 10
    int[] res = new int[n + 1];
    int num1, num2, num;

    // start from lowest bit
    for (int i = n - 1; i >= 0; i--) {
      num1 = Integer.parseInt(a.substring(i, i + 1));
      num2 = Integer.parseInt(b.substring(i, i + 1));
      num = num1 + num2;
      num += res[i + 1];

      res[i + 1] = (num % 10);
      res[i] = num / 10;
    }

    return res;
  }

  /**
   * supply zero to same length.
   *
   * @param a
   * @param b
   * @return
   */
  public static String[] prepare(String a, String b) {
    String[] strings = new String[2];
    for (int i = 0; i < strings.length; i++) {
      strings[i] = "";
    }
    if (a.length() > b.length()) {
      b = doFormat(b, a.length());
    } else if (a.length() < b.length()) {
      a = doFormat(a, b.length());
    }
    strings[0] = a;
    strings[1] = b;
    return strings;
  }

  public static String doFormat(String str, int n) {
    String newStr = "";
    for (int i = 0; i < n - str.length(); i++) {
      newStr += "0";
    }
    return newStr + str;
  }

  public static void main(String[] args) {
    String strA = "123";
    String strB = "987";
    int[] result = add(strA, strB);
    System.out.print("\t");
    for (int i = 0; i < result.length; i++) {
      if (result[i] == 0 && i == 0) {
        continue;
      }
      System.out.print(result[i]);
    }
  }
}
