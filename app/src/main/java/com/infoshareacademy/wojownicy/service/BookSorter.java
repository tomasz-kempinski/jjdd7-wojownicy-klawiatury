package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.Config;
import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import java.util.Comparator;
import java.util.List;

public class BookSorter {

  private Config config = new Config();

  public void sortByAuthor(List<BookJsonClass> listOfBookJsonClasses) {
    config.loadConfig("sortByAuthor");
    String property = config.getProperty();
    if (property.equals("ASC")) {
      listOfBookJsonClasses.sort(Comparator.comparing(BookJsonClass::getAuthor));
    } else if (property.equals("DESC")) {
      listOfBookJsonClasses.sort(Comparator.comparing(BookJsonClass::getAuthor).reversed());
    }
  }

  public void sortByTitle(List<BookJsonClass> listOfBookJsonClasses) {
    config.loadConfig("sortByTitle");
    String property = config.getProperty();
    if (property.equals("ASC")) {
      listOfBookJsonClasses.sort(Comparator.comparing(BookJsonClass::getTitle));
    } else if (property.equals("DESC")) {
      listOfBookJsonClasses.sort(Comparator.comparing(BookJsonClass::getTitle).reversed());
    }
  }

  public void sortByGenre(List<BookJsonClass> listOfBookJsonClasses) {
    config.loadConfig("sortByGenre");
    String property = config.getProperty();
    if (property.equals("ASC")) {
      listOfBookJsonClasses.sort(Comparator.comparing(BookJsonClass::getGenre));
    } else if (property.equals("DESC")) {
      listOfBookJsonClasses.sort(Comparator.comparing(BookJsonClass::getGenre).reversed());
    }
  }

  public void sortByKind(List<BookJsonClass> listOfBookJsonClasses) {
    config.loadConfig("sortByKind");
    String property = config.getProperty();
    if (property.equals("ASC")) {
      listOfBookJsonClasses.sort(Comparator.comparing(BookJsonClass::getKind));
    } else if (property.equals("DESC")) {
      listOfBookJsonClasses.sort(Comparator.comparing(BookJsonClass::getKind).reversed());
    }
  }
}
