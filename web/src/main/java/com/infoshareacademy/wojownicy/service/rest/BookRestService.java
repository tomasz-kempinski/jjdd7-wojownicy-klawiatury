package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.entity.User;
import com.infoshareacademy.wojownicy.domain.view.BookLiveSearchView;
import com.infoshareacademy.wojownicy.service.BookService;
import com.infoshareacademy.wojownicy.service.EmailService;
import com.infoshareacademy.wojownicy.service.ReservationService;
import com.infoshareacademy.wojownicy.service.UserService;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/books")
@Stateless
public class BookRestService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private ApiBookService apiBookService;

  @EJB
  private BookService bookService;

  @EJB
  private UserService userService;

  @EJB
  private ReservationService reservationService;

  @EJB
  private EmailService emailService;

  @GET
  @Path("/searchParam/{searchParam}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNotification(@PathParam("searchParam") String searchParam) {
    List<BookLiveSearchView> bookLiveSearchViews = apiBookService
        .getLiveSearchBookTitle(searchParam);
    if (bookLiveSearchViews.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok().entity(bookLiveSearchViews).build();
  }

  @DELETE
  @Path("/delete/{id}")
  public Response deleteBook(@PathParam("id") String id) {

    id = id.replace(",", "");
    Long idParam = Long.parseLong(id);
    bookService.deleteBook(idParam);
    logger.info("Book with id: {} has been deleted", idParam);
    return Response.ok().build();
  }

  @GET
  @Path("/reserve/{id}")
  public Response reserveBook(@PathParam("id") String id,
      @Context HttpServletRequest req) {

    Optional<String> emailOpt = Optional
        .ofNullable(req.getSession().getAttribute("email").toString());
    String email = emailOpt.get();
    User user = userService.getUserByEmail(email);

    id = id.replace(",", "");
    Long idParam = Long.parseLong(id);

    reservationService.newReservation(idParam, email);
    emailService.sendReservationEmailToUser(user.getUserId(), idParam);

    return Response.ok().build();
  }


  @DELETE
  @Path("/reserve/{id}")
  public Response cancelReservation(@PathParam("id") String id) {

    id = id.replace(",", "");
    Long idParam = Long.parseLong(id);
    reservationService.deleteReservationById(idParam);
    logger.info("Book with id: {} has been deleted", idParam);
    return Response.ok().build();
  }
}
