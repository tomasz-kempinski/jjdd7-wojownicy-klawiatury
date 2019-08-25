package com.infoshareacademy.menu;

import com.infoshareacademy.BookFilterService;
import com.infoshareacademy.BookList;
import com.infoshareacademy.BookSearchHandler;
import com.infoshareacademy.FavouriteBooks;
import com.infoshareacademy.ScreenCleaner;
import java.util.Scanner;

public class Menu {

  private ScreenCleaner screenCleaner = new ScreenCleaner();

  public void menu(){
    Scanner scanner = new Scanner(System.in);
    System.out.println(
        "\n########################### Menu ###########################\n");
    System.out.println(" Co chcesz zrobić?");
    System.out.println(" 1- Przeglądanie zbiorów");
    System.out.println(" 2- Ulubione książki");
    System.out.println(" 3- Zarządzanie książkami");
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
          FavouriteBooks favouriteBooks = new FavouriteBooks();
          favouriteBooks.favoriteBooksMenu();
          screenCleaner.cleanScreen();
          break;
        case 3:
          screenCleaner.cleanScreen();
          System.out.println("Twoja pozycja: Zarządzanie książkami");
          System.out.println(
              "\n########################### Zarządzanie ksiażkami ###########################\n");
          BookManagementMenu bookManagementMenu = new BookManagementMenu();
          bookManagementMenu.choseManagementOption();
          break;
        case 9:
          screenCleaner.cleanScreen();
          break;
        default:
          screenCleaner.cleanScreen();
          System.out.println(" Podaj prawidłowe dane !");
          menu();
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj prawidłowe dane !");
      menu();
    }
  }

  public void browsingCollections() {
    System.out.println(" Twoja pozycja: Przeglądanie zbiorów");
    System.out.println(
        "\n########################### Przeglądanie zbiorów ###########################\n");
    Scanner scanner = new Scanner(System.in);
    System.out.println(" 1- Lista ksiażek");
    System.out.println(" 2- Wyszukiwanie ksiażek (wg autora, tytułu, wersji audio)");
    System.out.println(" 3- Przeglądanie pojedynczej pozycji");
    System.out.println(" 4- Wyświetlanie książek według kategorii");
    System.out.println(" 9- Powrót");
    if (scanner.hasNextInt()) {
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          screenCleaner.cleanScreen();
          BookList bookList = new BookList();
          System.out.println("Twoja pozycja: Przeglądanie zbiorów/Lista książek");
          System.out
              .println("\n########################### Lista książek ###########################\n");
          bookList.listBooks();
          screenCleaner.cleanScreen();
          break;
        case 2:
          screenCleaner.cleanScreen();
          System.out.println("Twoja pozycja: Przeglądanie zbiorów/Wyszukiwanie Książek");
          System.out.println(
              "\n######################### Wyszukiwanie książek #########################\n");
          BookSearchHandler bookSearchHandler = new BookSearchHandler();
          bookSearchHandler.listFoundBooks();
          break;
        case 3:
          screenCleaner.cleanScreen();
          SingleBookViewMenu singleBookViewMenu = new SingleBookViewMenu();
          singleBookViewMenu.selectBook();
          break;
        case 4:
          screenCleaner.cleanScreen();
          System.out.println("Twoja pozycja: Przeglądanie zbiorów/Wyświetlanie według kategorii");
          System.out.println(
              "\n##################### Wyświetlanie książek według kategorii #####################\n");
          BookFilterService bookFilterService = new BookFilterService();
          bookFilterService.filterByCategory();
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
}
