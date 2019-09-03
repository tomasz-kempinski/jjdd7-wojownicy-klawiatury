package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/book-search")
public class BookSearchServlet extends HttpServlet {

  Logger logger = Logger.getLogger(getClass().getName());
  @Inject
  private BookService bookService;
  @Inject
  private TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    String titleParam = req.getParameter("title");
    String authorParam = req.getParameter("author");
    PrintWriter writer = resp.getWriter();

    if (titleParam == null || titleParam.isEmpty()) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    } else if (titleParam.length() < 3) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    if (authorParam == null || authorParam.isEmpty()) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    } else if (authorParam.length() < 3) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    String title = titleParam;
    Book bookTitle = bookService.findBookByTitle(title);
    String author = authorParam;
    Book bookAuthor = bookService.findBookByAuthor(author);

    Template template = templateProvider.getTemplate(getServletContext(), "...");

    Map<String, Object> model = new HashMap<>();
    if (bookTitle != null) {
      model.put("bookTitle", bookTitle);
    } else {
      model.put("errorMessageTitle", "Nie znaleziono takiego tytułu.");
    }
    if (bookAuthor != null) {
      model.put("bookAuthor", bookAuthor);
    } else {
      model.put("errorMessageAuthor", "Nie znaleziono takiego autora.");
    }

    try {
      template.process(model, writer);
    } catch (TemplateException e) {
      logger.severe(e.getMessage());
    }
  }
}