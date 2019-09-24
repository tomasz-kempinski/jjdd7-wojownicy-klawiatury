package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.service.UserService;
import java.util.Optional;
import java.util.function.Predicate;
import javax.ejb.EJB;
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

  @EJB
  private UserService userService;

  @GET
  @Path("/is-logged")
  public Response isLogged(@Context HttpServletRequest req) {

    String email = (String) req.getSession().getAttribute("email");

//    Optional<String> email = Optional.ofNullable(req.getSession().getAttribute("email"));

    if (!userService.checkIfExistByEmail(email)){
      return Response.status(Status.UNAUTHORIZED).build();
    }
    return Response.ok().build();
  }

}
