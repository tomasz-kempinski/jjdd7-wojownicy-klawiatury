package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.clas.Book;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class ApiConsumer {
  private WebTarget webTarget;
  private static final String URI = "";

  @Inject
  private ParseService parseService;

  public List<Book> consumeBooks () throws IOException {
    initAddress();
    Response response = webTarget.request().get();
    String resp = response.readEntity(String.class);

    return parseService.parseFromApi(resp);
  }

  private void initAddress() {
    Client client = ClientBuilder.newClient();
    webTarget = client.target(URI);
  }
}
