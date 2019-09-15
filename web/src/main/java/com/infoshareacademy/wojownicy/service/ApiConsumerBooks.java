package com.infoshareacademy.wojownicy.service;


import com.infoshareacademy.wojownicy.domain.api.Book;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class ApiConsumerBooks {

  private WebTarget webTarget;
  private static final String BooksURI = "http://isa-proxy.blueazurit.com/books/daisy/";

  @Inject
  private ParseService parseService;

  public List<Book> consumeBooks() throws IOException {
    initBooks();
    Response response = webTarget.request().get();
    String resp = response.readEntity(String.class);
    response.close();
    return parseService.parseBooksFromApi(resp);
  }

  private void initBooks() {
    Client client = ClientBuilder.newClient();
    webTarget = client.target(BooksURI);
  }
}
