package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.SearchBookService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search-book")
public class SearchBookServlet extends HttpServlet {

    @Inject
    private SearchBookService searchBookService;

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            resp.setContentType("text/html; charset=UTF-8");
            String searchParam = req.getParameter("searchParam");
            Template template = templateProvider.getTemplate(getServletContext(), "book-list.ftlh");

            List<Book> booksList = searchBookService.getBooksByParam(searchParam);
            Map<String, List<Book>> dataModel = new HashMap<>();
            dataModel.put("books", booksList);


            PrintWriter printWriter = resp.getWriter();
            try {
                template.process(dataModel, printWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
}
