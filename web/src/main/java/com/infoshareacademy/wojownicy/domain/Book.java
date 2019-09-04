package com.infoshareacademy.wojownicy.domain;

public class Book {

  Integer bookId;
  String title;
  Integer authorId;
  Integer genre;
  Integer kind;
  Boolean favourite;
  String cover_url;
  Boolean reserved;
  Integer reservedBy;
  Boolean hasAudio;

  public Integer getBookId() {
    return bookId;
  }

  public void setBookId(Integer bookId) {
    this.bookId = bookId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Integer authorId) {
    this.authorId = authorId;
  }

  public Integer getGenre() {
    return genre;
  }

  public void setGenre(Integer genre) {
    this.genre = genre;
  }

  public Integer getKind() {
    return kind;
  }

  public void setKind(Integer kind) {
    this.kind = kind;
  }

  public Boolean getFavourite() {
    return favourite;
  }

  public void setFavourite(Boolean favourite) {
    this.favourite = favourite;
  }

  public String getCover_url() {
    return cover_url;
  }

  public void setCover_url(String cover_url) {
    this.cover_url = cover_url;
  }

  public Boolean getReserved() {
    return reserved;
  }

  public void setReserved(Boolean reserved) {
    this.reserved = reserved;
  }

  public Integer getReservedBy() {
    return reservedBy;
  }

  public void setReservedBy(Integer reservedBy) {
    this.reservedBy = reservedBy;
  }

  public Boolean getHasAudio() {
    return hasAudio;
  }

  public void setHasAudio(Boolean hasAudio) {
    this.hasAudio = hasAudio;
  }
}