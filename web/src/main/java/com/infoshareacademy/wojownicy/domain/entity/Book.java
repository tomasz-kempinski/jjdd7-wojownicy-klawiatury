package com.infoshareacademy.wojownicy.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(
        name = "Book.findBookList",
        query = "SELECT b FROM Book b"
    ),
    @NamedQuery(
        name = "Book.listCount",
        query = "SELECT count (book_title) FROM Book b"
    ),
    @NamedQuery(
        name = "Book.getPartOfBookList",
        query = "SELECT b from Book b where id between ?1 and ?2"
    ),
    @NamedQuery(
        name = "Book.findBookGenres",
        query = "select b.title, g.id, g.genreName from Book b join fetch book_genre bg on b.id = bg.id join fetch Genre g on g.id = bg.id"
    )
})
@Entity
@Table(name = "book")
public class Book {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "book_title")
  private String title;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  private Author author;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "book_genre",
      joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
  private List<Genre> genres = new ArrayList<>();

  @ManyToMany
  @JoinTable(
      name = "favourite_book_to_user",
      joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
  private List<User> usersFavourites = new ArrayList<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "kind_id")
  private Kind kind;

  @Column(name = "cover_url")
  private String coverURL;

  @Column(name = "thumbnail")
  private String thumbnail;

  @NotNull
  @Column(name = "is_reserved")
  private boolean isReserved = false;

  @NotNull
  @Column(name = "has_audio")
  private boolean hasAudio = false;

  @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Reservation> bookReservation = new ArrayList<>();

  public Long getId() {
    return id;
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

  public List<Genre> getGenres() {
    return genres;
  }

  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }

  public List<User> getUsersFavourites() {
    return usersFavourites;
  }

  public void setUsersFavourites(
      List<User> usersFavourites) {
    this.usersFavourites = usersFavourites;
  }

  public Kind getKind() {
    return kind;
  }

  public void setKind(Kind kind) {
    this.kind = kind;
  }

  public String getCoverURL() {
    return coverURL;
  }

  public void setCoverURL(String coverURL) {
    this.coverURL = coverURL;
  }

  public String getThumbnail() { return thumbnail; }

  public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

  public boolean isReserved() {
    return isReserved;
  }

  public void setReserved(boolean reserved) {
    isReserved = reserved;
  }

  public boolean isAudio() {
    return hasAudio;
  }

  public void setHasAudio(boolean hasAudio) {
    this.hasAudio = hasAudio;
  }

  public List<Reservation> getBookReservation() {
    return bookReservation;
  }

  public void setBookReservation(
      List<Reservation> bookReservation) {
    this.bookReservation = bookReservation;
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
    return hasAudio == book.hasAudio &&
        title.equals(book.title) &&
        author.equals(book.author) &&
        genres.equals(book.genres) &&
        Objects.equals(usersFavourites, book.usersFavourites) &&
        kind.equals(book.kind) &&
        Objects.equals(coverURL, book.coverURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, genres, usersFavourites, kind, coverURL, hasAudio);
  }
}
