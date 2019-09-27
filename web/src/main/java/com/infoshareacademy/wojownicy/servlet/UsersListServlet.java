package com.infoshareacademy.wojownicy.servlet;

import freemarker.template.Template;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/users-list")
public class UsersListServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(UsersListServlet.class.getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template =
  }
}
