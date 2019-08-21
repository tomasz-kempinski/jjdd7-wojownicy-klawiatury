package com.infoshareacademy.menu;

import com.infoshareacademy.BookList;
import com.infoshareacademy.BookSearchHandler;
import com.infoshareacademy.ScreenCleaner;
import java.util.Scanner;

public class Menu {

  private ScreenCleaner screenCleaner = new ScreenCleaner();
  public void menu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" Co chcesz zrobić?");
    System.out.println(" 1- Przeglądanie zbiorów");
    System.out.println(" 2- Ulubione książki");
    System.out.println(" 9- Zakończ program");
    if (scanner.hasNextInt()) {
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          screenCleaner.cleanScreen();
          browsingCollections();
          break;
        case 2:
          screenCleaner.cleanScreen();
          System.out.println("\n########################### Ulubione Książki ###########################\n");
          break;
        case 9:
          break;
        default:
          menu();
          break;
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj właściwą wartość!");
      menu();
    }
  }

  private void browsingCollections() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" 1- Lista ksiażek");
    System.out.println(" 2- Wyszukiwanie ksiażek (wg autora, tytułu, wersji audio)");
    System.out.println(" 3- Przeglądanie pojedynczej pozycji");
    System.out.println(" 9- Powrót");
    if (scanner.hasNextInt()) {
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          screenCleaner.cleanScreen();
          BookList bookList = new BookList();
          System.out.println("\n########################### Lista książek ###########################\n");
          bookList.listBooks();
          screenCleaner.cleanScreen();
          break;
        case 2:
          screenCleaner.cleanScreen();
          System.out.println("\n######################### Wyszukiwanie książek #########################\n");
          BookSearchHandler bookSearchHandler = new BookSearchHandler();
          bookSearchHandler.listFoundBooks();
          screenCleaner.cleanScreen();
          decision();
          break;
        case 3:
          screenCleaner.cleanScreen();
          SingleBookViewMenu singleBookViewMenu = new SingleBookViewMenu();
          System.out.println("\n################### Przeglądanie pojedynczej pozycji ####################\n");
          singleBookViewMenu.selectBook();
          break;
        case 9:
          screenCleaner.cleanScreen();
          menu();
          break;
        default:
          screenCleaner.cleanScreen();
          System.out.println(" Podaj własciwa wartość!");
          browsingCollections();
          break;
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj własciwą wartość!");
      browsingCollections();
    }
  }

  private void decision() {
    Scanner scanner = new Scanner(System.in);
    int decision;
    System.out.println(" 1- Powrót do menu ");
    System.out.println(" 2- Wyjście ");
    if (scanner.hasNextInt()) {
      decision = scanner.nextInt();
      switch (decision) {
        case 1:
          screenCleaner.cleanScreen();
          menu();
          break;
        case 2:
          screenCleaner.cleanScreen();
          break;
        default:
          screenCleaner.cleanScreen();
          System.out.println(" Podaj właściwe dane!");
          decision();
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj właściwe dane!");
      decision();
    }
  }
}
