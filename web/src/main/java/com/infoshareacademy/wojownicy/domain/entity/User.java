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
}
