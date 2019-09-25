package com.infoshareacademy.wojownicy.OAuth;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import com.infoshareacademy.wojownicy.domain.entity.User;
import com.infoshareacademy.wojownicy.dto.UserDto;
import com.infoshareacademy.wojownicy.service.UserService;
import java.io.IOException;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/oauth2callback")
public class LoginCallbackServlet extends AbstractAuthorizationCodeCallbackServlet {

  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private UserService userService;

  @Override
  protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
      throws ServletException, IOException {
    GoogleCredential gCredential = new GoogleCredential()
        .setAccessToken(credential.getAccessToken());
    Oauth2 oauth2 = new Oauth2.Builder(
        new NetHttpTransport(),
        JacksonFactory.getDefaultInstance(),
        gCredential)
        .setApplicationName("BookHub")
        .build();
    Userinfoplus info = oauth2.userinfo().get().execute();
    String name = info.getName();
    String email = info.getEmail();

    if (userService.getUserByEmail(email) == null) {
      UserDto user = new UserDto();
      user.setUsername(name);
      user.setEmail(email);
      user.setUserType("user");
      userService.saveUser(user);
      logger.info("Created user with username {} and email {}", name, email);
    }

    logger.info("Authentication success of user: {}", name );

    User verifiedUser = userService.getUserByEmail(email);
    req.getSession().setAttribute("userId", verifiedUser.getUserId());
    req.getSession().setAttribute("email", verifiedUser.getEmail());
    req.getSession().setAttribute("userType", verifiedUser.getUserType());
    req.getSession().setAttribute("username", verifiedUser.getUsername());

    logger.info("{} is {}", name, req.getSession().getAttribute("userType"));

    if (req.getSession().getAttribute("userType") == null) {
      req.getSession().setAttribute("userType", "guest");
    }

    resp.sendRedirect("/");
  }

  @Override
  protected void onError(
      HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
      throws ServletException, IOException {
  }

  @Override
  protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
    return GoogleLoginCommons.buildRedirectUri(req);
  }

  @Override
  protected AuthorizationCodeFlow initializeFlow() throws IOException {
    return GoogleLoginCommons.buildFlow();
  }

  @Override
  protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
    return UUID.randomUUID().toString();
  }
}