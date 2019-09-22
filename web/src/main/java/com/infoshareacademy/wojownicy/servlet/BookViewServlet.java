package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.Book;
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

@WebServlet("/book-view")
public class BookViewServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(BookViewServlet.class.getName());

  @Inject
  private TemplateProvider templateProvider;
  @Inject
  private BookListService bookListService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-view.ftlh");
    String idString = req.getParameter("id").replaceAll(",", "");
    String partString = req.getParameter("part");
    String isAudioString = req.getParameter("hasAudio");
    Map<String, Object> dataModel = new HashMap<>();
    long id;
    long part;
    String audio;
    int isAudioFilter=0;
    boolean hasAudio;

    if (NumberUtils.isDigits(idString) && NumberUtils.isDigits(partString) && NumberUtils.isDigits(isAudioString)
        && Long.parseLong(idString) <= bookListService.numberOfBooks(isAudioFilter)
        && Long.parseLong(idString) > 0)
    {
      isAudioFilter = Integer.parseInt(isAudioString);
      id = Long.parseLong(idString);
      part = Long.parseLong(partString);
    } else {
      id = 1;
      part = 1;
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
    dataModel.put("isAudioFilter", isAudioFilter);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }
}
