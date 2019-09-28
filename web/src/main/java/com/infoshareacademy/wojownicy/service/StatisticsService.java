package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBean;
import com.infoshareacademy.wojownicy.dao.ReservationsAuthorStatisticsDao;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.ReservationsAuthorStatistics;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class StatisticsService {

  @EJB
  private AuthorDaoBean authorDaoBean;

  public List<Author> getAuthorStatisticsList(){
    return authorDaoBean.getAuthorsList();
  }

}
