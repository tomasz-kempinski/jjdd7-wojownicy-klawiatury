package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import com.infoshareacademy.wojownicy.repository.BookRepository;

public class BookService {

  private static Long maxId = 0L;

  public void setIdForBooks() {
    for (BookJsonClass bookJsonClass : BookRepository.getBookJsonClassRepository()) {
      if (bookJsonClass.getId() == null) {
        bookJsonClass.setId(getCurrentId());
        increaseCurrentId();
      }
    }
  }

  public void setFavouriteForBooks() {
    for (BookJsonClass bookJsonClass : BookRepository.getBookJsonClassRepository()) {
      if (bookJsonClass.getFavourite() == null) {
        bookJsonClass.setFavourite(false);
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
    BookRepository.getBookJsonClassRepository().forEach(b -> {
      if (b.getId() > getCurrentId()) {
        setCurrentId(b.getId());
      }
    });
  }

  public void addBook(String kind, String title, String author, Boolean hasAudio,
      String genre) {
    BookJsonClass bookJsonClass = new BookJsonClass(kind, title, author, hasAudio, genre);
    BookRepository.getBookJsonClassRepository().add(bookJsonClass);
    setIdForBooks();
    setFavouriteForBooks();
    System.out.println("Książka została dodana");
  }

  public void deleteBook(Long id) {
    if (checkIfBookExists(id)) {
      BookRepository.getBookJsonClassRepository().removeIf(b -> b.getId().equals(id));
      System.out.println("Książka została usunięta");
    } else {
      System.out.println(" Nie znaleziono takiej książki");
    }
  }

  public void modifyAuthor(String author, Long id) {
    BookRepository.getBookJsonClassRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setAuthor(author);
      }
    });
  }

  public void modifyHasAudio(boolean hasAudio, Long id) {
    BookRepository.getBookJsonClassRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setHasAudio(hasAudio);
      }
    });
  }

  public void modifyGenre(String genre, Long id) {
    BookRepository.getBookJsonClassRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setGenre(genre);
      }
    });
  }

  public void modifyKind(String kind, Long id) {
    BookRepository.getBookJsonClassRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setKind(kind);
      }
    });
  }

  public void modifyTitle(String title, Long id) {
    BookRepository.getBookJsonClassRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setTitle(title);
      }
    });
  }

  public void modifyFavourite(boolean favourite, Long id) {
    BookRepository.getBookJsonClassRepository().forEach(b -> {
      if (b.getId().equals(id)) {
        b.setFavourite(favourite);
      }
    });
  }

  public boolean checkIfBookExists(Long id) {
    if (BookRepository.getBookJsonClassRepository().stream().anyMatch(book -> book.getId().equals(id))) {
      return true;
    }
    return false;
  }
}