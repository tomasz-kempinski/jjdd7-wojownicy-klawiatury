package com.infoshareacademy.wojownicy.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(
        name = "User.findUsersList",
        query = "SELECT u FROM User u"
    )
})
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @NotNull
  @Column(name = "username")
  private String username;

  @NotNull
  @Column(name = "email")
  private String email;

  @Column(name = "is_admin")
  private boolean isAdmin = false;

  @ManyToMany(mappedBy = "usersFavourites")
  private List<Book> booksFavourites = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Reservation> userReservations = new ArrayList<>();

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
