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

  public void checkForMaxId(){
    BookRepository.getBooks().forEach(b -> {
      if (b.getId() > BookRepository.getCurrentId()){
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
    BookRepository.getBooks().removeIf(b -> b.getId() == id);
  }

  public void modifyAuthor(String author, int id) {
    BookRepository.getBooks().get(id).setAuthor(author);
  }

  public void modifyHasAudio(boolean hasAudio, int id) {
    BookRepository.getBooks().get(id).setHasAudio(hasAudio);
  }

  public void modifyGenre(String genre, int id) {
    BookRepository.getBooks().get(id).setGenre(genre);
  }

  public void modifyKind(String kind, int id) {
    BookRepository.getBooks().get(id).setKind(kind);
  }

  public void modifyTitle(String title, int id) {
    BookRepository.getBooks().get(id).setTitle(title);
  }
}
