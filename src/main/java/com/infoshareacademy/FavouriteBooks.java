package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;

import java.util.Scanner;

public class FavouriteBooks {

  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void favoriteBooksMenu() {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Twoja pozycja: Menu/Ulubione Książki");
    System.out.println("####FUNKCJA W CZASIE IMPLEMENTACJI###");
    System.out.println("9- Powrót do menu");

    if (scanner.hasNextInt()) {
      int choice = scanner.nextInt();
      if (choice == 9) {
        screenCleaner.cleanScreen();
        Menu menu = new Menu();
        menu.menu();
      } else {
        screenCleaner.cleanScreen();
        System.out.println(" Podaj właściwą wartość");
        favoriteBooksMenu();
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj właściwą wartość");
    }
  }
}
