package com.infoshareacademy.wojownicy.clas;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {

  @JsonProperty
  private Long id;
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
  @JsonProperty
  private Boolean isFavourite;

  private Map<String, Object> additionalProperties = new HashMap<>();

  public Book() {
  }

  public Book(String kind, String title, String author, Boolean hasAudio,
      String genre) {
    this.kind = kind;
    this.title = title;
    this.author = author;
    this.hasAudio = hasAudio;
    this.genre = genre;
  }

  public Boolean getFavourite() {
    return isFavourite;
  }

  public void setFavourite(Boolean favourite) {
    isFavourite = favourite;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(id, book.id) &&
        Objects.equals(kind, book.kind) &&
        Objects.equals(title, book.title) &&
        Objects.equals(author, book.author) &&
        Objects.equals(hasAudio, book.hasAudio) &&
        Objects.equals(genre, book.genre) &&
        Objects.equals(isFavourite, book.isFavourite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, title, author, hasAudio, genre);
  }

  @JsonAnyGetter
  private Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  private void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return "Book{" +
        "\nkind='" + kind + '\'' +
        "\ntitle='" + title + '\'' +
        "\nauthor='" + author + '\'' +
        "\nhasAudio=" + hasAudio +
        "\ngenre='" + genre + '\'' +
        "\n}";
  }
}