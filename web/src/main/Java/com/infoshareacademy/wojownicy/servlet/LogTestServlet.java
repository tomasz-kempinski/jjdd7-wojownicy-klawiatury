package com.infoshareacademy.wojownicy.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log-test-servlet")
public class LogTestServlet extends HttpServlet {
  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter printWriter = resp.getWriter();
    printWriter.println("Logs Added to file and console");
    logger.debug("DEBUG");
    logger.trace("TRACE");
    logger.info("INFO");
    logger.warn("WARN");
    logger.error("ERROR");
  }
}
