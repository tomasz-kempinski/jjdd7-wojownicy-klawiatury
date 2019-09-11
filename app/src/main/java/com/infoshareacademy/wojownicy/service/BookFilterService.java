package com.infoshareacademy.wojownicy.service;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookJsonClassRepository;

import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import com.infoshareacademy.wojownicy.menu.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BookFilterService {

  private Scanner scanner = new Scanner(System.in);
  private BookSorter bookSorter = new BookSorter();
  private ScreenCleaner screenCleaner = new ScreenCleaner();
  private Menu menu = new Menu();

  private List<BookJsonClass> bookJsonClasses;


  public BookFilterService() {
    this.bookJsonClasses = getBookJsonClassRepository();
  }

  public void filterByCategory() {
    screenCleaner.cleanScreen();
    System.out.println("Twoja pozycja: Przeglądanie zbiorów/Wyświetlanie według kategorii");
    System.out.println(
        "\n##################### Wyświetlanie książek według kategorii #####################\n");
    System.out.println(" 1- Autor");
    System.out.println(" 2- Gatunek");
    System.out.println(" 3- Rodzaj literacki");
    System.out.println(" 9- Powrót");
    String choice = scanner.nextLine();
    switch (choice) {
      case "1":
        listFoundBooksAuthor();
        break;
      case "2":
        listFoundBooksGenre();
        break;
      case "3":
        listFoundBooksKind();
        break;
      case "9":
        screenCleaner.cleanScreen();
        menu.browsingCollections();
        break;
      default:
        System.out.println("Zły wybór");
        filterByCategory();
        break;
    }
  }

  private void printList(List<BookJsonClass> printListBookJsonClass) {
    int lines = 20;
    int bookCounter = 0;
    int currentLine;
    int currentPage = 0;
    String nextPageCheck;
    if (printListBookJsonClass.isEmpty()) {
      System.out.println(" \nNie znaleziono żadnych książek.");
    } else {
      do {
        if (currentPage > 0) {
          System.out.println(
              " \nEnter -> Kontynuuj wyświetlanie || Z -> Zakończ wyświetlanie");
          nextPageCheck = scanner.nextLine();
          if (nextPageCheck.equalsIgnoreCase("Z")) {
            break;
          }
        }
        currentLine = 0;
        do {
          currentPage++;
          currentLine++;
          System.out.println(
              bookCounter + 1 + ". \""
                  + " Autor: " + printListBookJsonClass.get(bookCounter).getAuthor() + "   "
                  + " Tytuł: " + printListBookJsonClass.get(bookCounter).getTitle() + "   "
                  + "  Id:   " + printListBookJsonClass.get(bookCounter).getId());
          bookCounter++;
        } while (currentLine < lines && currentPage < printListBookJsonClass.size());
      } while (currentPage < printListBookJsonClass.size());
      if (bookCounter == printListBookJsonClass.size()) {
        System.out.println(
            "\n ############################## KONIEC LISTY ##############################");
        System.out.println(
            " \nEnter -> Powrót do wyboru kategorii");
        nextPageCheck = scanner.nextLine();
      }
    }
  }

  private void printAuthor(List<BookJsonClass> bookJsonClassRepository) {
    bookSorter.sortByAuthor(bookJsonClassRepository);
    List<String> authorList = new ArrayList<>();
    for (BookJsonClass bookJsonClass : bookJsonClassRepository) {
      if (!authorList.contains(bookJsonClass.getAuthor())) {
        authorList.add(bookJsonClass.getAuthor());
      }
    }
    int counter = 1;
    for (String book : authorList) {
      System.out.println(counter + "." + " " + book);
      counter++;
    }
  }

  private void printGenre(List<BookJsonClass> bookJsonClassRepository) {
    bookSorter.sortByGenre(bookJsonClassRepository);
    List<String> genreList = new ArrayList<>();
    for (BookJsonClass bookJsonClass : bookJsonClassRepository) {
      if (!genreList.contains(bookJsonClass.getGenre())) {
        genreList.add(bookJsonClass.getGenre());
      }
    }
    int counter = 1;
    for (String genre : genreList) {
      System.out.println(counter + "." + " " + genre);
      counter++;
    }
  }

  private void printKind(List<BookJsonClass> bookJsonClassRepository) {
    bookSorter.sortByKind(bookJsonClassRepository);
    List<String> kindList = new ArrayList<>();
    for (BookJsonClass bookJsonClass : bookJsonClassRepository) {
      if (!kindList.contains(bookJsonClass.getKind())) {
        kindList.add(bookJsonClass.getKind());
      }
    }
    int counter = 1;
    for (String kind : kindList) {
      System.out.println(counter + "." + " " + kind);
      counter++;
    }
  }

  private String provideAuthor() {
    System.out.println(" Wpisz imię i nazwisko autora z powyższej listy: ");
    String author = scanner.nextLine();
    if (author.length() == 0) {
      return "";
    } else if (author.length() < 3) {
      System.out.println(" Wpisz co najmniej 3 znaki!");
      return provideAuthor();
    } else {
      return author;
    }
  }

  private String provideGenre() {
    System.out.println(" Wpisz gatunek z powyższej listy: ");
    String genre = scanner.nextLine();

    if (genre.length() == 0) {
      return "";
    } else if (genre.length() < 3) {
      System.out.println(" Wpisz co najmniej 3 znaki!");
      return provideGenre();
    } else {
      return genre;
    }
  }

  private String provideKind() {
    System.out.println(" Wpisz rodzaj literacki z powyższej listy: ");
    String kind = scanner.nextLine();

    if (kind.length() == 0) {
      return "";
    } else if (kind.length() < 3) {
      System.out.println(" Wpisz co najmniej 3 znaki!");
      return provideKind();
    } else {
      return kind;
    }
  }

  private List<BookJsonClass> findBooksByAuthor(String author) {
    return bookJsonClasses.stream()
        .filter(
            book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
        .collect(Collectors.toList());
  }

  private List<BookJsonClass> findBooksByGenre(String genre) {
    return bookJsonClasses.stream()
        .filter(
            book -> book.getGenre().toLowerCase().contains(genre.toLowerCase()))
        .collect(Collectors.toList());
  }

  private List<BookJsonClass> findBooksByKind(String kind) {
    return bookJsonClasses.stream()
        .filter(
            book -> book.getKind().toLowerCase().contains(kind.toLowerCase()))
        .collect(Collectors.toList());
  }

  private void listFoundBooksAuthor() {
    printAuthor(bookJsonClasses);
    final List<BookJsonClass> booksFound = findBooksByAuthor(provideAuthor());
    bookSorter.sortByAuthor(booksFound);
    printList(booksFound);
    filterByCategory();
  }

  private void listFoundBooksGenre() {
    printGenre(bookJsonClasses);
    final List<BookJsonClass> booksFound = findBooksByGenre(provideGenre());
    bookSorter.sortByGenre(booksFound);
    printList(booksFound);
    filterByCategory();
  }

  private void listFoundBooksKind() {
    printKind(bookJsonClasses);
    final List<BookJsonClass> booksFound = findBooksByKind(provideKind());
    bookSorter.sortByKind(booksFound);
    printList(booksFound);
    filterByCategory();
  }
}