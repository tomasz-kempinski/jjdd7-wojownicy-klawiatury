package com.infoshareacademy.menu;


import com.infoshareacademy.Book;
import com.infoshareacademy.BookList;
import com.infoshareacademy.BookSearchHandler;
import com.infoshareacademy.ScreenCleaner;
import com.infoshareacademy.SingleBookView;
import com.infoshareacademy.repository.BookRepository;
import java.util.List;
import java.util.Scanner;

public class SingleBookViewMenu {

  private ScreenCleaner screenCleaner = new ScreenCleaner();
  private BookList bookList = new BookList();
  private SingleBookView singleBookView = new SingleBookView();

  public void selectBook() {
    Scanner scanner = new Scanner(System.in);
    List<Book> books = BookRepository.getBooks();
    int choice;
    int bookNumber;
    System.out.println(" Podaj numer książki, którą chcesz zobaczyć");
    if (scanner.hasNextInt()) {
      bookNumber = scanner.nextInt();
      if (bookNumber <= books.size()) {
        screenCleaner.cleanScreen();
        singleBookView.singleBookView(bookNumber);
        afterSingleBookView();
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
              System.out.println(" Wyszukiwanie książek");
              break;
            default:
              screenCleaner.cleanScreen();
              System.out.println(" Podaj prawidlowe dane! ");
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

  private void afterSingleBookView() {
    Scanner scanner = new Scanner(System.in);
    int choice;
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
          BookSearchHandler bookSearchHandler = new BookSearchHandler();
          bookSearchHandler.listFoundBooks();
          break;
        default:
          screenCleaner.cleanScreen();
          System.out.println("Podaj prawidłową wartość!");
          afterSingleBookView();
      }
    }
  }
}
