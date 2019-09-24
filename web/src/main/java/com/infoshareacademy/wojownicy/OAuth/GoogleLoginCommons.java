package com.infoshareacademy.wojownicy.OAuth;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;


public class GoogleLoginCommons {

  private static final String SETTINGS_FILE = "settings.properties";

  private static final List<String> scopes = List.of("openid", "email", "profile");

  public static String buildRedirectUri(HttpServletRequest req) throws IOException {
    GenericUrl url = new GenericUrl(req.getRequestURL().toString());
    url.setRawPath(getRedirectUrl());
    return url.build();
  }

  public static GoogleAuthorizationCodeFlow buildFlow() throws IOException {
    return new GoogleAuthorizationCodeFlow.Builder(
        new NetHttpTransport(),
        JacksonFactory.getDefaultInstance(),
        getClientId(), getSecret(), scopes)
        .setAccessType("online")
        .build();
  }

  private static String getClientId() throws IOException {
    Properties settings = new Properties();
    settings.load(Thread.currentThread()
        .getContextClassLoader().getResource(SETTINGS_FILE)
        .openStream());
    return settings.getProperty("Google.Login.ClientID");
  }

  private static String getSecret() throws IOException {
    Properties settings = new Properties();
    settings.load(Thread.currentThread()
        .getContextClassLoader().getResource(SETTINGS_FILE)
        .openStream());
    return settings.getProperty("Google.Login.Secret");
  }

  private static String getRedirectUrl() throws IOException {
    Properties settings = new Properties();
    settings.load(Thread.currentThread()
        .getContextClassLoader().getResource(SETTINGS_FILE)
        .openStream());
    return settings.getProperty("Google.Login.redirect");
  }
}