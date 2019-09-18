package com.infoshareacademy.wojownicy.dto;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Kind;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BookDto {

  private Long id;
  private String title;
  private Author author;
  private List<GenreDto> genresList = new ArrayList<>();
  private String genreName;
  private String cover;
  private String thumbnail;
  private Kind kind;
  private boolean hasAudio;

  public boolean isHasAudio() {
    return hasAudio;
  }

  public void setHasAudio(boolean hasAudio) {
    this.hasAudio = hasAudio;
  }

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

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public Kind getKind() {
    return kind;
  }

  public void setKind(Kind kind) {
    this.kind = kind;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getGenreName() {
    return genreName;
  }

  public void setGenreName(String genreName) {
    this.genreName = genreName;
  }
}
