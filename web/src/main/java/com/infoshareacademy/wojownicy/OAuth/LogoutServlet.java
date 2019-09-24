package com.infoshareacademy.wojownicy.OAuth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    HttpSession session = req.getSession();
    logger.info("logging out user {}", session.getAttribute("username"));
    session.invalidate();
    resp.sendRedirect("/");
  }
}