package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.ReservationsAuthorStatisticsDao;
import com.infoshareacademy.wojownicy.dao.ReservationsBookStatisticsDao;
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
}
