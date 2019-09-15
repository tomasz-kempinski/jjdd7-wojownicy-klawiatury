package com.infoshareacademy.wojownicy.dto;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BookDto {

  private Long id;
  private String title;
  private Author author;
  private List<GenreDto> genresList = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<GenreDto> getGenresList() {
    return genresList;
  }

  public void setGenresList(List<GenreDto> genresList) {
    this.genresList = genresList;
  }
}
