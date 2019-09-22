package com.infoshareacademy.wojownicy.OAuth;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.infoshareacademy.wojownicy.servlet.MainSiteServlet;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/googlelogin")
public class LoginServlet extends AbstractAuthorizationCodeServlet {

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
//@WebServlet("/login")
//@SuppressWarnings("serial")
//public class LoginServlet extends HttpServlet {
//
//  private static final Collection<String> SCOPES = Arrays.asList("email", "profile");
//  private static final JsonFactory JSON_FACTORY = new JacksonFactory();
//  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//
//  private GoogleAuthorizationCodeFlow flow;
//
//  @Override
//  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//      throws IOException, ServletException {
//
//    String state = new BigInteger(130, new SecureRandom()).toString(32);  // prevent request forgery
//    req.getSession().setAttribute("state", state);
//
//    if (req.getAttribute("loginDestination") != null) {
//      req
//          .getSession()
//          .setAttribute("loginDestination", (String) req.getAttribute("loginDestination"));
//    } else {
//      req.getSession().setAttribute("loginDestination", "/");
//    }
//
//    flow = new GoogleAuthorizationCodeFlow.Builder(
//        HTTP_TRANSPORT,
//        JSON_FACTORY,
//        getServletContext().getInitParameter("bookshelf.clientID"),
//        getServletContext().getInitParameter("bookshelf.clientSecret"),
//        SCOPES)
//        .build();
//
//    // Callback url should be the one registered in Google Developers Console
//    String url =
//        flow.newAuthorizationUrl()
//            .setRedirectUri(getServletContext().getInitParameter("bookshelf.callback"))
//            .setState(state)            // Prevent request forgery
//            .build();
//    resp.sendRedirect(url);
//  }
//}