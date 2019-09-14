package com.infoshareacademy.wojownicy.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/log-test-servlet")
public class LogTestServlet extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();
    printWriter.println("Logs Added to file and console");
    logger.debug("DEBUG");
    logger.trace("TRACE");
    logger.info("INFO");
    logger.warn("WARN");
    logger.error("ERROR");
  }
}
