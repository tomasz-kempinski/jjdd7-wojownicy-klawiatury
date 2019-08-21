package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.menu.SingleBookViewMenu;
import java.util.List;
import java.util.Scanner;

class BooksPrinter {

  static void printListOfBooks(List<Book> listOfBooks) {
    Scanner scanner = new Scanner(System.in);
    BookSorter bookSorter = new BookSorter();
    bookSorter.sortByTitle(listOfBooks);
    ScreenCleaner screenCleaner = new ScreenCleaner();
    int lines = 20;
    int bookCounter = 0;
    int currentLine;
    int currentPage = 0;
    String nextPageCheck;
    if (listOfBooks.isEmpty()) {
      System.out.println(" \nNie znaleziono żadnych książek.");
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
              bookCounter + 1 + ". \"" + listOfBooks.get(bookCounter).getTitle() + "\" - "
                  + listOfBooks
                  .get(bookCounter).getAuthor());
          bookCounter++;
        } while (currentLine < lines && currentPage < listOfBooks.size());
      } while (currentPage < listOfBooks.size());
    }
  }
}

