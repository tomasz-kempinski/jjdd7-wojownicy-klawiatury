package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.Book;
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
    String idString = req.getParameter("id");
    String partString = req.getParameter("part");
    Map<String, Object> dataModel = new HashMap<>();
    long id = Long.parseLong(idString);
    long part = Long.parseLong(partString)+1;
    boolean hasAudio = bookListService.hasAudio(id);
    String audio;
    if (hasAudio){
      audio="dostępna";
    } else {
      audio = "niedostępna";
    }
    Book book = bookListService.getSingleBook(id);
    dataModel.put("book",book);
    dataModel.put("hasAudio",audio);
    dataModel.put("part",part);




    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }
}
