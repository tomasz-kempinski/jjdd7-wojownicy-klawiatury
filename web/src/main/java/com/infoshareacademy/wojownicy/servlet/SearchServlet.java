package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.service.BookService;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(SearchServlet.class.getName());

  @Inject
  private BookService bookService;


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    String titleParam = req.getParameter("title");
    String order =req.getParameter("order");

    resp.setContentType("text/html;charset=UTF-8");
    resp.sendRedirect("listOfBooks.jsp?title=" + titleParam + "&order=" + order);
  }
}