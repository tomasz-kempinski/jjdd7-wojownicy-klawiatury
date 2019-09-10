package com.infoshareacademy.wojownicy.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@NamedQueries({
    @NamedQuery(
        name = "Genre.findGenresList",
        query = "SELECT u FROM Genre u"
    )
})
@Entity
@Table(name = "genre")
public class Genre {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long genreId;

  @NotNull
  @Column(name = "genre_name")
  private String genreName;

  @ManyToMany(mappedBy = "genres")
  private List<Book> books = new ArrayList<>();
}
