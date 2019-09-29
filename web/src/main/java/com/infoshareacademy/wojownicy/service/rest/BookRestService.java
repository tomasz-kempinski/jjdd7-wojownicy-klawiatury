package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.User;
import com.infoshareacademy.wojownicy.domain.view.BookLiveSearchView;
import com.infoshareacademy.wojownicy.service.BookService;
import com.infoshareacademy.wojownicy.service.emailmanager.EmailSenderService;
import com.infoshareacademy.wojownicy.service.ReservationService;
import com.infoshareacademy.wojownicy.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
  private EmailSenderService emailSenderService;

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
      @Context HttpServletRequest req) throws MessagingException {

    Optional<String> emailOpt = Optional
        .ofNullable(req.getSession().getAttribute("email").toString());
    String email = emailOpt.get();
    User user = userService.getUserByEmail(email);

    id = id.replace(",", "");
    Long idParam = Long.parseLong(id);

    Book book = bookService.findBookById(idParam);

    reservationService.newReservation(idParam, email);
    List<String> recipients = new ArrayList<>();
    recipients.add(email);
    String subject = "Rezerwacja książki " +"\"" +book.getTitle()+"\"";
    emailSenderService.sendMessage(recipients, subject);


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
