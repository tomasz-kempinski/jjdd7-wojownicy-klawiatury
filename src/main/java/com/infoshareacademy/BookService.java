package com.infoshareacademy;

import com.infoshareacademy.repository.BookRepository;

public class BookService {

  public void setIdForBooks() {
    for (Book book : BookRepository.getBooks()) {
      if (book.getId() == null) {
        book.setId(BookRepository.getCurrentId());
        BookRepository.increaseCurrentId();
      }
    }
  }

  public void setFavouriteForBooks() {
    for (Book book : BookRepository.getBooks()) {
      if (book.getFavourite() == null) {
        book.setFavourite(false);
      }
    }

  }

  public void checkForMaxId() {
    BookRepository.getBooks().forEach(b -> {
      if (b.getId() > BookRepository.getCurrentId()) {
        BookRepository.setCurrentId(b.getId());
      }
    });
  }

  public void addBook(String kind, String title, String author, Boolean hasAudio,
      String genre) {
    Book book = new Book(kind, title, author, hasAudio, genre);
    BookRepository.getBooks().add(book);
    setIdForBooks();
    setFavouriteForBooks();
  }

  public void deleteBook(Long id) {
    BookRepository.getBooks().removeIf(b -> b.getId().equals(id));
  }

  public void modifyAuthor(String author, Long id) {
    BookRepository.getBooks().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setAuthor(author);
      }
    });
  }

  public void modifyHasAudio(boolean hasAudio, Long id) {
    BookRepository.getBooks().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setHasAudio(hasAudio);
      }
    });
  }

  public void modifyGenre(String genre, Long id) {
    BookRepository.getBooks().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setGenre(genre);
      }
    });
  }

  public void modifyKind(String kind, Long id) {
    BookRepository.getBooks().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setKind(kind);
      }
    });
  }

  public void modifyTitle(String title, Long id) {
    BookRepository.getBooks().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setTitle(title);
      }
    });
  }

  public void modifyFavourite(boolean favourite, Long id) {
    BookRepository.getBooks().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setFavourite(favourite);
      }
    });
  }
}
