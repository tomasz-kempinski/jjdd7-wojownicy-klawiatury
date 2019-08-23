package com.infoshareacademy.menu;

import com.infoshareacademy.BookService;
import com.infoshareacademy.ScreenCleaner;
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
          addBookMenu();
          break;
        case 2:
          screenCleaner.cleanScreen();
          modifyBookMenu();
          break;
        case 3:
          screenCleaner.cleanScreen();
          deleteBookMenu();
          break;
        case 9:
          screenCleaner.cleanScreen();
          Menu menu = new Menu();
          menu.menu();
          break;
        default:
          screenCleaner.cleanScreen();
          System.out.println(" Podaj własciwa wartość!");
          choseManagementOption();
          break;
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj własciwa wartość!");
      choseManagementOption();
    }
  }

  private void addBookMenu() {
    boolean audio;
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
    audio = doesBookHasAudio();
    bookService.addBook(kind, title, author, audio, genre);
    choseManagementOption();
  }

  private boolean doesBookHasAudio() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" Czy książka ma wersje audio?");
    String audio = scanner.nextLine();
    boolean hasAudio = false;

    if (!audio.equalsIgnoreCase("T") && !audio.equalsIgnoreCase("N")) {
      System.out.println(" Podaj prawidłowe dane!");
      doesBookHasAudio();
    } else if (audio.equalsIgnoreCase("T")) {
      hasAudio = true;
    }
    return hasAudio;
  }

  private void deleteBookMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj id książki do usunięcia:");
    Long id = scanner.nextLong();
    bookService.deleteBook(id);
    choseManagementOption();
  }

  private void modifyBookMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj id książki do edycji");
    Long id = scanner.nextLong();
    System.out.println("Co chcesz edytowac?");
    System.out.println(" 1- Tytuł");
    System.out.println(" 2- Autor");
    System.out.println(" 3- Gatunek");
    System.out.println(" 4- Rodzaj literacki");
    System.out.println(" 5- Wersja audio");
    System.out.println(" 9- Powrót");
    if (scanner.hasNextInt()) {
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          screenCleaner.cleanScreen();
          System.out.println("Podaj nowy tytuł: ");
          String title = scanner.next();
          bookService.modifyTitle(title, id);
          modifyBookMenu();
          break;
        case 2:
          screenCleaner.cleanScreen();
          System.out.println("Podaj nowego autora: ");
          String author = scanner.next();
          bookService.modifyAuthor(author, id);
          modifyBookMenu();
          break;
        case 3:
          screenCleaner.cleanScreen();
          System.out.println("Podaj nowy gatunek: ");
          String genre = scanner.next();
          bookService.modifyGenre(genre, id);
          modifyBookMenu();
          break;
        case 4:
          screenCleaner.cleanScreen();
          System.out.println("Podaj nowy rodzaj literacki:");
          String kind = scanner.next();
          bookService.modifyKind(kind, id);
          modifyBookMenu();
          break;
        case 5:
          screenCleaner.cleanScreen();
          boolean audio = false;
          System.out.println("Czy książka ma wersję audio Y/N:");
          String audioString = scanner.next();
          if (audioString.equals("Y") || audioString.equals("y")) {
            audio = true;
          } else if (audioString.equals("N") || audioString.equals("n")) {
            audio = false;
          }
          bookService.modifyHasAudio(audio, id);
          modifyBookMenu();
          break;
        case 9:
          screenCleaner.cleanScreen();
          modifyBookMenu();
          break;
        default:
          screenCleaner.cleanScreen();
          System.out.println(" Podaj własciwa wartość!");
          modifyBookMenu();
          break;
      }
    }
  }
}