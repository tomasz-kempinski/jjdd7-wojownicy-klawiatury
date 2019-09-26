package com.infoshareacademy.wojownicy.service.rest;

import java.util.Optional;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/user")
@Stateless
public class LoginController {

  @GET
  @Path("/is-logged")
  public Response isLogged(@Context HttpServletRequest req) {

    Optional<String> email = Optional.ofNullable((String) req.getSession().getAttribute("email"));

    if (email.isEmpty()) {
      return Response.status(Status.UNAUTHORIZED).build();
    }
    return Response.ok().build();
  }

}
