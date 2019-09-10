package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.service.BookSearch;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
  private BookSearch bookSearch;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    String titleParam = req.getParameter("title");
    List<Book> books = bookSearch.findBooks(titleParam);
    PrintWriter writer = resp.getWriter();

    Book book = new Book();


    if (books != null) {
      writer.println("ID" + (book.getId()));
      writer.println("Title " + (book.getTitle()));
      writer.println("Author " + book.getAuthor());
    } else {
      writer.println("Book with Title provided in request has not been found.");
    }


  }
}