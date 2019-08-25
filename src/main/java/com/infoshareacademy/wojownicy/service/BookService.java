package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.clas.Book;
import com.infoshareacademy.wojownicy.repository.BookRepository;

public class BookService {

  private static Long maxId = 0L;

  public void setIdForBooks() {
    for (Book book : BookRepository.getBookRepository()) {
      if (book.getId() == null) {
        book.setId(getCurrentId());
        increaseCurrentId();
      }
    }
  }

  public void setFavouriteForBooks() {
    for (Book book : BookRepository.getBookRepository()) {
      if (book.getFavourite() == null) {
        book.setFavourite(false);
      }
    }
  }

  private static Long getCurrentId() {
    return maxId;
  }

  private static void setCurrentId(Long currentId) {
    maxId = currentId;
  }

  private static void increaseCurrentId() {
    maxId++;
  }

  public void checkForMaxId() {
    BookRepository.getBookRepository().forEach(b -> {
      if (b.getId() > getCurrentId()) {
        setCurrentId(b.getId());
      }
    });
  }

  public void addBook(String kind, String title, String author, Boolean hasAudio,
      String genre) {
    Book book = new Book(kind, title, author, hasAudio, genre);
    BookRepository.getBookRepository().add(book);
    setIdForBooks();
    setFavouriteForBooks();
  }

  public void deleteBook(Long id) {
    if (checkIfBookExists(id)) {
      BookRepository.getBookRepository().removeIf(b -> b.getId().equals(id));
    } else {
      System.out.println("Nie znaleziono takiej książki");
    }
  }

  public void modifyAuthor(String author, Long id) {
    BookRepository.getBookRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setAuthor(author);
      }
    });
  }

  public void modifyHasAudio(boolean hasAudio, Long id) {
    BookRepository.getBookRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setHasAudio(hasAudio);
      }
    });
  }

  public void modifyGenre(String genre, Long id) {
    BookRepository.getBookRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setGenre(genre);
      }
    });
  }

  public void modifyKind(String kind, Long id) {
    BookRepository.getBookRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setKind(kind);
      }
    });
  }

  public void modifyTitle(String title, Long id) {
    BookRepository.getBookRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setTitle(title);
      }
    });
  }

  public void modifyFavourite(boolean favourite, Long id) {
    BookRepository.getBookRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setFavourite(favourite);
      }
    });
  }

  public boolean checkIfBookExists(Long id) {
    return BookRepository.getBookRepository().stream().anyMatch(book -> book.getId().equals(id));
  }
}
