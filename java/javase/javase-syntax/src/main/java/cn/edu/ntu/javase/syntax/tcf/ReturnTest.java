package cn.edu.ntu.javase.syntax.tcf;

import cn.edu.ntu.javase.common.model.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * https://mp.weixin.qq.com/s/5XZUUpKQElTxNtbFo7IDNQ
 *
 * @author asd <br>
 * @create 2022-10-10 02:08 PM <br>
 * @project javase <br>
 */
@Slf4j
public class ReturnTest {

    public static void main(String[] args) {
        System.out.println(tcfc());
        System.out.println(tcff());
        System.out.println(tcfcf());
        System.out.println(tcfcf2());
    }

    // 10
    public static int tcfc() {
        int a = 10;
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            return a;
        } finally {
            a = 20;
        }
        return 0;
    }

    // 28
    public static Person tcff() {
        Person p = new Person();
        p.setAge(18);
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            return p;
        } finally {
            p.setAge(28);
        }
        return null;
    }

    // 2
    public static int tcfcf() {
        int a = 10;
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            return a;
        } finally {
            return 2;
        }
    }

    // 30
    public static int tcfcf2() {
        int a = 10;
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            a = 20;
            return a;
        } finally {
            a = 30;
            return a;
        }
    }
}
