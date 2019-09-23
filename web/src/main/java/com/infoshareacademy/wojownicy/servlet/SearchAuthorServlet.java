package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/search-author")
public class SearchAuthorServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(BooksListServlet.class.getName());

  @Inject
  private TemplateProvider templateProvider;

  @EJB
  private BookService bookService;

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "livesearch-author.ftlh");
    String authorId = req.getParameter("id");
    Long id = Long.parseLong(authorId);

    List<BookDto> bookDtoListAuthorId = bookService.findBookForLiveSearchAuthorId(id);

    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("books", bookDtoListAuthorId);

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }
}
