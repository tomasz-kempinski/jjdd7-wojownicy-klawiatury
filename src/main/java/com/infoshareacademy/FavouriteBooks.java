package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FavouriteBooks {

  ScreenCleaner screenCleaner = new ScreenCleaner();

  public void favoriteBooksMenu() {
    BookService bookService = new BookService();
    Scanner scanner = new Scanner(System.in);
    System.out.println("1- Wyświetlenie ulubionych książek");
    System.out.println("2- Dodanie ulubionej książki");
    System.out.println("3- Usunięcie ulubionej książki");
    System.out.println("9- Powrót do menu");

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
          break;
        case 3:
          screenCleaner.cleanScreen();
          favouriteBookRemove(-1);
          break;
        case 9:
          screenCleaner.cleanScreen();
          Menu menu = new Menu();
          menu.menu();
          break;
        default:
          screenCleaner.cleanScreen();
          favoriteBooksMenu();
          break;

      }
    }
  }

  private void favouriteBooksList() {

  }

  public void favouriteBooksAdd(long id) {
    Scanner scanner = new Scanner(System.in);
    if (id == -1){
      System.out.println(" Podaj id książki, którą chcesz dodać");
    }
  }

  private void favouriteBookRemove(long id) {
    if (id == -1){
      System.out.println(" Podaj id książki, którą chcesz usunąć");
    }

  }
}
