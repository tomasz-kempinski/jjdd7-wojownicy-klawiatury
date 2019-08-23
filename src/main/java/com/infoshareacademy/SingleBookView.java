package com.infoshareacademy;

import static com.infoshareacademy.BookRepository.getBookRepository;

import com.github.freva.asciitable.AsciiTable;

import java.util.List;

public class SingleBookView {

  private List<Book> books = getBookRepository();
  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void singleBookView(int bookNumber) {

    String hasAudio;
    if (books.get(bookNumber).getHasAudio()) {
      hasAudio = "tak";
    } else {
      hasAudio = "nie";
    }
    screenCleaner.cleanScreen();
    System.out.println("Twoja pozycja: Przeglądanie zbiorów/Widok pojedynczej książki");
    String[][] data = {
        {"     Autor       ", books.get(bookNumber).getAuthor()},
        {"     Tytuł       ", books.get(bookNumber).getTitle()},
        {"Rodzaj Literacki ", books.get(bookNumber).getKind()},
        {"Gatunek Literacki", books.get(bookNumber).getGenre()},
        {"  Wersja audio   ", hasAudio}};
    System.out.println(AsciiTable.getTable(data));
  }
}


