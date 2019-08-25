package com.infoshareacademy;

import static com.infoshareacademy.BookRepository.getBookRepository;

import com.github.freva.asciitable.AsciiTable;
import java.util.List;

public class SingleBookView {

  private List<Book> books = getBookRepository();
  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void singleBookView(long id) {
    int bookNumber = 0;
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getId() == id) {
        bookNumber = i;
      }
    }
    String hasAudio;
    if (books.get(bookNumber).getHasAudio()) {
      hasAudio = "tak";
    } else {
      hasAudio = "nie";
    }
    screenCleaner.cleanScreen();
    String[][] data = {
        {"       Id        ", books.get(bookNumber).getId().toString()},
        {"     Autor       ", books.get(bookNumber).getAuthor()},
        {"     Tytuł       ", books.get(bookNumber).getTitle()},
        {"Rodzaj Literacki ", books.get(bookNumber).getKind()},
        {"Gatunek Literacki", books.get(bookNumber).getGenre()},
        {"  Wersja audio   ", hasAudio}};
    System.out.println(AsciiTable.getTable(data));
  }
}


