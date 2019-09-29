package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBean;
import com.infoshareacademy.wojownicy.dao.ReservationsAuthorStatisticsDao;
import com.infoshareacademy.wojownicy.dao.ReservationsBookStatisticsDao;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.domain.entity.ReservationsAuthorStatistics;
import com.infoshareacademy.wojownicy.domain.entity.ReservationsBookStatistics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class StatisticsService {

  @EJB
  private ReservationsAuthorStatisticsDao reservationsAuthorStatisticsDao;

  @EJB
  private ReservationsBookStatisticsDao reservationsBookStatisticsDao;

  public List<ReservationsAuthorStatistics> getAuthorStatisticsList(){
    return reservationsAuthorStatisticsDao.getReservationsAuthorList();
  }

  public List<ReservationsBookStatistics> getBookStatisticsList(){
    return reservationsBookStatisticsDao.getReservationsBookList();
  }
}
