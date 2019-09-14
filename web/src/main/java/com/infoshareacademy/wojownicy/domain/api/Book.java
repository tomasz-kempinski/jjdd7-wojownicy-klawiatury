package com.infoshareacademy.wojownicy.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

  @JsonProperty("kind")
  private String kind;

  @JsonProperty("title")
  private String title;

  @JsonProperty("author")
  private String author;

  @JsonProperty("has_audio")
  private Boolean hasAudio;

  @JsonProperty("genre")
  private String genre;

  @JsonProperty("cover")
  private String cover;

  @JsonProperty("cover_thumb")
  private String thumbnail;

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Boolean getHasAudio() {
    return hasAudio;
  }

  public void setHasAudio(Boolean hasAudio) {
    this.hasAudio = hasAudio;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
}