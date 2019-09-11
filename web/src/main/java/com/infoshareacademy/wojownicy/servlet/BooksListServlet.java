package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.dao.GenreDaoBean;
import com.infoshareacademy.wojownicy.domain.Author;
import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.domain.Genre;
import com.infoshareacademy.wojownicy.domain.Kind;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookListService;
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
  private BookListService bookListService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html; charset=UTF-8");
    Template template = templateProvider.getTemplate(getServletContext(), "book-list.ftlh");

    List<Book> booksList = bookListService.getBookList();
    Map<String,Integer> pagesMap = bookListService.pages();
    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("books",booksList);
    dataModel.put("page", pagesMap);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
