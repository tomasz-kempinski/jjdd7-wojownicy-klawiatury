package com.infoshareacademy;

import static com.infoshareacademy.Parser.getBooks;

import java.util.Comparator;
import java.util.List;

public class BookSorter {

  private Config config = new Config();
  private List<Book> books = getBooks();

  public void sortByAuthor() {
    config.loadConfig("sortByAuthor");
    String property = config.getProperty();
    if (property.equals("ASC")) {
      books.sort(Comparator.comparing(Book::getAuthor));
    } else if (property.equals("DSC")) {
      books.sort(Comparator.comparing(Book::getAuthor).reversed());
    }
  }

  public void sortByTitle() {
    config.loadConfig("sortByTitle");
    String property = config.getProperty();
    if (property.equals("ASC")) {
      books.sort(Comparator.comparing(Book::getTitle));
    } else if (property.equals("DSC")) {
      books.sort(Comparator.comparing(Book::getTitle).reversed());
    }
  }
}
