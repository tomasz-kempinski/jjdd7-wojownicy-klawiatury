package com.infoshareacademy.wojownicy.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @Column(name = "book_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "book_title")
  private String title;

  @ManyToOne
  @JoinColumn(name = "author_id")
  Author author;

  @ManyToMany
  @JoinTable(
      name = "book_genre",
      joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genre_id"))
  List<Genre> genres = new ArrayList<>();

  @ManyToMany
  @JoinTable(
      name = "favourite_book_to_user",
      joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
  List<User> usersFavourites = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "kind_id")
  Kind kind;

  @NotNull
  @Column(name = "is_favourite")
  private boolean isFavourite = false;

  @NotNull
  @Column(name = "cover_url")
  private String coverURL;

  @NotNull
  @Column(name = "is_reserved")
  private boolean isReserved = false;

  @NotNull
  @Column(name = "has_audio")
  private boolean hasAudio = false;

  @ManyToOne
  @JoinColumn(name = "is_reserved_by")
  User user;

}
