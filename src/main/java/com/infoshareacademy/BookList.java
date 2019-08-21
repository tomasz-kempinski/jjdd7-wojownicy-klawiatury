package com.infoshareacademy;




import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.menu.SingleBookViewMenu;
import java.util.List;
import java.util.Scanner;
import com.infoshareacademy.repository.BookRepository;


public class BookList {


  public void listBooks() {
    BooksPrinter.printListOfBooks(BookRepository.getBooks());
    Scanner scanner = new Scanner(System.in);
    BooksPrinter.printListOfBooks(BookRepository.getBooks());
    String nextPageCheck;
    System.out
        .println(
            " \n Enter -> Zakończ program || W -> Wyświetl szczegóły książki || P -> Powrót do menu ");
    nextPageCheck = scanner.nextLine();

    if (nextPageCheck.equalsIgnoreCase("W")) {
      SingleBookViewMenu singleBookViewMenu = new SingleBookViewMenu();
      singleBookViewMenu.selectBook();
    }
    if (nextPageCheck.equalsIgnoreCase("P")) {
      Menu menu = new Menu();
      menu.menu();
    }

  }
}
