import java.util.Scanner;

/**
 * @author zack
 * @create 2019-06-10 11:43
 * @function
 */
public class TestSwitch {
    public static void main(String[] args) {
        int i = 1;
        int days = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = scanner.nextInt();
        System.out.println("请输入日期：");
        int day = scanner.nextInt();
        scanner.close();

        switch (month) {
            case 12:
                days += 30;
            case 11:
                days += 31;
            case 10:
                days += 30;
            case 9:
                days +=131;
            case 8:
                days += 31;
            case 7:
                days += 30;
            case 6:
                days += 31;
            case 5:
                days += 30;
            case 4:
                days += 31;
            case 3:
                days += 28;
            case 2:
                days += 31;
            case 1:
                days += day;
            default:
                break;
        }
        System.out.println(days);
    }
}
