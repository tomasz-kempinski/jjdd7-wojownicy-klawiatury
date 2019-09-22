package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.cdi.FileUploadProcessor;
import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.domain.entity.Kind;
import com.infoshareacademy.wojownicy.exception.UserFileNotFound;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MultipartConfig
@WebServlet("/book-create")
public class BookCreateServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  FileUploadProcessor fileUploadProcessor;

  @Inject
  BookDaoBean bookDaoBean;

  private static final Logger logger = LoggerFactory.getLogger(BookCreateServlet.class.getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-create-site.ftlh");

    String upload = req.getParameter("upload");

    Map<String, Object> dataModel = new HashMap<>();

//    dataModel.put("upload", upload);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    String title = req.getParameter("title");
    String authorName = req.getParameter("author");
    String kindName = req.getParameter("kind");
    String genreName = req.getParameter("genre");

    Part file = req.getPart("file");

    Author author = new Author();
    author.setAuthorName(authorName);

    Genre genre = new Genre();
    genre.setGenreName(genreName);
    List<Genre> genres = new ArrayList<>();
    genres.add(genre);

    Kind kind = new Kind();
    kind.setKind(kindName);

    Book book = new Book();
    book.setTitle(title);
    book.setAuthor(author);
    book.setKind(kind);
    book.setGenres(genres);

    bookDaoBean.addBook(book);

    String fileURL = "";

    try {
      fileURL = "/admin-panel/" + fileUploadProcessor
          .uploadFile(file).getName();
      resp.sendRedirect("/admin-panel?upload=successful");
    } catch (UserFileNotFound userFileNotFound) {
      logger.warn(userFileNotFound.getMessage());
      resp.sendRedirect("/admin-panel?upload=failed");
    }
  }
}
