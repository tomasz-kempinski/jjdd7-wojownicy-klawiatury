package com.infoshareacademy.wojownicy.menu;

import com.infoshareacademy.wojownicy.service.BookService;
import com.infoshareacademy.wojownicy.service.ScreenCleaner;
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
          System.out.println("Twoja pozycja: Zarządzanie książkami/dodaj książkę");
          System.out.println(
              "\n######################### Dodaj książkę #########################\n");
          addBookMenu();
          break;
        case 2:
          screenCleaner.cleanScreen();
          System.out.println("Twoja pozycja: zarządzanie książkami/edycja książek");
          System.out.println(
              "\n######################### Edytuj książkę #########################\n");
          modifyBookMenu();
          break;
        case 3:
          System.out.println("Twoja pozycja: zarządzanie książkami/usuwanie książki");
          System.out.println(
              "\n######################### Usuń książkę #########################\n");
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
          System.out.println("Twoja pozycja: Zarządzanie książkami");
          System.out.println(
              "\n########################### Zarządzanie ksiażkami ###########################\n");
          System.out.println(" Podaj własciwa wartość!");
          choseManagementOption();
          break;
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println("Twoja pozycja: Zarządzanie książkami");
      System.out.println(
          "\n########################### Zarządzanie ksiażkami ###########################\n");
      System.out.println(" Podaj własciwa wartość!");
      choseManagementOption();
    }
  }

  private void addBookMenu() {
    boolean audio;
    Scanner scanner = new Scanner(System.in);
    System.out.println(" Podaj tytuł książki");
    String title = scanner.nextLine();
    while (title.length() == 0) {
      System.out.print("\n Podaj wartość");
      title = scanner.nextLine();
    }
    screenCleaner.cleanScreen();
    System.out.println(" Podaj autora książki");
    String author = scanner.nextLine();
    while (author.length() == 0) {
      System.out.print("\n Podaj wartość");
      author = scanner.nextLine();
    }
    screenCleaner.cleanScreen();
    System.out.println(" Podaj gatunek książki");
    String genre = scanner.nextLine();
    while (genre.length() == 0) {
      System.out.print("\n Podaj wartość");
      genre = scanner.nextLine();
    }
    screenCleaner.cleanScreen();
    System.out.println(" Podaj rodzaj literacki książki");
    String kind = scanner.nextLine();
    while (kind.length() == 0) {
      System.out.println("\n Podaj wartość");
      kind = scanner.nextLine();
    }
    screenCleaner.cleanScreen();
    audio = doesBookHasAudio();
    bookService.addBook(kind, title, author, audio, genre);
    choseManagementOption();
  }

  private boolean doesBookHasAudio() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" Czy książka ma wersje audio? (T/N)");
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
    System.out.println(" Podaj id książki do usunięcia");
    if (scanner.hasNextLong()) {
      Long id = scanner.nextLong();
      bookService.deleteBook(id);
      choseManagementOption();
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj własciwa wartość!");
      deleteBookMenu();
    }
  }


  private void modifyBookMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" Podaj id książki do edycji");
    if (scanner.hasNextLong()) {
      Long id = scanner.nextLong();
      if (bookService.checkIfBookExists(id)) {
        System.out.println(" Co chcesz edytowac?");
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
              System.out.println(" Podaj nowy tytuł");
              String title = scanner.next();
              bookService.modifyTitle(title, id);
              choseManagementOption();
              break;
            case 2:
              screenCleaner.cleanScreen();
              System.out.println(" Podaj nowego autora");
              String author = scanner.next();
              bookService.modifyAuthor(author, id);
              choseManagementOption();
              break;
            case 3:
              screenCleaner.cleanScreen();
              System.out.println(" Podaj nowy gatunek");
              String genre = scanner.next();
              bookService.modifyGenre(genre, id);
              choseManagementOption();
              break;
            case 4:
              screenCleaner.cleanScreen();
              System.out.println(" Podaj nowy rodzaj literacki");
              String kind = scanner.next();
              bookService.modifyKind(kind, id);
              choseManagementOption();
              break;
            case 5:
              screenCleaner.cleanScreen();
              boolean audio;
              audio = doesBookHasAudio();
              bookService.modifyHasAudio(audio, id);
              choseManagementOption();
              break;
            case 9:
              screenCleaner.cleanScreen();
              choseManagementOption();
              break;
            default:
              screenCleaner.cleanScreen();
              System.out.println(" Podaj własciwa wartość!");
              choseManagementOption();
              break;
          }
        }
      } else {
        System.out.println("Nie znaleziono takiej ksiazki");
        modifyBookMenu();
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj własciwa wartość!");
      modifyBookMenu();
    }
  }
}