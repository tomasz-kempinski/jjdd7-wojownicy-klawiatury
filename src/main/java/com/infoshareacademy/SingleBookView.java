package com.infoshareacademy;

import static com.infoshareacademy.Parser.getBooksTemplate;

import com.github.freva.asciitable.AsciiTable;
import java.util.List;

public class SingleBookView {

  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void singleBookView(int bookNumber) {
    List<Book> books = getBooksTemplate();
    String hasAudio;
    if (books.get(bookNumber).getHasAudio()) {
      hasAudio = "tak";
    } else {
      hasAudio = "nie";
    }
    screenCleaner.cleanScreen();
    String[][] data = {
        {"     Autor       ", books.get(bookNumber).getAuthor()},
        {"     Tytuł       ", books.get(bookNumber).getTitle()},
        {"Rodzaj Literacki ", books.get(bookNumber).getKind()},
        {"Gatunek Literacki", books.get(bookNumber).getGenre()},
        {"  Wersja audio   ", hasAudio}};
    System.out.println(AsciiTable.getTable(data));
  }
}

