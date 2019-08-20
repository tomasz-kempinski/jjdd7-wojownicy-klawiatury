package com.infoshareacademy;

import java.util.Comparator;
import java.util.List;

public class BookSorter {

  private Config config = new Config();

  public void sortByAuthor(List<Book> listOfBooks) {
    config.loadConfig("sortByAuthor");
    String property = config.getProperty();
    if (property.equals("ASC")) {
      listOfBooks.sort(Comparator.comparing(Book::getAuthor));
    } else if (property.equals("DSC")) {
      listOfBooks.sort(Comparator.comparing(Book::getAuthor).reversed());
    }
  }

  public void sortByTitle(List<Book> listOfBooks) {
    config.loadConfig("sortByTitle");
    String property = config.getProperty();
    if (property.equals("ASC")) {
      listOfBooks.sort(Comparator.comparing(Book::getTitle));
    } else if (property.equals("DSC")) {
      listOfBooks.sort(Comparator.comparing(Book::getTitle).reversed());
    }
  }
}
