package cn.edu.ntu.javase.agent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zack <br>
 * @create 2020-09-20 19:25 <br>
 * @project javase <br>
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    new Server().sayHello("timothy");
  }
}
