package com.infoshareacademy;

import static com.infoshareacademy.BookRepository.getBookRepository;

public class BookService {

  public void modifyAuthor(String author, int id) {
    getBookRepository().get(id).setAuthor(author);
  }

  public void modifyHasAudio(boolean hasAudio, int id) {
    getBookRepository().get(id).setHasAudio(hasAudio);
  }

  public void modifyGenre(String genre, int id) {
    getBookRepository().get(id).setGenre(genre);
  }

  public void modifyKind(String kind, int id) {
    getBookRepository().get(id).setKind(kind);
  }

  public void modifyTitle(String title, int id) {
    getBookRepository().get(id).setTitle(title);
  }
}
