package com.infoshareacademy;

import static com.infoshareacademy.Parser.getBooks;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.menu.SingleBookViewMenu;
import java.util.List;
import java.util.Scanner;

public class BookList {

  public void listBooks() {
    List<Book> books = getBooks();
    Scanner scanner = new Scanner(System.in);
    BooksPrinter.printListOfBooks(books);
    String nextPageCheck;
    System.out
        .println(
            " Enter- Zakończ program || W- Wyświetl szczegóły książki || P- Powrót do menu ");
    nextPageCheck = scanner.nextLine();

    if (nextPageCheck.equalsIgnoreCase("W")) {
      SingleBookViewMenu singleBookViewMenu = new SingleBookViewMenu();
      singleBookViewMenu.selectBook();
    }
    if (nextPageCheck.equalsIgnoreCase("P")){
      Menu menu = new Menu();
      menu.menu();
    }
  }
}
