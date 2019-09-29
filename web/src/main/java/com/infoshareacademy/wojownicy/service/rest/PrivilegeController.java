package com.infoshareacademy.wojownicy.service.rest;


import com.infoshareacademy.wojownicy.domain.entity.User;
import com.infoshareacademy.wojownicy.service.UserService;
import javax.ejb.EJB;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/admin")
public class PrivilegeController {

  @EJB
  private UserService userService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @PATCH
  @Path("/give/{id}")
  public Response givePermissions(@PathParam("id") String idParam) {

    if (!NumberUtils.isDigits(idParam)) {
      return Response.status(Status.BAD_REQUEST).build();
    }

    Long id = Long.valueOf(idParam);

    if (userService.getUserById(id) == null) {
      logger.warn("User with id: {} not found", id);
      return Response.status(Status.NOT_FOUND).build();
    }

    User user = userService.getUserById(id);

    if (user.getUserType().equals("admin") || user.getUserType().equals("superadmin")) {
      return Response.status(Status.NOT_MODIFIED).build();
    }

    user.setUserType("admin");
    userService.editUser(user);

    logger.warn("User: {} with id: {} received admin privileges", user.getUsername(), id);
    return Response.ok().build();
  }

  @PATCH
  @Path("/revoke/{id}")
  public Response revokePermissions(@PathParam("id") String idParam){

    if (!NumberUtils.isDigits(idParam)){
      return Response.status(Status.BAD_REQUEST).build();
    }

    Long id = Long.valueOf(idParam);

    if (userService.getUserById(id) == null){
      logger.warn("User with id: {} not found", id);
      return Response.status(Status.NOT_FOUND).build();
    }

    User user = userService.getUserById(id);

    if (user.getUserType().equals("user") || user.getUserType().equals("superadmin")){
      return Response.status(Status.NOT_MODIFIED).build();
    }

    user.setUserType("user");
    userService.editUser(user);

    logger.warn("User: {} with id: {} had admin privileges revoked", user.getUsername(), id);
    return Response.ok().build();
  }

}
