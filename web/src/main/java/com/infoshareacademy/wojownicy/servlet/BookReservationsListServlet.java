package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookReservationsService;
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
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@WebServlet("/reservation-list")
public class BookReservationsListServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(BookReservationsListServlet.class.getName());

  @Inject
  TemplateProvider templateProvider;

  @Inject
  private BookReservationsService bookReservationsService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Template template = templateProvider.getTemplate(getServletContext(),"reservations-list.ftlh");

    Long userId = (Long) req.getSession().getAttribute("userId");
    String siteType = (String) req.getAttribute("siteType");

    List<Reservation> reservationsList = bookReservationsService.getReservationBookList(userId);

    Map<String, Object> dataModel = new HashMap<>();

    dataModel.put("reservations", reservationsList);
    dataModel.put("siteType", siteType);
    PrintWriter printWriter = resp.getWriter();

    try {
      template.process(dataModel,printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }


  }
}
