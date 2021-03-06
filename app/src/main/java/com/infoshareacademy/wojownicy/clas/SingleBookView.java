package com.infoshareacademy.wojownicy.clas;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookRepository;

import com.github.freva.asciitable.AsciiTable;
import com.infoshareacademy.wojownicy.service.ScreenCleaner;
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
    System.out.println("Twoja pozycja: Przeglądanie zbiorów/Widok pojedynczej książki");
    System.out.println(
        "\n########################### Widok pojedynczej książki ###########################\n");
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


