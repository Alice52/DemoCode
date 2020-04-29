package cn.edu.ntu.springboot.mvc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class CustomFilter implements Filter {
  private static final Logger LOG = LoggerFactory.getLogger(CustomFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    LOG.info("CustomFilter Process.");
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {}
}
