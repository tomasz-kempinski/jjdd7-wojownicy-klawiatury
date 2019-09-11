package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import com.infoshareacademy.wojownicy.menu.Menu;
import com.infoshareacademy.wojownicy.menu.SingleBookViewMenu;
import java.util.List;
import java.util.Scanner;

public class BooksPrinter {

  public static void printListOfBooks(List<BookJsonClass> listOfBookJsonClasses) {
    Scanner scanner = new Scanner(System.in);
    BookSorter bookSorter = new BookSorter();
    bookSorter.sortByTitle(listOfBookJsonClasses);
    ScreenCleaner screenCleaner = new ScreenCleaner();
    int lines = 20;
    int bookCounter = 0;
    int currentLine;
    int currentPage = 0;
    String nextPageCheck;
    if (listOfBookJsonClasses.isEmpty()) {
      System.out.println(" \nNie znaleziono żadnych książek.");
      BookSearchHandler bookSearchHandler = new BookSearchHandler();
      bookSearchHandler.listFoundBooks();
    } else {
      do {
        if (currentPage > 0) {
          System.out.println(
              " \nEnter -> Kontynuuj wyświetlanie || Z -> Zakończ wyświetlanie || W -> Wyświetl szczegóły książki ");
          nextPageCheck = scanner.nextLine();
          if (nextPageCheck.equalsIgnoreCase("Z")) {
            Menu menu = new Menu();
            screenCleaner.cleanScreen();
            menu.menu();
            break;
          }
          if (nextPageCheck.equalsIgnoreCase("W")) {
            screenCleaner.cleanScreen();
            new SingleBookViewMenu().selectBook();
            break;
          }
        }
        currentLine = 0;
        do {
          currentPage++;
          currentLine++;
          System.out.println(
              bookCounter + 1 + ". \"" + listOfBookJsonClasses.get(bookCounter).getTitle() + "\" - "
                  + listOfBookJsonClasses
                  .get(bookCounter).getAuthor() + " ID: " + listOfBookJsonClasses.get(bookCounter).getId());
          bookCounter++;
        } while (currentLine < lines && currentPage < listOfBookJsonClasses.size());
      } while (currentPage < listOfBookJsonClasses.size());
      if (bookCounter == listOfBookJsonClasses.size()) {
        System.out.println(
            "\n ############################## KONIEC LISTY ##############################");
        System.out.println(
            " \nEnter -> Zakończ program || P -> Powrót do menu || W -> Wyświetl szczegóły książki ");
        nextPageCheck = scanner.nextLine();
        if (nextPageCheck.equalsIgnoreCase("p")) {
          Menu menu = new Menu();
          screenCleaner.cleanScreen();
          menu.menu();
        } else if (nextPageCheck.equalsIgnoreCase("W")) {
          screenCleaner.cleanScreen();
          new SingleBookViewMenu().selectBook();
        }
      }
    }

  }
}