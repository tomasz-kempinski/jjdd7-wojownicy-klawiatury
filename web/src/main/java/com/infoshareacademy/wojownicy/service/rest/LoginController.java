package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.entity.User;
import com.infoshareacademy.wojownicy.service.UserService;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/user")
@Stateless
public class LoginController {

  @EJB
  private UserService userService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @GET
  @Path("/is-logged")
  public Response isLogged(@Context HttpServletRequest req) {

    Optional<String> email = Optional.ofNullable((String) req.getSession().getAttribute("email"));

    if (email.isEmpty()) {
      return Response.status(Status.UNAUTHORIZED).build();
    }
    return Response.ok().build();
  }

  @GET
  @Path("/get-permission/{id}")
  public Response isLogged(@PathParam("id") String idParam) {

    if (!NumberUtils.isDigits(idParam)) {
      return Response.status(Status.BAD_REQUEST).build();
    }

    Long id = Long.valueOf(idParam);

    if (userService.getUserById(id) == null) {
      logger.warn("User with id: {} not found", id);
      return Response.status(Status.NOT_FOUND).build();
    }

    User user = userService.getUserById(id);

    if(user.getUserType().equals("user")){

      return Response.status(Status.UNAUTHORIZED).build();

    } else if (user.getUserType().equals("admin")){

      return Response.ok().build();

    }

    return Response.ok().build();
  }


}
