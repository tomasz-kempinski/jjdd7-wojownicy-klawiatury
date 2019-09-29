package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBean;
import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.dao.ReservationsAuthorStatisticsDao;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.ReservationsAuthorStatistics;
import com.infoshareacademy.wojownicy.domain.entity.ReservationsBookStatistics;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@WebServlet("/add-statistics")
public class StatisticsClass extends HttpServlet {

  @Inject
  ReservationsAuthorStatisticsDao reservationsAuthorStatisticsDao;

  @Inject
  AuthorDaoBean authorDaoBean;

  @Inject
  BookDaoBean bookDaoBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    ReservationsAuthorStatistics reservationsAuthorStatistics1 = new ReservationsAuthorStatistics();
    ReservationsAuthorStatistics reservationsAuthorStatistics2 = new ReservationsAuthorStatistics();

    Author author1 = authorDaoBean.getAuthorById(1l);
    Author author2 = authorDaoBean.getAuthorById(2l);
    reservationsAuthorStatistics1.setReservedCounter(2l);
    reservationsAuthorStatistics1.setAuthor(author1);
    reservationsAuthorStatistics2.setReservedCounter(3l);
    reservationsAuthorStatistics2.setAuthor(author2);
    author1.setReservationsAuthorStatistics(reservationsAuthorStatistics1);
    author2.setReservationsAuthorStatistics(reservationsAuthorStatistics2);
    authorDaoBean.editAuthor(author1);
    authorDaoBean.editAuthor(author2);

    ReservationsBookStatistics reservationsBookStatistics1 = new ReservationsBookStatistics();
    ReservationsBookStatistics reservationsBookStatistics2 = new ReservationsBookStatistics();
    Book book1 = new Book();
    Book book2 = new Book();
    book1 = bookDaoBean.getBookById(1l);
    book2 = bookDaoBean.getBookById(2l);
    reservationsBookStatistics1.setReservedCounter(1l);
    reservationsBookStatistics2.setReservedCounter(2l);
    reservationsBookStatistics1.setBook(book1);
    reservationsBookStatistics2.setBook(book2);
    book1.setReservationsBookStatistics(reservationsBookStatistics1);
    book2.setReservationsBookStatistics(reservationsBookStatistics2);

    bookDaoBean.editBook(book1);
    bookDaoBean.editBook(book2);



  }
}
