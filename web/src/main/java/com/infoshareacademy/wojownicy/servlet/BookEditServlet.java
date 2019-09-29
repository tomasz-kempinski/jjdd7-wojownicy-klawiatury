package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.domain.entity.Kind;
import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.exception.UserImageNotFound;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.processor.ImageUploadProcessor;
import com.infoshareacademy.wojownicy.service.BookListService;
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
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MultipartConfig
@WebServlet("/book-edit")
public class BookEditServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(BookEditServlet.class.getName());

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  ImageUploadProcessor imageUploadProcessor;

  @Inject
  private BookListService bookListService;

  @Inject
  BookService bookService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "book-edit-site.ftlh");
    String idString = req.getParameter("id").replaceAll(",", "");
    String partString = req.getParameter("part");
    String siteType = (String) req.getAttribute("siteType");
    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("siteType", siteType);
    long id=1;
    long part=1;
    String audio;
    boolean hasAudio = false;

    if (NumberUtils.isDigits(idString) && NumberUtils.isDigits(partString)
        && Long.parseLong(idString) > 0) {
      id = Long.parseLong(idString);
      part = Long.parseLong(partString) + 1;
    }
    hasAudio = bookListService.hasAudio(id);
    if (hasAudio) {
      audio = "dostępna";
    } else {
      audio = "niedostępna";
    }
    BookDto book = bookListService.getSingleBook(id);
    dataModel.put("book", book);
    dataModel.put("hasAudio", audio);
    dataModel.put("part", part);

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
      throws ServletException, IOException {

    Long id = Long.parseLong(req.getParameter("id"));
    String title = req.getParameter("title");
    String authorName = req.getParameter("author");
    String kindName = req.getParameter("kind");
    String genreName = req.getParameter("genre");
    String audio = req.getParameter("audio");

    Part file = req.getPart("file");

    Book book = bookService.findBookById(id);

    if (!title.isEmpty()) {
      book.setTitle(title);
    } else {
      book.setTitle(book.getTitle());
    }

    if (!authorName.isEmpty()) {
      Author author = new Author();
      author.setAuthorName(authorName);
      book.setAuthor(author);
    } else {
      book.setAuthor(book.getAuthor());
    }

    if (!genreName.isEmpty()) {
      Genre genre = new Genre();
      genre.setGenreName(genreName);
      List<Genre> genres = new ArrayList<>();
      genres.add(genre);
      book.setGenres(genres);
    } else {
      book.setGenres(book.getGenres());
    }

    if (!kindName.isEmpty()) {
      Kind kind = new Kind();
      kind.setKind(kindName);
      book.setKind(kind);
    } else {
      book.setKind(book.getKind());
    }

    if (!audio.isEmpty()) {
      if (audio.equalsIgnoreCase("tak")) {
        book.setHasAudio(true);
      } else {
        book.setHasAudio(false);
      }
    } else {
      book.setHasAudio(book.isAudio());
    }

    String fileURL = "";

    try {
      fileURL = "/images/" + imageUploadProcessor
          .uploadImageFile(file, id).getName();
    } catch (UserImageNotFound userImageNotFound) {
      logger.warn(userImageNotFound.getMessage());
    }

    if (!fileURL.isEmpty()) {
      book.setCoverURL(fileURL);

      book.setThumbnail(fileURL);
    } else {
      book.setCoverURL(book.getCoverURL());

      book.setThumbnail(book.getThumbnail());
    }

    bookService.updateBook(book);

    resp.sendRedirect("/book-view?id=" + id + "&part=0&hasAudio=0&kind=0");
  }
}

