package boot.web.limit.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

import java.util.OptionalLong;

/**
 * @author zack <br>
 * @create 2021-04-19 08:44 <br>
 * @project integration <br>
 */
public class Uuid {
    // 1383945030787534848
    // 1383945091923709952
    public static void main(String[] args) {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        OptionalLong.of(snowflake.nextId()).ifPresent(System.out::println);
    }
}
