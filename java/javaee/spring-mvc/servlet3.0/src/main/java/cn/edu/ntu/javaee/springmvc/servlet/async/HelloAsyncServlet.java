package cn.edu.ntu.javaee.springmvc.servlet.async;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <code>@WebServlet(value="/async", asyncSupported=true)</code> will enable async mode. <br>
 * notice: if want make async work, we show enable asyncSupported in all filter and relevant
 * servelt.
 *
 * @author zack <br>
 * @create 2020-05-03 19:04 <br>
 */
@WebServlet(value = "/async/hello", asyncSupported = true)
@Slf4j
public class HelloAsyncServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info("main thread.." + Thread.currentThread() + "==>" + System.currentTimeMillis());
    AsyncContext asyncContext = req.startAsync();

    // business logic
    asyncContext.start(
        () -> {
          log.info(
              "assist thread start ... {} ==> {} ",
              Thread.currentThread(),
              System.currentTimeMillis());

          try {
            sayHello();

            // get AsyncContext, same as asyncContext
            // AsyncContext asyncContext = req.getAsyncContext();
            // get ServletResponse
            ServletResponse response = asyncContext.getResponse();
            response.getWriter().write("hello async...");
            asyncContext.complete();
          } catch (IOException e) {
            e.printStackTrace();
          }

          log.info(
              "assist thread stop ...{} ==> {} ",
              Thread.currentThread(),
              System.currentTimeMillis());
        });

    log.info("main thread stop ...{} ==> {} ", Thread.currentThread(), System.currentTimeMillis());
  }

  public static final void sayHello() {
    log.info(Thread.currentThread() + " processing...");
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
