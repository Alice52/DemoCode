package cn.edu.ntu.springcloud.sentinel.handler;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * this can optimize by use openfeign
 *
 * @author zack <br>
 * @create 2020-04-18 12:28 <br>
 */
public class CustomFallbackHandler {

    public static JsonResult defaultFallbackHandler(
            String p1, String p2, BlockException blockException) {
        return new JsonResult(400, "success", "DefaultFallbackHandler Method");
    }
}
