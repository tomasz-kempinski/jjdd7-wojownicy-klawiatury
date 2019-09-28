package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.domain.entity.Kind;
import com.infoshareacademy.wojownicy.exception.UserImageNotFound;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.processor.ImageUploadProcessor;
import com.infoshareacademy.wojownicy.service.BookService;
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
@WebServlet("/book-add")
public class BookAddServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  ImageUploadProcessor imageUploadProcessor;

  @Inject
  BookService bookService;

  private static final Logger logger = LoggerFactory.getLogger(BookAddServlet.class.getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-add-site.ftlh");

    Map<String, Object> dataModel = new HashMap<>();

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
    String audio = req.getParameter("audio");

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

    if (audio.equalsIgnoreCase("tak")) {
      book.setHasAudio(true);
    } else {
      book.setHasAudio(false);
    }

    bookService.addBook(book);

    Long id = book.getId();

    String fileURL = "";

    try {
      fileURL = imageUploadProcessor
          .uploadImageFile(file, id).getAbsolutePath();
    } catch (UserImageNotFound userImageNotFound) {
      logger.warn(userImageNotFound.getMessage());
    }

    if (!fileURL.isEmpty()) {
      book.setCoverURL(fileURL);

      book.setThumbnail(fileURL);

      bookService.updateBook(book);

      resp.sendRedirect("/book-view?id=" + id + "&part=0&hasAudio=0&kind=0");
    }

    resp.sendRedirect("/book-view?id=" + id + "&part=0&hasAudio=0&kind=0");
  }
}