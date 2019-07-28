/**
 * @author zack
 * @create 2019-06-07 13:08
 * @function
 */
public class TestThis {
    private int a = 30;
    public void test(int b) {  // b = 5
        {
            int a = 26;
            {
                int c = 560;
                this.a = c;
                System.out.println(a);  // 26
                System.out.println(this.a);  // 560
                System.out.println(this instanceof TestThis);  //true
            }
            System.out.println(this.a);  //560
        }
        System.out.println(a);  // 560
    }

    public static void main(String[] args) {
        TestThis test1 = new TestThis();
        test1.test(5);
        System.out.println(test1.a);  //26
    }
}
