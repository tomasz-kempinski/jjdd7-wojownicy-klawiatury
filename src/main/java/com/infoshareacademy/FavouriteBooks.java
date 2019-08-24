package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;

import java.util.Scanner;

public class FavouriteBooks {

  private ScreenCleaner screenCleaner = new ScreenCleaner();
  private Menu menu = new Menu();

  public void favoriteBooksMenu() {

    Scanner scanner = new Scanner(System.in);
    System.out.println("####FUNKCJA W CZASIE IMPLEMENTACJI###");
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
      if (scanner.hasNextInt()){
        id = scanner.nextInt();
      } else {
        screenCleaner.cleanScreen();
        System.out.println(" Podaj właściwą wartość ID!! ");
        favouriteBookRemove(-1);
      }
    }
  }

  public void favouriteBookRemove(long id) {
    Scanner scanner = new Scanner(System.in);
    if (id == -1){
      System.out.println(" Podaj id książki, którą chcesz usunąć");
      if (scanner.hasNextInt()){
        id = scanner.nextInt();
      } else {
        screenCleaner.cleanScreen();
        System.out.println(" Podaj właściwą wartość ID!! ");
        favouriteBookRemove(-1);
      }
    }
  }
}
