package com.infoshareacademy;

import static com.infoshareacademy.Parser.getBooksTemplate;

import com.github.freva.asciitable.AsciiTable;

>>>>>>> develop
import java.util.List;

public class SingleBookView {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> develop

  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void singleBookView(int bookNumber) {
<<<<<<< HEAD
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
=======

  BookList bookList = new BookList();
  List<Book> books = getBooksTemplate();

  public void selectBook() {
    Scanner scanner = new Scanner(System.in);
=======
>>>>>>> develop
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
<<<<<<< HEAD
    System.out.println(" 1- Wyświetlenie innej książki    2- Powrót do Menu");
    System.out.println(" 3- Lista książek                 4- Wyszukiwanie książek");
    if (scanner.hasNextInt()) {
      choice = scanner.nextInt();
      switch (choice) {
        case 1:
          selectBook();
          break;
        case 2:
          Menu menu = new Menu();
          menu.menu();
          break;
        case 3:
          bookList.listBooks();
          break;
        case 4:
          System.out.println(" Wyszukiwanie książek\n");
          BookSearchHandler bookSearchHandler = new BookSearchHandler();
          bookSearchHandler.listFoundBooks();
          break;
        default:
          System.out.println("Podaj prawidłową wartość!");
          singleBookView(bookNumber);
      }
    }
>>>>>>> develop
=======
>>>>>>> develop
  }
}

