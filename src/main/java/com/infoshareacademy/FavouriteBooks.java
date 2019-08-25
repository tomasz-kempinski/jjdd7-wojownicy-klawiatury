package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import java.util.List;
import java.util.Scanner;

public class FavouriteBooks {

  private ScreenCleaner screenCleaner = new ScreenCleaner();
  private Menu menu = new Menu();
  private List<Book> books = BookRepository.getBookRepository();

  public void favoriteBooksMenu() {

    Scanner scanner = new Scanner(System.in);
    System.out.println(" 1- Lista ulubionych książek");
    System.out.println(" 2- Dodaj ulubiona ksiązkę");
    System.out.println(" 3- Usuń ulubioną książkę");
    System.out.println(" 9- Powrót do menu");

    if (scanner.hasNextInt()) {
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          screenCleaner.cleanScreen();
          favouriteBooksList();
          break;
        case 2:
          screenCleaner.cleanScreen();
          favouriteBooksAdd(-1);
          menu.menu();
          break;
        case 3:
          screenCleaner.cleanScreen();
          favouriteBookRemove(-1);
          menu.menu();
          break;
        case 9:
          screenCleaner.cleanScreen();
          menu.menu();
          break;
        default:
          screenCleaner.cleanScreen();
          favoriteBooksMenu();
          break;
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj prawidlową wartość!");
      favoriteBooksMenu();
    }
  }

  private void favouriteBooksList() {
    Scanner scanner = new Scanner(System.in);
    List<Book> books = BookRepository.getBookRepository();
    for (Book book : books) {
      if (book.getFavourite()) {
        System.out.println(book.getAuthor() + " " + book.getTitle() + "ID: " + book.getId());
      }
    }
    System.out.println(" 1- Usuń książkę z ulubionych  2- powrót do Menu");
    if (scanner.hasNextInt()) {
      int choice = scanner.nextInt();
      if (choice == 1) {
        System.out.println(" Podaj ID książki, którą chcesz usunąć ");
        if (scanner.hasNextLong()) {
          long id = scanner.nextLong();
          favouriteBookRemove(id);
          screenCleaner.cleanScreen();
          System.out.println(" Książka usunięta prawidłowo ");
          System.out.println(" 1- Powrót do Menu  2- Lista ulubionych książek ");
          if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            if (choice == 2) {
              screenCleaner.cleanScreen();
              favouriteBooksList();
            } else {
              screenCleaner.cleanScreen();
            }
            menu.menu();
          }
        } else {
          screenCleaner.cleanScreen();
          menu.menu();
        }
      } else {
        screenCleaner.cleanScreen();
        menu.menu();
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj właściwą wartość!!");
      favoriteBooksMenu();
    }
  }

  public void favouriteBooksAdd(long id) {
    Scanner scanner = new Scanner(System.in);
    BookService bookService = new BookService();
    int numberOfFavouriteBooks = 0;
    if (id == -1) {
      System.out.println(" Podaj id książki, którą chcesz dodać");
      if (scanner.hasNextInt()) {
        id = scanner.nextInt();
      } else {
        screenCleaner.cleanScreen();
        System.out.println(" Podaj właściwą wartość ID!! ");
        favouriteBooksAdd(-1);
      }
    }
    for (Book book : books) {
      if (book.getFavourite()) {
        numberOfFavouriteBooks++;
      }
    }
    if (numberOfFavouriteBooks >= 3) {
      screenCleaner.cleanScreen();
      System.out.println(" Możesz mieć maksymalnie 3 ulubione ksiązki");
      System.out.println(" Usuń ulubioną książkę, a następnie spróbuj dodac ponownie");
      favouriteBooksList();
    } else {
      bookService.modifyFavourite(true, id);
    }
  }


  private void favouriteBookRemove(long id) {
    Scanner scanner = new Scanner(System.in);
    BookService bookService = new BookService();
    if (id == -1) {
      System.out.println(" Podaj id książki, którą chcesz usunąć");
      if (scanner.hasNextInt()) {
        id = scanner.nextInt();
      } else {
        screenCleaner.cleanScreen();
        System.out.println(" Podaj właściwą wartość ID!! ");
        favouriteBookRemove(-1);
      }
    }
    bookService.modifyFavourite(false, id);
  }
}
