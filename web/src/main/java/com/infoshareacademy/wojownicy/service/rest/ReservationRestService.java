//package com.infoshareacademy.wojownicy.service.rest;
//
//import com.infoshareacademy.wojownicy.service.ReservationService;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//import org.apache.commons.lang3.math.NumberUtils;
//
//
//@Path("/reservation")
//@Stateless
//public class ReservationRestService {
//
//  @EJB
//  private ReservationService reservationService;
//
//  @GET
//  @Path("/add-reservation")
//  public Response addReservation(@Context HttpServletRequest req) {
//
//    String userEmail = (String) req.getSession().getAttribute("email");
//    String bookIdString = req.getParameter("id");
//
//    if (NumberUtils.isDigits(bookIdString)) {
//      Long bookId = Long.parseLong(bookIdString);
//      reservationService.newReservation(bookId, userEmail);
//    } else if (bookIdString.isEmpty()) {
//      return Response.status(Status.NOT_FOUND).build();
//    }
//    return Response.ok().build();
//  }
//}
