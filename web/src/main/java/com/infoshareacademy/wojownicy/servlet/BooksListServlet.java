package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.Author;
import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.domain.Kind;
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
  @Inject
  private BookDaoBean bookDaoBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html; charset=UTF-8");

    Template template = templateProvider.getTemplate(getServletContext(), "book-list.ftlh");
    Book book1 = new Book();
    Book book2 = new Book();
    Book book3 = new Book();
    Book book4 = new Book();
    Book book5 = new Book();

    Author author1 = new Author();
    Author author2 = new Author();
    Author author3 = new Author();
    Author author4 = new Author();
    Author author5 = new Author();

    Kind kind1 = new Kind();
    Kind kind2 = new Kind();
    Kind kind3 = new Kind();
    Kind kind4 = new Kind();
    Kind kind5 = new Kind();

    kind1.setKind("Kind1");
    kind2.setKind("Kind2");
    kind3.setKind("Kind3");
    kind4.setKind("Kind4");
    kind5.setKind("Kind5");

    book1.setTitle("title1");
    book2.setTitle("title2");
    book3.setTitle("title3");
    book4.setTitle("title4");
    book5.setTitle("title5");


    author1.setAuthorName("author1");
    author2.setAuthorName("author2");
    author3.setAuthorName("author3");
    author4.setAuthorName("author4");
    author5.setAuthorName("author5");

    book1.setAuthor(author1);
    book2.setAuthor(author2);
    book3.setAuthor(author3);
    book4.setAuthor(author4);
    book5.setAuthor(author5);

    book1.setCoverURL("image1");
    book2.setCoverURL("image1");
    book3.setCoverURL("image1");
    book4.setCoverURL("image1");
    book5.setCoverURL("image1");

    book1.setKind(kind1);
    book2.setKind(kind2);
    book3.setKind(kind3);
    book4.setKind(kind4);
    book5.setKind(kind5);

    bookDaoBean.addBook(book1);
    bookDaoBean.addBook(book2);
    bookDaoBean.addBook(book3);
    bookDaoBean.addBook(book4);
    bookDaoBean.addBook(book5);




    List<Book> booksList = new ArrayList<>();
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
