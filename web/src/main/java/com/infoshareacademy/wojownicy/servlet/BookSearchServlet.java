package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.service.AuthorService;
import com.infoshareacademy.wojownicy.service.BookService;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/book-search")
public class BookSearchServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(BookSearchServlet.class.getName());

  @Inject
  private BookService bookService;

  @Inject
  private AuthorService authorService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    String authorParam = req.getParameter("author");
    String titleParam = req.getParameter("title");

    if (authorParam == null || authorParam.isEmpty()) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    if (titleParam == null || titleParam.isEmpty()) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    String authorName = authorParam;
    Author author = authorService.findBookByAuthor(authorName);

    String title = titleParam;
    Book book = bookService.findBookByTitle(title);
  }
}