package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.Author;
import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.service.AuthorService;
import com.infoshareacademy.wojownicy.service.BookService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prepare-data")
public class PrepareData extends HttpServlet {

  @Inject
  private AuthorService authorService;

  @Inject
  private BookService bookService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    Author author1 = new Author();
    author1.setAuthorName("Krzysztof Kamil Baczyński1");
    Author author2 = new Author();
    author1.setAuthorName("Krzysztof Kamil Baczyński2");
    Author author3 = new Author();
    author1.setAuthorName("Krzysztof Kamil Baczyński3");

    authorService.saveAuthor(author1);
    authorService.saveAuthor(author2);
    authorService.saveAuthor(author3);

    Book book1 = new Book();
    book1.setAuthor(author1);
    book1.setTitle("Tytuł test 1");

    Book book2 = new Book();
    book2.setAuthor(author1);
    book2.setTitle("Tytuł test 2");

    Book book3 = new Book();
    book3.setAuthor(author2);
    book3.setTitle("Tytuł test 3");

    Book book4 = new Book();
    book4.setAuthor(author2);
    book4.setTitle("Tytuł test 4");

    Book book5 = new Book();
    book5.setAuthor(author3);
    book5.setTitle("Tytuł test 5");

    bookService.saveBook(book1);
    bookService.saveBook(book2);
    bookService.saveBook(book3);
    bookService.saveBook(book4);
    bookService.saveBook(book5);


  }
}