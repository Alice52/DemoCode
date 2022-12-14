package cn.edu.ntu.java.javase.enumeration.collections;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

enum UserStatus {
    A1,
    A2;
}

enum MoreUserStatus {
    A1,
    A2,
    A3,
    A4,
    A5,
    A6,
    A7,
    A8,
    A9,
    A10,
    A11,
    A12,
    A13,
    A14,
    A15,
    A16,
    A17,
    A18,
    A19,
    A20,
    A21,
    A22,
    A23,
    A24,
    A25,
    A26,
    A27,
    A28,
    A29,
    A30,
    A31,
    A32,
    A33,
    A34,
    A35,
    A36,
    A37,
    A38,
    A39,
    A40,
    A41,
    A42,
    A43,
    A44,
    A45,
    A46,
    A47,
    A48,
    A49,
    A50,
    A51,
    A52,
    A53,
    A54,
    A55,
    A56,
    A57,
    A58,
    A59,
    A60,
    A61,
    A62,
    A63,
    A64,
    A65,
    A66,
    A67,
    A68,
    A69,
    A70,
    A71,
    A72,
    A73,
    A74,
    A75,
    A76,
    A77,
    A78,
    A79,
    A80,
    A81,
    A82,
    A83,
    A84,
    A85,
    A86,
    A87,
    A88,
    A89,
    A90,
    A91,
    A92,
    A93,
    A94,
    A95,
    A96,
    A97,
    A98,
    A99,
    A100;
}

/**
 * - RegularEnumSet: enum number is less than 64; <br>
 * - JumboEnumSet: enum number is less than 64 <br>
 * <br>
 * - copyOf: create EnumSet use provided Set <br>
 * - noneOf: null Set <br>
 * - allOf: use provided Set to create EnumSet <br>
 * - of: use enum to create EnumSet - range: according to ordinal to define ranged EnumSet<br>
 *
 * @author zack <br>
 * @create 2020-01-31 18:23 <br>
 */
public class EnumSetTest {
    private static final Logger LOG = LoggerFactory.getLogger(EnumSetTest.class);

    @Test
    public void typeTest() {
        EnumSet<UserStatus> userStatusesSet = EnumSet.allOf(UserStatus.class);
        LOG.info(String.valueOf(userStatusesSet.size()));
        userStatusesSet.stream().forEach(System.out::println);
        LOG.info("userStatusSet:" + userStatusesSet.getClass());

        EnumSet<MoreUserStatus> moreUserStatusesSet = EnumSet.noneOf(MoreUserStatus.class);
        LOG.info("moreUserStatusesSet:" + moreUserStatusesSet.getClass());
    }
}
