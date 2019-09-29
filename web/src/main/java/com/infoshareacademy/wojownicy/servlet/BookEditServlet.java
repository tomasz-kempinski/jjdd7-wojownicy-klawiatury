package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.domain.entity.Kind;
import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.exception.UserImageNotFound;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookListService;
import com.infoshareacademy.wojownicy.service.BookService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/book-edit")
public class BookEditServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(BookEditServlet.class.getName());

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private BookListService bookListService;

  @Inject
  BookService bookService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-edit-site.ftlh");
    String idString = req.getParameter("id").replaceAll(",", "");
    String partString = req.getParameter("part");
    String siteType = (String) req.getAttribute("siteType");
    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("siteType", siteType);
    long id=1;
    long part=1;
    String audio;
    boolean hasAudio = false;

    if (NumberUtils.isDigits(idString) && NumberUtils.isDigits(partString)
        && Long.parseLong(idString) > 0) {
      id = Long.parseLong(idString);
      part = Long.parseLong(partString) + 1;
    }
    hasAudio = bookListService.hasAudio(id);
    if (hasAudio) {
      audio = "dostępna";
    } else {
      audio = "niedostępna";
    }
    BookDto book = bookListService.getSingleBook(id);
    dataModel.put("book", book);
    dataModel.put("hasAudio", audio);
    dataModel.put("part", part);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }
}
