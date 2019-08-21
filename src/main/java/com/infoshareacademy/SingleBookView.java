package com.infoshareacademy;

import static com.infoshareacademy.Parser.getBooks;


import com.github.freva.asciitable.AsciiTable;
import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.menu.SingleBookViewMenu;
import java.util.List;
import java.util.Scanner;

public class SingleBookView {
  private BookList bookList = new BookList();
  private List<Book> books = getBooks();
  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void singleBookView(int bookNumber) {
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

