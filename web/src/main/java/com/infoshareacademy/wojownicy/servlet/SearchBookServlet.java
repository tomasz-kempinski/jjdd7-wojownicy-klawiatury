package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.service.SearchBookService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search-book")
public class SearchBookServlet extends HttpServlet {

    @Inject
    SearchBookService searchBookService;



    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String searchParam = req.getParameter("searchParam");
        List<Book> bookList = searchBook(searchParam);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(bookList);
    }

//    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = resp.getWriter();
//        String searchParam = req.getParameter("searchParam");
//        searchBook(searchParam);
//        out.print(searchBook(searchParam));
//
//    }

    private List<Book> searchBook(String searchParam) {
        searchParam = searchParam.toUpperCase();
        List<Book> bookList = new ArrayList<>();
        for (Book book: searchBookService.getBooksList()) {
            String title = book.getTitle().toUpperCase();
            if(title.startsWith(searchParam)) {
                bookList.add(book);
            }
        }
        return (bookList);
    }
}
