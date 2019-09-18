package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.dao.GenreDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
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
    String fromIdString = req.getParameter("id");
    String audio = req.getParameter("hasAudio");
    boolean hasAudio = Boolean.parseBoolean(audio);
    hasAudio=true;
    long from = 0;
    long part = 1;
    long fromId =1;
    if (NumberUtils.isDigits(partString) || NumberUtils.isDigits(fromIdString)) {
      part = Long.parseLong(partString);
      fromId= Long.parseLong(fromIdString)-1;
      from = (part - 1) * 20;
    }
    List<BookDto> partOfBooks = bookListService.partOfBooks(fromId, hasAudio);
    long lastId = partOfBooks.get(partOfBooks.size()-1).getId()+1;
    Map<String, Object> pagesMap = bookListService.pages(part);
    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("books", partOfBooks);
    dataModel.put("page", pagesMap);
    dataModel.put("lastId", lastId);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }
}
