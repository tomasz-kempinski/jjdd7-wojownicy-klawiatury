package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBean;
import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.dao.ReservationsAuthorStatisticsDao;
import com.infoshareacademy.wojownicy.dao.ReservationsBookStatisticsDao;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.ReservationsAuthorStatistics;
import com.infoshareacademy.wojownicy.domain.entity.ReservationsBookStatistics;
import com.infoshareacademy.wojownicy.dto.AuthorStatisticsDto;
import com.infoshareacademy.wojownicy.dto.BookStatisticsDto;
import com.infoshareacademy.wojownicy.mapper.AuthorStatisticsMapper;
import com.infoshareacademy.wojownicy.mapper.BookStatisticsMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class StatisticsService {

  private Map<Long, ReservationsAuthorStatistics> authorStats;

  @EJB
  private AuthorStatisticsMapper authorStatisticsMapper;

  @EJB
  private BookStatisticsMapper bookStatisticsMapper;

  @EJB
  private ReservationsAuthorStatisticsDao reservationsAuthorStatisticsDao;

  @EJB
  private ReservationsBookStatisticsDao reservationsBookStatisticsDao;

  @EJB
  private BookDaoBean bookDaoBean;

  @EJB
  private AuthorDaoBean authorDaoBean;

  public List<AuthorStatisticsDto> getAuthorStatisticsList(){
    List<AuthorStatisticsDto> statisticsDtoList = new ArrayList<>();
    List<ReservationsAuthorStatistics> authorStatistics =
        reservationsAuthorStatisticsDao.getReservationsAuthorList();

    authorStatistics.forEach(s -> {
      AuthorStatisticsDto statisticsDto = authorStatisticsMapper.mapEntityToDao(s);
      statisticsDtoList.add(statisticsDto);
    } );
    return statisticsDtoList;
  }

  public List<ReservationsAuthorStatistics> getAuthorStatisticsListEntity(){
    return reservationsAuthorStatisticsDao.getReservationsAuthorList();
  }

  public List<BookStatisticsDto> getBookStatisticsList(){
    List<BookStatisticsDto> statisticsDtoList = new ArrayList<>();
    List<ReservationsBookStatistics> bookStatistics =
        reservationsBookStatisticsDao.getReservationsBookList();

    bookStatistics.forEach(s -> {
      BookStatisticsDto statisticsDto = bookStatisticsMapper.mapEntityToDto(s);
      statisticsDtoList.add(statisticsDto);
    });
    return statisticsDtoList;
  }

  public List<ReservationsBookStatistics> getBookStatisticsListEntity(){
    return reservationsBookStatisticsDao.getReservationsBookList();
  }

 public void addStatistic(Long bookId){
    Author author = bookDaoBean.getBookById(bookId).getAuthor();
    Long numberOfReservations;
    if(bookDaoBean.getBookById(bookId).getAuthor().getReservationsAuthorStatistics() != null){
      ReservationsAuthorStatistics reservationsAuthorStatistics = reservationsAuthorStatisticsDao.getReservationsOfAuthor(author.getAuthorId());
      reservationsAuthorStatistics.setReservedCounter(reservationsAuthorStatistics.getReservedCounter()+1L);
      reservationsAuthorStatisticsDao.addReservationToAuthor(reservationsAuthorStatistics);
    }else {
      ReservationsAuthorStatistics reservationsAuthorStatistics = new ReservationsAuthorStatistics();
      reservationsAuthorStatistics.setAuthor(author);
      reservationsAuthorStatistics.setReservedCounter(1L);
      author.setReservationsAuthorStatistics(reservationsAuthorStatistics);
      authorDaoBean.editAuthor(author);
    }

    Book book = bookDaoBean.getBookById(bookId);
    if(bookDaoBean.getBookById(bookId).getReservationsBookStatistics() != null ){
      ReservationsBookStatistics reservationsBookStatistics = reservationsBookStatisticsDao.getReservationsOfBook(bookId);
      reservationsBookStatistics.setReservedCounter(reservationsBookStatistics.getReservedCounter()+1L);
      reservationsBookStatisticsDao.addReservationToBook(reservationsBookStatistics);
    } else {
      ReservationsBookStatistics reservationsBookStatistics = new ReservationsBookStatistics();
      reservationsBookStatistics.setBook(book);
      reservationsBookStatistics.setReservedCounter(1L);
      book.setReservationsBookStatistics(reservationsBookStatistics);
      bookDaoBean.editBook(book);
    }
  }
}
