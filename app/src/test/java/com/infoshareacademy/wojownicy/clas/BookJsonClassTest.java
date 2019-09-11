package com.infoshareacademy.wojownicy.clas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BookJsonClassTest {

  @Test
  void getFavourite() {
    BookJsonClass bookJsonClass = new BookJsonClass();
    bookJsonClass.setFavourite(true);

    assertThat(bookJsonClass.getFavourite()).isTrue()
        .isNotNull();
  }

  @Test
  void setFavourite() {
    BookJsonClass bookJsonClass = new BookJsonClass();
    bookJsonClass.setFavourite(false);

    assertThat(bookJsonClass.getFavourite()).isFalse()
        .isNotNull();
  }

  @Test
  void getId() {
    BookJsonClass bookJsonClass = new BookJsonClass();
    bookJsonClass.setId((long) 1);

    assertThat(bookJsonClass.getId()).isEqualTo(1)
        .isNotNull();
  }

  @Test
  void setId() {
    BookJsonClass bookJsonClass = new BookJsonClass();
    bookJsonClass.setId((long) 1);

    assertThat(bookJsonClass.getId()).isEqualTo(1)
        .isNotNull();
  }

  @Test
  void getKind() {
    BookJsonClass bookJsonClass = new BookJsonClass("drama", "Romeo and Juliet", "William Shakespeare", true, "tragedy");

    String output = bookJsonClass.getKind();

    assertThat(output).isEqualToIgnoringCase("Drama")
        .containsIgnoringCase("RaM")
        .isNotEmpty();
  }

  @Test
  void setKind() {
    BookJsonClass bookJsonClass = new BookJsonClass();

    bookJsonClass.setKind("epic");

    assertThat(bookJsonClass.getKind()).isEqualToIgnoringCase("EpIc")
        .containsIgnoringCase("PI")
        .isNotEmpty();
  }

  @Test
  void getTitle() {
    BookJsonClass bookJsonClass = new BookJsonClass("drama", "Romeo and Juliet", "William Shakespeare", true, "tragedy");

    String output = bookJsonClass.getTitle();

    assertThat(output).isEqualToIgnoringCase("romeo AND juliet")
        .containsIgnoringCase("LiEt")
        .isNotEmpty();
  }

  @Test
  void setTitle() {
    BookJsonClass bookJsonClass = new BookJsonClass();

    bookJsonClass.setTitle("Harry Potter");

    assertThat(bookJsonClass.getTitle()).isEqualToIgnoringCase("haRRy pOtter")
        .containsIgnoringCase("Otter")
        .isNotEmpty();
  }

  @Test
  void getAuthor() {
    BookJsonClass bookJsonClass = new BookJsonClass("drama", "Romeo and Juliet", "William Shakespeare", true, "tragedy");

    String output = bookJsonClass.getAuthor();

    assertThat(output).isEqualToIgnoringCase("wiLLiam SHakeSpeare")
        .containsIgnoringCase("shakes")
        .isNotEmpty();
  }

  @Test
  void setAuthor() {
    BookJsonClass bookJsonClass = new BookJsonClass();

    bookJsonClass.setAuthor("Charles Bukowski");

    assertThat(bookJsonClass.getAuthor()).isEqualToIgnoringCase("chaRleS bUkOwSki")
        .containsIgnoringCase("Les Buk")
        .isNotEmpty();
  }

  @Test
  void getHasAudio() {
    BookJsonClass bookJsonClass = new BookJsonClass("drama", "Romeo and Juliet", "William Shakespeare", true, "tragedy");

    Boolean output = bookJsonClass.getHasAudio();

    assertThat(output).isTrue()
        .isNotNull();
  }

  @Test
  void setHasAudio() {
    BookJsonClass bookJsonClass = new BookJsonClass();

    bookJsonClass.setHasAudio(false);

    assertThat(bookJsonClass.getHasAudio()).isFalse()
        .isNotNull();
  }

  @Test
  void getGenre() {
    BookJsonClass bookJsonClass = new BookJsonClass("drama", "Romeo and Juliet", "William Shakespeare", true, "tragedy");

    String output = bookJsonClass.getGenre();

    assertThat(output).isEqualToIgnoringCase("TrAgEdY")
        .containsIgnoringCase("aGE")
        .isNotEmpty();
  }

  @Test
  void setGenre() {
    BookJsonClass bookJsonClass = new BookJsonClass();

    bookJsonClass.setGenre("comedy");

    assertThat(bookJsonClass.getGenre()).isEqualToIgnoringCase("CoMEDy")
        .containsIgnoringCase("mEd")
        .isNotEmpty();
  }
}