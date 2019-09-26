package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.service.ReservationService;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/reservation")
@Stateless
public class ReservationRestService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private ReservationService reservationService;

  @GET
  @Path("/book-newReservation")
  public Response isReserved (@Context HttpServletRequest req) {

    Optional<String> emailOpt = Optional.ofNullable((String) req.getSession().getAttribute("email"));
    String bookIdString = req.getParameter("id");

    if (emailOpt.isEmpty()) {
      return Response.status(Status.UNAUTHORIZED).build();
    } else if (bookIdString.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    Long bookId = Long.parseLong(bookIdString);
    String email = String.valueOf(emailOpt);
    reservationService.newReservation(bookId, email);
    logger.info("Book with " + bookId + " ID were reserved");
    return Response.ok().build();
  }
}
