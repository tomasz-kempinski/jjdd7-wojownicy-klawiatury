package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.dao.GenreDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookListService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/book-list")
public class BooksListServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(BooksListServlet.class.getName());

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private BookListService bookListService;

  @Inject
  GenreDaoBean genreDaoBean;


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-list.ftlh");
    String partString = req.getParameter("part");
    long from = 0;
    long to = 10;
    long part = 1;
    if (NumberUtils.isCreatable(partString)) {
      part = Long.parseLong(partString);
      from = (part - 1) * 10;
      to = (from - 1) + 10;
    }
    List<Book> partOfBooks = bookListService.partOfBooks(from, to);
    Map<String, Object> pagesMap = bookListService.pages(part);
    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("books", partOfBooks);
    dataModel.put("page", pagesMap);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }
}
