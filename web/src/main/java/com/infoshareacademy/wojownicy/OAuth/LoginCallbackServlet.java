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
import com.infoshareacademy.wojownicy.dto.UserDto;
import com.infoshareacademy.wojownicy.service.UserService;
import java.io.IOException;
import java.util.UUID;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oauth2callback")
public class LoginCallbackServlet extends AbstractAuthorizationCodeCallbackServlet {

  @Inject
  UserService userService;

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
    req.getSession().setAttribute("google_name", name);
    req.getSession().setAttribute("email", email);
    req.getSession().setAttribute("token", req.getSession().getAttribute(oauth2.tokeninfo().getAccessToken()));
    UserDto user = new UserDto();
    user.setUsername(name);
    user.setEmail(email);

    userService.saveUser(user);
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
//@WebServlet("/oauth2callback")
//public class LoginCallbackServlet extends HttpServlet {
//
//  private static final Collection<String> SCOPES = Arrays.asList("email", "profile");
//  private static final String USERINFO_ENDPOINT
//      = "https://www.googleapis.com/plus/v1/people/me/openIdConnect";
//  private static final JsonFactory JSON_FACTORY = new JacksonFactory();
//  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//
//  private GoogleAuthorizationCodeFlow flow;
//
//  @Override
//  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
//      ServletException {
//
//    // Ensure that this is no request forgery going on, and that the user
//    // sending us this connect request is the user that was supposed to.
//    if (req.getSession().getAttribute("state") == null
//        || !req.getParameter("state").equals((String) req.getSession().getAttribute("state"))) {
//      resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//      resp.sendRedirect("/books");
//      return;
//    }
//
//    req.getSession().removeAttribute("state");     // Remove one-time use state.
//
//    flow = new GoogleAuthorizationCodeFlow.Builder(
//        HTTP_TRANSPORT,
//        JSON_FACTORY,
//        getServletContext().getInitParameter("bookshelf.clientID"),
//        getServletContext().getInitParameter("bookshelf.clientSecret"),
//        SCOPES).build();
//
//    final TokenResponse tokenResponse =
//        flow.newTokenRequest(req.getParameter("code"))
//            .setRedirectUri(getServletContext().getInitParameter("bookshelf.callback"))
//            .execute();
//
//    req.getSession().setAttribute("token", tokenResponse.toString()); // Keep track of the token.
//    final Credential credential = flow.createAndStoreCredential(tokenResponse, null);
//    final HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential);
//
//    final GenericUrl url = new GenericUrl(USERINFO_ENDPOINT);      // Make an authenticated request.
//    final HttpRequest request = requestFactory.buildGetRequest(url);
//    request.getHeaders().setContentType("application/json");
//
//    final String jsonIdentity = request.execute().parseAsString();
//    @SuppressWarnings("unchecked")
//    HashMap<String, String> userIdResult =
//        new ObjectMapper().readValue(jsonIdentity, HashMap.class);
//    // From this map, extract the relevant profile info and store it in the session.
//    req.getSession().setAttribute("userEmail", userIdResult.get("email"));
//    req.getSession().setAttribute("userId", userIdResult.get("sub"));
//    req.getSession().setAttribute("userImageUrl", userIdResult.get("picture"));
//    resp.sendRedirect((String) req.getSession().getAttribute("loginDestination"));
//  }
//}