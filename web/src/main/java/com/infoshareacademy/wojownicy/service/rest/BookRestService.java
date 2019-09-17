package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.dto.BookDto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/books")
@Stateless
public class BookRestService {

  @EJB
  private ApiBookService apiBookService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @GET
  @Path("/searchTitle/{searchTitle}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNotification(@PathParam("searchTitle") String searchTitle) {
    logger.info("books with title contains " + searchTitle + "were parsed to json successfully");
    List<BookDto> bookLiveSearchList = apiBookService.getLiveSearchBook(searchTitle);
    if (bookLiveSearchList.isEmpty()) {
      logger.warn("Cannot find books {} contains" + searchTitle);
      return Response.status(Status.NOT_FOUND).build();
    }
    logger.info("Found books {} contains" + searchTitle);
    return Response.ok().entity(bookLiveSearchList).build();
  }
}
