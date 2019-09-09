package com.infoshareacademy.wojownicy.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long authorId;

  @NotNull
  @Column(name = "username")
  private String authorName;

  @NotNull
  @Column(name = "is_admin")
  private boolean isAdmin = false;

  @ManyToMany(mappedBy = "usersFavourites")
  List<Book> booksFavourites = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Reservation> userReservations = new ArrayList<>();

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  public List<Book> getBooksFavourites() {
    return booksFavourites;
  }

  public void setBooksFavourites(
      List<Book> booksFavourites) {
    this.booksFavourites = booksFavourites;
  }

  public List<Reservation> getUserReservations() {
    return userReservations;
  }

  public void setUserReservations(
      List<Reservation> userReservations) {
    this.userReservations = userReservations;
  }
}
