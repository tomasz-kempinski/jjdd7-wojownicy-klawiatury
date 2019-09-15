package com.infoshareacademy.wojownicy.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDto {

  private Long id;
  private String title;
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
