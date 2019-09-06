package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.Author;
import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.AuthorService;
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

  private static final Logger logger = Logger.getLogger(BookSearchServlet.class.getName());

    @Inject
    private BookService bookService;

    @Inject
    private AuthorService authorService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

      String authorParam = req.getParameter("author");
      PrintWriter writer = resp.getWriter();
      if (authorParam == null || authorParam.isEmpty()) {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return;
      }
      String author = authorParam;
      Author author = authorService.findBookByAuthor(author);

      Template template = templateProvider.getTemplate(getServletContext(), "book-search.ftlh");
      Map<String, Object> model = new HashMap<>();

      if (author != null) {

        model.put("author", author);

      } else {
        model.put("errorMessage", "Nie znaleziono takiego autora.");
      }

      try {
        template.process(model, writer);
      } catch (TemplateException e) {
        logger.severe(e.getMessage());
      }
    }
  }