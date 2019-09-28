package com.infoshareacademy.wojownicy.servlet;

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

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-list.ftlh");
    String partString = req.getParameter("part");
    String hasAudioString = req.getParameter("hasAudio");
    String kindString = req.getParameter("kind");
    int part = 0;
    int hasAudio = 0;
    long kind = 0;

    if (NumberUtils.isDigits(partString)
        && Integer.parseInt(partString) >= 0
        && NumberUtils.isDigits(hasAudioString)
        && NumberUtils.isDigits(kindString)) {
      part = Integer.parseInt(partString);
      hasAudio = Integer.parseInt(hasAudioString);
      kind = Long.parseLong(kindString);
    } else {
      logger.info("Wrong parameter for BookList");
      resp.sendRedirect("/errorServlet");
    }
    List<BookDto> partOfBooks;
    if (hasAudio == 1) {
      partOfBooks = bookListService.partOfAudioBooks(part * 20, kind);
    } else {
      partOfBooks = bookListService.partOfBooks(part * 20, kind);
    }

    Map<String, Object> dataModel = new HashMap<>();
    Map<String, Object> pagesMap = bookListService.pages(part, hasAudio, kind);

    dataModel.put("books", partOfBooks);
    dataModel.put("page", pagesMap);
    dataModel.put("hasAudio", hasAudio);
    dataModel.put("kind", kind);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }
}