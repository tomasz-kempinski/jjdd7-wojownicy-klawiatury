package com.infoshareacademy.menu;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookList;
import com.infoshareacademy.BookService;
import com.infoshareacademy.ScreenCleaner;
import com.infoshareacademy.SingleBookView;
import com.infoshareacademy.repository.BookRepository;
import java.util.List;
import java.util.Scanner;

public class BookManagementMenu {

  private ScreenCleaner screenCleaner = new ScreenCleaner();
  private BookService bookService = new BookService();

  public void choseManagementOption() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" Co chcesz zrobić?");
    System.out.println(" 1- Dodaj książke.");
    System.out.println(" 2- Edytuj książke.");
    System.out.println(" 3- Usuń książke.");
    System.out.println(" 9- Powrót.");
    if (scanner.hasNextInt()) {
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          screenCleaner.cleanScreen();
          break;
        case 2:
          screenCleaner.cleanScreen();
          break;
        case 3:
          screenCleaner.cleanScreen();
          break;
        case 9:
          screenCleaner.cleanScreen();
          break;
      }
    }
  }

  private void addBookMenu() {
    boolean audio = false;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj tytuł książki:");
    String title = scanner.nextLine();
    screenCleaner.cleanScreen();
    System.out.println("Podaj autora książki:");
    String author = scanner.nextLine();
    screenCleaner.cleanScreen();
    System.out.println("Podaj gatunek książki:");
    String genre = scanner.nextLine();
    screenCleaner.cleanScreen();
    System.out.println("Podaj rodzaj literacki książki");
    String kind = scanner.nextLine();
    screenCleaner.cleanScreen();
    System.out.println("Czy książka ma wersję audio Y/N:");
    String audioSting = scanner.nextLine();
    if (audioSting.equals("Y") || audioSting.equals("y")) {
      audio = true;
    } else if (audioSting.equals("N") || audioSting.equals("n")) {
      audio = false;
    } else {

    }
    bookService.addBook(kind, title, author, audio, genre);
    System.out.println("Dodano książkę " + title + " do biblioteki.");
  }

  private void deleteBookMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj id książki do usunięcia:");
    Long id = scanner.nextLong();
    bookService.deleteBook(id);
  }
}