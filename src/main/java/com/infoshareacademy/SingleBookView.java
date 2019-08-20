package com.infoshareacademy;

import static com.infoshareacademy.Parser.getBooks;

import com.github.freva.asciitable.AsciiTable;
import java.util.List;
import java.util.Scanner;

public class SingleBookView {

  private BookList bookList = new BookList();
  private List<Book> books = getBooks();
  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void selectBook() {
    Scanner scanner = new Scanner(System.in);
    List<Book> books = getBooks();
    int choice;
    int bookNumber;
    System.out.println(" Podaj numer książki, którą chcesz zobaczyć");
    if (scanner.hasNextInt()) {
      bookNumber = scanner.nextInt();
      if (bookNumber <= books.size()) {
        screenCleaner.cleanScreen();
        singleBookView(bookNumber);
      } else {
        screenCleaner.cleanScreen();
        System.out.println(" Podaj liczbę odpowiadającą książce!");
        System.out.println(" 1- Wyświetl listę książek 2- Wyszukaj książkę");
        System.out.println(" 3- Wpisz numer książki ponownie");
        if (scanner.hasNextInt()) {
          choice = scanner.nextInt();
          switch (choice) {
            case 1:
              screenCleaner.cleanScreen();
              bookList.listBooks();
              break;
            case 2:
              screenCleaner.cleanScreen();
              System.out.println("Wyszukiwanie książek");
              break;
            default:
              selectBook();
          }
        }

      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj liczbę!");
      selectBook();
    }
  }

  private void singleBookView(int bookNumber) {
    Scanner scanner = new Scanner(System.in);
    String hasAudio;
    int choice;
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
    System.out.println(" 1- Wyświetlenie innej książki    2- Powrót do Menu");
    System.out.println(" 3- Lista książek                 4- Wyszukiwanie książek");
    if (scanner.hasNextInt()) {
      choice = scanner.nextInt();
      switch (choice) {
        case 1:
          screenCleaner.cleanScreen();
          selectBook();
          break;
        case 2:
          screenCleaner.cleanScreen();
          Menu menu = new Menu();
          menu.menu();
          break;
        case 3:
          screenCleaner.cleanScreen();
          bookList.listBooks();
          break;
        case 4:
          screenCleaner.cleanScreen();
          break;
        default:
          System.out.println("Podaj prawidłową wartość!");
          singleBookView(bookNumber);
      }
    }
  }
}

