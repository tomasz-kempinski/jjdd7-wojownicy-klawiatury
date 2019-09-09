package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.Book;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/book-list")
public class BooksListServlet extends HttpServlet {

  @Inject
  private TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html; charset=UTF-8");

    Template template = templateProvider.getTemplate(getServletContext(), "book-list.ftlh");
    Book book1 = new Book();
    Book book2 = new Book();
    Book book3 = new Book();

    book1.setAuthor("book1 author");
    book1.setName("book1 name");
    book1.setGenre("book 1 genre");

    book2.setAuthor("book2 author");
    book2.setName("book2 name");
    book2.setGenre("book2 genre");

    book3.setAuthor("book3 author");
    book3.setName("book3 name");
    book3.setGenre("book3 genre");
    List<Book> booksList = new ArrayList<>();
    booksList.add(book1);
    booksList.add(book2);
    booksList.add(book3);



    Map<String, List<Book>> dataModel = new HashMap<>();
    dataModel.put("books",booksList);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
