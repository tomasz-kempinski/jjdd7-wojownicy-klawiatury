package com.infoshareacademy.wojownicy.domain.view;

import com.infoshareacademy.wojownicy.domain.entity.Author;

public class BookLiveSearchView {

  private Long id;
  private String title;
  private Author author;
  private String genre;
  private String kind;

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

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }
}
