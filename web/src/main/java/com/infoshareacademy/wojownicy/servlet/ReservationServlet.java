package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.ReservationService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
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

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(ReservationServlet.class.getName());

  @Inject
  private ReservationService reservationService;

  @Inject
  private TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request GET method");
    String userEmail = (String) req.getSession().getAttribute("email");
    List<Reservation> reservationsForUser = reservationService.findReservationForUser(userEmail);

    Template template = templateProvider.getTemplate(getServletContext(), "reservation.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("reservationsForUser", reservationsForUser);
    model.put("userEmail", userEmail);
    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request POST method");
    Long bookId = Long.parseLong(req.getParameter("id"));
    String userEmail = (String) req.getSession().getAttribute("email");
    reservationService.newReservation(bookId, userEmail);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request DELETE method");
    Long bookId = Long.parseLong(req.getParameter("id"));
    String userEmail = (String) req.getSession().getAttribute("email");
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
  }

}
