package common.test;

import cn.edu.ntu.javaee.boot.common.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2021-05-13 13:31 <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class SyntaxTest {

    /**
     * try-finally value change issue:
     *
     * <pre>
     *     1. 基本类型在 finally 中修改, 且之前已经返回, 则 finally 中的修改是无效的.
     *     2. 引用类型在 finally 中修改, 且之前已经返回, 则 finally 中的修改是有效的.
     *     3. finally 保护问题:
     *        - 如果 finally 中有 return 则不存在返回值保护;
     *        - 否则存在返回值保护, finally 无法修改 try 中的返回值[引用类型则是不能修改返回值地址]
     * </pre>
     */
    @Test
    public void testTry() {
        assert changeBasicInFinally() == 1;
        assert changeReferenceInFinally().name().equals("tim");
        assert returnBasicInFinally() == 2;
    }

    public int changeBasicInFinally() {
        int i;
        try {
            i = 1;
            return i;
        } finally {
            i = 2;
        }
    }

    public int returnBasicInFinally() {
        int i;
        try {
            i = 1;
            return i;
        } finally {
            i = 2;
            return i;
        }
    }

    public Person changeReferenceInFinally() {
        Person person = Person.builder().age(18).name("zack").build();
        try {
            return person;
        } finally {
            person.name("tim");
        }
    }
}
