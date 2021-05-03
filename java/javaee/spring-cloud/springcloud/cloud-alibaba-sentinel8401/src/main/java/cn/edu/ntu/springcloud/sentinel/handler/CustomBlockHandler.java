package cn.edu.ntu.springcloud.sentinel.handler;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author zack <br>
 * @create 2020-04-17 23:01 <br>
 */
public class CustomBlockHandler {

    public static JsonResult customBlockHandler(
            String p1, String p2, BlockException blockException) {
        return new JsonResult(400, "success", "CustomBlockHandler Method");
    }

    public static JsonResult defaultBlockHandler(
            String p1, String p2, BlockException blockException) {
        return new JsonResult(400, "success", "DefaultBlockHandler Method");
    }
}
