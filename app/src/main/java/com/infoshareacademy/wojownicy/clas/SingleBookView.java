package com.infoshareacademy.wojownicy.clas;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookJsonClassRepository;

import com.github.freva.asciitable.AsciiTable;
import com.infoshareacademy.wojownicy.service.ScreenCleaner;
import java.util.List;

public class SingleBookView {

  private List<BookJsonClass> bookJsonClasses = getBookJsonClassRepository();
  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void singleBookView(long id) {
    int bookNumber = 0;
    for (int i = 0; i < bookJsonClasses.size(); i++) {
      if (bookJsonClasses.get(i).getId() == id) {
        bookNumber = i;
      }
    }
    String hasAudio;
    if (bookJsonClasses.get(bookNumber).getHasAudio()) {
      hasAudio = "tak";
    } else {
      hasAudio = "nie";
    }
    screenCleaner.cleanScreen();
    System.out.println("Twoja pozycja: Przeglądanie zbiorów/Widok pojedynczej książki");
    System.out.println(
        "\n########################### Widok pojedynczej książki ###########################\n");
    String[][] data = {
        {"       Id        ", bookJsonClasses.get(bookNumber).getId().toString()},
        {"     Autor       ", bookJsonClasses.get(bookNumber).getAuthor()},
        {"     Tytuł       ", bookJsonClasses.get(bookNumber).getTitle()},
        {"Rodzaj Literacki ", bookJsonClasses.get(bookNumber).getKind()},
        {"Gatunek Literacki", bookJsonClasses.get(bookNumber).getGenre()},
        {"  Wersja audio   ", hasAudio}};
    System.out.println(AsciiTable.getTable(data));
  }
}


