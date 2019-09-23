package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.view.BookLiveSearchView;
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

@Path("/books")
@Stateless
public class BookRestService {

  @EJB
  private ApiBookService apiBookService;

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
}
