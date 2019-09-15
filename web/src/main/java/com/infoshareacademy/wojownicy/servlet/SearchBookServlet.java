package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.BookService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@WebServlet("/search-book")
public class SearchBookServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(SearchBookServlet.class.getName());
    @Inject
    private BookService bookService;
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String bookTitle = req.getParameter("bookTitle");
        //String authorName = req.getParameter("authorName");

        List<Book> checkedAuthorsAndTitles = bookService.findBookByTitleAndAuthor(bookTitle);

        Template template = templateProvider.getTemplate(getServletContext(), "book-list.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (checkedAuthorsAndTitles != null) {
            model.put("checkedAuthorsAndTitles", checkedAuthorsAndTitles);
        }
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }


    }

}