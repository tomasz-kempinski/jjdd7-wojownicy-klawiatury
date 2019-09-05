package com.infoshareacademy.wojownicy.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "genre")
public class Genre {

  @Id
  @Column(name = "genre_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long genreId;

  @NotNull
  @Column(name = "genre_name")
  private String genreName;

  @ManyToMany(mappedBy = "genres")
  private Set<Book> books = new HashSet<>();

}
