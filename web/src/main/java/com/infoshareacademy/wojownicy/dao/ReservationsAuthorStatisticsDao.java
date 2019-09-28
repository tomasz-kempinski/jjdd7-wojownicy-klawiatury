package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.ReservationsAuthorStatistics;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ReservationsAuthorStatisticsDao {

  @PersistenceContext
  EntityManager entityManager;

  public void addReservationToAuthor(ReservationsAuthorStatistics reservationsAuthorStatistics){
    entityManager.persist(reservationsAuthorStatistics);
  }

  public ReservationsAuthorStatistics getReservationsOfAuthor(long id){
    return entityManager.find(ReservationsAuthorStatistics.class, id);
  }


}
