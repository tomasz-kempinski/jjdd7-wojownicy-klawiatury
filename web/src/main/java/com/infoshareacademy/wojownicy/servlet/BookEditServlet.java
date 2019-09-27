package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookListService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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

@WebServlet("/book-edit")
public class BookEditServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(BookEditServlet.class.getName());

  @Inject
  private TemplateProvider templateProvider;
  @Inject
  private BookListService bookListService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-edit-site.ftlh");
    String idString = req.getParameter("id").replaceAll(",", "");
    Map<String, Object> dataModel = new HashMap<>();
    long id = 1;
    String audio;
    boolean hasAudio = false;

    if (NumberUtils.isDigits(idString)
        && Long.parseLong(idString) < bookListService.numberOfBooks()
        && Long.parseLong(idString) > 0) {
      id = Long.parseLong(idString);
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

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }
}
