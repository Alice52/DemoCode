package com.augmentum.springboot.integration.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomServlet extends HttpServlet {
  private static final Logger LOG = LoggerFactory.getLogger(CustomServlet.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    LOG.info("CustomServlet doGet");
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    LOG.info("CustomServlet doPost");
    resp.getWriter().write("Hello CustomServlet");
  }
}
