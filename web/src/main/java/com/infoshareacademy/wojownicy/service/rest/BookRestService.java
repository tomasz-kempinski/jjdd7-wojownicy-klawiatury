package com.infoshareacademy.wojownicy.service.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
@Stateless
public class BookRestService {

  @EJB
  private ApiBookService apiBookService;

  @GET
  @Path("/searchParam/{searchParam}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNotification(@PathParam("searchParam") String searchParam) {
    return Response.ok().entity(apiBookService.getLiveSearchBook(searchParam)).build();
  }
}
