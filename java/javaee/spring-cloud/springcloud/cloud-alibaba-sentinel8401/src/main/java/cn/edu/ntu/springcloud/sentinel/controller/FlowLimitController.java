package cn.edu.ntu.springcloud.sentinel.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.sentinel.handler.CustomBlockHandler;
import cn.edu.ntu.springcloud.sentinel.handler.CustomFallbackHandler;
import cn.edu.ntu.springcloud.sentinel.service.IPaymentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 *
 * - code fallback will only handle runtime exception <br/>
 * - block will handle sentinel exception, including limit, hot key, fallback in UI etcs<br/>
 *<br/>
 * - if no config guideline in UI, sentinel block handler will always not work<br/>
 * - configured guideline in UI<br/>
 *<br/>
 *   - no block and no code fallback:<br/>
 *     - if not challenge sentinel guideline in UI, everything is fine<br/>
 *     - if sentinel guideline in UI is challenged, sentinel default handler will work to response default limit string<br/>
 *   - only has block<br/>
 *     - if not challenge sentinel guideline in UI, everything is fine<br/>
 *     - if sentinel guideline in UI is challenged, custom block handler will work<br/>
 *   - only has code fallback<br/>
 *     - if sentinel guideline in UI is challenged, default block handler will work<br/>
 *     - if not challenge sentinel guideline in UI<br/>
 *       - if fallback is triggered, code fallback will work<br/>
 *       - if fallback is not triggered, everything is fine<br/>
 *   - if full has code fallback and sentinel config<br/>
 *     - if not challenge sentinel guideline in UI, code fallback will work<br/>
 *     - if sentinel guideline in UI is challenged, sentinel block handler will work<br/>
 *<br/>
 * - conclusion:<br/>
 *<br/>
 *   - if sentinel guideline in UI is challenged, sentinel will always work<br/>
 *   - else sentinel will not work<br/>
 *
 * @author zack <br>
 * @create 2020-04-15 22:10 <br>
 */
@RestController
@RequestMapping(value = "/sentinel")
public class FlowLimitController {

  @GetMapping(value = "/getA")
  public JsonResult getA() {

    return new JsonResult(200, "success", "GetA Method");
  }

  /**
   * if config hot key in admin, the limit response is error page. <br>
   * if config url limit in admin, the limit response is sentinel default string. <br>
   *
   * @param p1
   * @return
   */
  @GetMapping(value = "/getHotKey0")
  @SentinelResource(value = "getHotKey0")
  public JsonResult getHotKey0(@RequestParam(value = "p1", required = false) String p1) {

    return new JsonResult(200, "success", "GetHotKey Method");
  }

  /**
   * if own blockHandler, it will handle and only handle limit exception; <br>
   * and will do handle runtime exception in code, which will be handled by fallback;<br>
   * fallback can be ext to specify class, and point out use by fallbackClass .<br>
   *
   * @param p1
   * @param p2
   * @return
   */
  @GetMapping(value = "/getHotKey")
  @SentinelResource(value = "getHotKey", blockHandler = "getHotKeyFallback")
  public JsonResult getHotKey(
      @RequestParam(value = "p1", required = false) String p1,
      @RequestParam(value = "p2", required = false) String p2) {

    return new JsonResult(200, "success", "GetHotKey Method");
  }

  /**
   * Optimize getHotKey2 method about fallback and block handler<br>
   *
   * @param p1
   * @param p2
   * @return
   */
  @GetMapping(value = "/getHotKey2")
  @SentinelResource(
      value = "getHotKey2",
      blockHandlerClass = CustomBlockHandler.class,
      blockHandler = "customBlockHandler")
  public JsonResult getHotKey2(
      @RequestParam(value = "p1", required = false) String p1,
      @RequestParam(value = "p2", required = false) String p2) {

    return new JsonResult(200, "success", "GetHotKey Method");
  }

  /**
   * only have fallback<br>
   *
   * @param p1
   * @param p2
   * @return
   */
  @GetMapping(value = "/getHotKey3")
  @SentinelResource(
      value = "getHotKey3",
      fallbackClass = CustomFallbackHandler.class,
      fallback = "defaultFallbackHandler")
  public JsonResult getHotKey3(
      @RequestParam(value = "p1", required = false) String p1,
      @RequestParam(value = "p2", required = false) String p2) {

    return new JsonResult(200, "success", "GetHotKey Method");
  }


  /**
   * have block and fallback<br>
   * block handler priority is high
   * @param p1
   * @param p2
   * @return
   */
  @GetMapping(value = "/getHotKey4")
  @SentinelResource(
          value = "getHotKey4",
          blockHandlerClass = CustomBlockHandler.class,
          blockHandler = "customBlockHandler",
          fallbackClass = CustomFallbackHandler.class,
          fallback = "defaultFallbackHandler")
  public JsonResult getHotKey4(
          @RequestParam(value = "p1", required = false) String p1,
          @RequestParam(value = "p2", required = false) String p2) {

    return new JsonResult(200, "success", "GetHotKey Method");
  }


  /**
   * exceptionsToIgnore = {NullPointerException.class} to ignore the exception, donot use fallback  <br/>
   * but block handler is worked
   *
   * @param p1
   * @param p2
   * @return
   */
  @GetMapping(value = "/getHotKey5")
  @SentinelResource(
          value = "getHotKey5",
          blockHandlerClass = CustomBlockHandler.class,
          blockHandler = "customBlockHandler",
          fallbackClass = CustomFallbackHandler.class,
          fallback = "defaultFallbackHandler",
          exceptionsToIgnore = {NullPointerException.class})
  public JsonResult getHotKey5(
          @RequestParam(value = "p1", required = false) String p1,
          @RequestParam(value = "p2", required = false) String p2) {

    return new JsonResult(200, "success", "GetHotKey Method");
  }


  @Resource private IPaymentService paymentService;

  @GetMapping(value = "/getByOpenfeign")
  @SentinelResource(
          value = "getByOpenfeign",
          blockHandlerClass = CustomBlockHandler.class,
          blockHandler = "customBlockHandler")
  public JsonResult getByOpenfeign(
          @RequestParam(value = "p1", required = false) String p1,
          @RequestParam(value = "p2", required = false) String p2) {

    return paymentService.getPaymentById(1L);
  }


  /**
   * this method will is fallback handler, it can only handle limit exception, <br>
   * and should be organized in one class.
   *
   * @param p1
   * @param p2
   * @param blockException
   * @return
   */
  public JsonResult getHotKeyFallback(String p1, String p2, BlockException blockException) {
    return new JsonResult(200, "success", "GetHotKeyFallback Method");
  }
}
