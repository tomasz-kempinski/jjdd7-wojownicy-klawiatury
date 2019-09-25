package com.infoshareacademy.wojownicy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book-reservation")
public class ReservationServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String bookId = req.getParameter("bookId");
    Long parseBookId = Long.parseLong(bookId);
    String userId = req.getParameter("userId");
    Long parseUserId = Long.parseLong(userId);


  }
}
