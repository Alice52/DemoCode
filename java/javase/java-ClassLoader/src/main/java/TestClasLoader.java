class SuperClass {
  static {
    System.out.println("SuperClass init!");
  }

  public static int value = 123;
}

class SubClass extends SuperClass {
  static {
    System.out.println("SubClass init!");
  }
}

public class TestClasLoader {
  public static void main(String[] args) throws Exception {
    // System.out.println(SubClass.value); //SuperClass init! //123
    // SubClass subClass = new SubClass(); // SuperClass init! // "SubClass init!"
    // 通过数组定义来引用类, 不会触发此类的初始化.
    SuperClass[] sca = new SuperClass[10]; // no print
  }
}
