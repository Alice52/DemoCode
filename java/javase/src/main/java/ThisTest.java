/**
 * @author zack
 * @create 2019-06-07 13:08
 * @function this is for test this scope.
 */
public class ThisTest {
    private int a = 30;
    public void test(int b) {  // b = 5
        {
            int a = 26;
            {
                // 30
                System.out.println(this.a);
                int c = 560;
                this.a = c;
                // 26
                System.out.println(a);
                // 560
                System.out.println(this.a);
                //true
                System.out.println(this instanceof ThisTest);
            }
            //560
            System.out.println(this.a);
        }
        // 560
        System.out.println(a);
    }

    public static void main(String[] args) {
        ThisTest test1 = new ThisTest();
        test1.test(5);
        //560
        System.out.println(test1.a);
    }
}
