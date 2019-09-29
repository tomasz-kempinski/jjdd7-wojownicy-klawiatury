package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.ReservationsBookStatistics;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationsBookStatisticsDao {

  @PersistenceContext
  EntityManager entityManager;

  public void addReservationToAuthor(ReservationsBookStatistics reservationsBookStatistics){
    entityManager.persist(reservationsBookStatistics);
  }

  public ReservationsBookStatistics getReservationsOfBook(long id){
    return entityManager.find(ReservationsBookStatistics.class, id);
  }

  public List<ReservationsBookStatistics> getReservationsBookList(){
    return entityManager.createNamedQuery("StatisticsBook.findBookStatistics").getResultList();
  }

}
