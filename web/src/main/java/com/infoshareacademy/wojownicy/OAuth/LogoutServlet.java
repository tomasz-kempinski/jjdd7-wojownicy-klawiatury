package com.infoshareacademy.wojownicy.OAuth;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import java.io.IOException;
import java.net.http.HttpClient;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpClient;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    resp.sendRedirect("https://accounts.google.com/o/oauth2/revoke?token="+req.getSession().getAttribute("token"));
//    HttpSession session =  req.getSession(false);
//    if (session != null) {
//      session.invalidate();
//    }
//    req.getSession();
//    resp.sendRedirect("/");
//  }
  }
}

//  void RevokeAcess()
//  {
//    try{
//      HttpClient client = new DefaultHttpClient();
//      HttpPost post = new HttpPost("https://accounts.google.com/o/oauth2/revoke?token="+ACCESS_TOKEN);
//      org.apache.http.HttpResponse response = client.execute(post);
//    }
//    catch(IOException e)
//    {
//    }
//  }