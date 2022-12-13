package top.hubby.declare.annos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;


/**
 * 将抑制与varargs使用相关的未检查的警告
 *
 * @author alice2
 */
public class VarargsWaring {
    private static final Logger log = LoggerFactory.getLogger(VarargsWaring.class);

    @SafeVarargs
    public static <T> T useVarargs(T... args) {
        return args.length > 0 ? args[0] : null;
    }

    public static void main(String[] args) {
        log.info("{}", VarargsWaring.useVarargs(Collections.singletonList("array")));
    }
}