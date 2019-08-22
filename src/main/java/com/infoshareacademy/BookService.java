package com.infoshareacademy;

import com.infoshareacademy.repository.BookRepository;

public class BookService {

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
