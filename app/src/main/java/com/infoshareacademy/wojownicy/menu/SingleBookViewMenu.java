package com.infoshareacademy.wojownicy.menu;


import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookJsonClassRepository;

import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import com.infoshareacademy.wojownicy.clas.SingleBookView;
import com.infoshareacademy.wojownicy.repository.BookList;
import com.infoshareacademy.wojownicy.service.BookSearchHandler;
import com.infoshareacademy.wojownicy.service.FavouriteBooks;
import com.infoshareacademy.wojownicy.service.ScreenCleaner;
import java.util.List;
import java.util.Scanner;

public class SingleBookViewMenu {

  private ScreenCleaner screenCleaner = new ScreenCleaner();
  private BookList bookList = new BookList();
  private SingleBookView singleBookView = new SingleBookView();
  private List<BookJsonClass> bookJsonClasses = getBookJsonClassRepository();

  public void selectBook() {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    int choice;
    System.out.println(" \nTwoja pozycja: Przeglądanie zbiorów/Widok pojedynczej książki");
    System.out.println(
        "\n########################### Widok pojedynczej książki ###########################\n");
    long id = -1;
    System.out.println(" Podaj ID książki która chcesz wyświetlić");
    if (scanner.hasNextInt()) {
      long userId = scanner.nextInt();
      for (BookJsonClass bookJsonClass : bookJsonClasses) {
        if (userId == bookJsonClass.getId()) {
          id = userId;
          break;
        }
      }
      if (id != -1) {
        screenCleaner.cleanScreen();
        singleBookView.singleBookView(id);
        System.out.println(" 1- Wyświetlenie innej książki    2- Powrót do Menu");
        System.out.println(" 3- Lista książek                 4- Wyszukiwanie książek");
        System.out.println(" 5- Dodaj książkę do ulubionych ");
        if (scanner.hasNextInt()) {
          choice = scanner.nextInt();
          switch (choice) {
            case 1:
              screenCleaner.cleanScreen();
              selectBook();
              break;
            case 2:
              screenCleaner.cleanScreen();
              menu.menu();
              break;
            case 3:
              screenCleaner.cleanScreen();
              System.out.println("\nTwoja pozycja: Przeglądanie zbiorów/Lista książek");
              System.out
                  .println("\n########################### Lista książek ###########################\n");
              bookList.listBooks();
              break;
            case 4:
              screenCleaner.cleanScreen();
              System.out.println("\nTwoja pozycja: Przeglądanie zbiorów/Wyszukiwanie Książek");
              System.out.println(
                  "\n######################### Wyszukiwanie książek #########################\n");
              BookSearchHandler bookSearchHandler = new BookSearchHandler();
              bookSearchHandler.listFoundBooks();
              break;
            case 5:
              screenCleaner.cleanScreen();
              System.out.println("\nTwoja pozycja: Ulubione Książki");
              System.out.println(
                  "\n########################### Ulubione Książki ###########################\n");
              FavouriteBooks favouriteBooks = new FavouriteBooks();
              favouriteBooks.favouriteBooksAdd(id);
              menu.menu();
              break;
            default:
              screenCleaner.cleanScreen();
              System.out.println(" Podaj prawidłową wartość!");
              menu.menu();
              break;
          }
        } else {
          screenCleaner.cleanScreen();
          System.out.println(" Zła wartość- powrót do Menu ");
          menu.menu();
        }
      } else {
        screenCleaner.cleanScreen();
        System.out.println(" \nTwoja pozycja: Przeglądanie zbiorów/Widok pojedynczej książki");
        System.out.println(
            "\n########################### Widok pojedynczej książki ###########################\n");
        System.out.println(" Podaj liczbę odpowiadającą ID książki!");
        System.out.println(" 1- Wyświetl listę książek 2- Wyszukaj książkę");
        System.out.println(" 3- Wpisz numer książki ponownie ");
        if (scanner.hasNextInt()) {
          choice = scanner.nextInt();
          switch (choice) {
            case 1:
              screenCleaner.cleanScreen();
              bookList.listBooks();
              break;
            case 2:
              screenCleaner.cleanScreen();
              BookSearchHandler bookSearchHandler = new BookSearchHandler();
              System.out.println(" \nTwoja pozycja: Przeglądanie zbiorów/Wyszukiwanie książek");
              System.out.println(
                  "\n########################### Wyszukiwanie książek ###########################\n");
              bookSearchHandler.listFoundBooks();
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

}


