package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

  private Map<String, Object> additionalProperties = new HashMap<>();

  public String getKind() {
    return kind;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public Boolean getHasAudio() {
    return hasAudio;
  }

  public String getGenre() {
    return genre;
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
    return kind.equals(book.kind) &&
        title.equals(book.title) &&
        author.equals(book.author) &&
        hasAudio.equals(book.hasAudio) &&
        genre.equals(book.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, title, author, hasAudio, genre);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
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