package cn.edu.ntu.javaee.springmvc.servlet.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * usage: http://localhost:8080/servlet3_0_war/hello
 *
 * @author zack <br>
 * @create 2020-05-03 17:40 <br>
 */
@WebServlet("/hello")
@Slf4j
public class HelloServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    log.info(Thread.currentThread() + " start...");
    try {
      sayHello();
    } catch (Exception e) {
      e.printStackTrace();
    }
    resp.getWriter().write("hello...");
    log.info(Thread.currentThread() + " end...");
  }

  public void sayHello() throws Exception {
    log.info(Thread.currentThread() + " processing...");
    Thread.sleep(3000);
  }
}
