package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookListService;
import com.infoshareacademy.wojownicy.service.ReservationService;
import com.infoshareacademy.wojownicy.service.BookService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
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
  @Inject
  private ReservationService reservationService;

  @Inject
  private BookService bookService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-view.ftlh");
    String idString = req.getParameter("id");
    String partString = req.getParameter("part");
    String isAudioString = req.getParameter("hasAudio");
    String kindString = req.getParameter("kind");
    String siteType = (String) req.getAttribute("siteType");
    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("siteType", siteType);
    long id = 1;
    long part = 0;
    long kind = 0;
    String userEmail = (String) req.getSession().getAttribute("email");
    String audio = "niedostępne";
    int isAudioFilter = 0;
    boolean hasAudio;

    if(NumberUtils.isDigits(idString) && Long.parseLong(idString)>0){
      id = Long.parseLong(idString);
    } else {
      logger.info("Wrong Parameter for single book view");
      resp.sendRedirect("/errorServlet");
    }


    if (NumberUtils.isDigits(partString)
        && NumberUtils.isDigits(isAudioString)
        && NumberUtils.isDigits(kindString)) {
      isAudioFilter = Integer.parseInt(isAudioString);
      part = Long.parseLong(partString);
      kind = Long.parseLong(kindString);
    } else {
      logger.info("Wrong Parameter for single book view");
    }
    hasAudio = bookListService.hasAudio(id);
    if (hasAudio) {
      audio = "dostępna";
    }

    BookDto book = bookListService.getSingleBook(id);
    logger.warn(String.valueOf(book.isReserved()));
    dataModel.put("isReserved", book.isReserved());
    dataModel.put("book", book);
    dataModel.put("hasAudio", audio);
    dataModel.put("part", part);
    dataModel.put("isAudioFilter", isAudioFilter);
    dataModel.put("kind", kind);


    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }

    resp.setStatus(200);
  }
}
