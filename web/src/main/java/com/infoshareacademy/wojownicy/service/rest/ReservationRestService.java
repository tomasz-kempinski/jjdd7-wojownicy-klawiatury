package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.service.BookListService;
import com.infoshareacademy.wojownicy.service.ReservationService;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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

  @EJB
  private BookListService bookListService;

  @GET
  @Path("/book-newReservation")
  @Produces(MediaType.TEXT_HTML)
  public Response addReservation(@Context HttpServletRequest req) {

    Optional<String> emailOpt = Optional
        .ofNullable((String) req.getSession().getAttribute("email"));
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

  @GET
  @Path("/book-isReserved")
  @Produces(MediaType.APPLICATION_JSON)
  public Response isReserved(@Context HttpServletRequest req) {
    String idString = req.getParameter("id");
    Long bookId = Long.parseLong(idString);

    if (bookListService.isReserved(bookId)) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    return Response.ok().build();
  }
}
