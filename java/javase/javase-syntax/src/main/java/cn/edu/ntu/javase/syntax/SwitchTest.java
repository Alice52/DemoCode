package cn.edu.ntu.javase.syntax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Using case with no break, it will execute each case followed by. <br>
 *
 * @author zack
 * @create 2019-06-10 11:43
 */
public class SwitchTest {
  public static void main(String[] args) {
    int days = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("please input month: ");
    int month = scanner.nextInt();
    System.out.println("please input day: ");
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
        days += 131;
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
