package com.infoshareacademy.wojownicy.service;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookRepository;

import com.infoshareacademy.wojownicy.clas.Book;
import com.infoshareacademy.wojownicy.menu.Menu;
import com.infoshareacademy.wojownicy.menu.SingleBookViewMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BookFilterService {

  private Scanner scanner = new Scanner(System.in);
  private BookSorter bookSorter = new BookSorter();
  private ScreenCleaner screenCleaner = new ScreenCleaner();
  private Menu menu = new Menu();

  private List<Book> books;


  public BookFilterService() {
    this.books = getBookRepository();
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

  private void printList(List<Book> printListBook) {
    int lines = 20;
    int bookCounter = 0;
    int currentLine;
    int currentPage = 0;
    String nextPageCheck;
    if (printListBook.isEmpty()) {
      System.out.println(" \nNie znaleziono żadnych książek.");
    } else {
      do {
        if (currentPage > 0) {
          System.out.println(
              " \nEnter -> Kontynuuj wyświetlanie || Z -> Zakończ wyświetlanie");
          nextPageCheck = scanner.nextLine();
          if (nextPageCheck.equalsIgnoreCase("Z")) {
            filterByCategory();
            break;
          }
        }
        currentLine = 0;
        do {
          currentPage++;
          currentLine++;
          System.out.println(
              bookCounter + 1 + ". \""
                  + " Autor: " + printListBook.get(bookCounter).getAuthor() + "   "
                  + " Tytuł: " + printListBook.get(bookCounter).getTitle() + "   "
                  + "  Id:   " + printListBook.get(bookCounter).getId());
          bookCounter++;
        } while (currentLine < lines && currentPage < printListBook.size());
      } while (currentPage < printListBook.size());
      if (bookCounter == printListBook.size()) {
        System.out.println(
            "\n ############################## KONIEC LISTY ##############################");
        System.out.println(
            " \nEnter -> Powrót do wyboru kategorii");
        nextPageCheck = scanner.nextLine();
      }
    }
  }

  private void printAuthor(List<Book> bookRepository) {
    bookSorter.sortByAuthor(bookRepository);
    List<String> authorList = new ArrayList<>();
    for (Book book : bookRepository) {
      if (!authorList.contains(book.getAuthor())) {
        authorList.add(book.getAuthor());
      }
    }
    int counter = 1;
    for (String book : authorList) {
      System.out.println(counter + "." + " " + book);
      counter++;
    }
  }

  private void printGenre(List<Book> bookRepository) {
    bookSorter.sortByGenre(bookRepository);
    List<String> genreList = new ArrayList<>();
    for (Book book : bookRepository) {
      if (!genreList.contains(book.getGenre())) {
        genreList.add(book.getGenre());
      }
    }
    int counter = 1;
    for (String genre : genreList) {
      System.out.println(counter + "." + " " + genre);
      counter++;
    }
  }

  private void printKind(List<Book> bookRepository) {
    bookSorter.sortByKind(bookRepository);
    List<String> kindList = new ArrayList<>();
    for (Book book : bookRepository) {
      if (!kindList.contains(book.getKind())) {
        kindList.add(book.getKind());
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

  private List<Book> findBooksByAuthor(String author) {
    return books.stream()
        .filter(
            book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
        .collect(Collectors.toList());
  }

  private List<Book> findBooksByGenre(String genre) {
    return books.stream()
        .filter(
            book -> book.getGenre().toLowerCase().contains(genre.toLowerCase()))
        .collect(Collectors.toList());
  }

  private List<Book> findBooksByKind(String kind) {
    return books.stream()
        .filter(
            book -> book.getKind().toLowerCase().contains(kind.toLowerCase()))
        .collect(Collectors.toList());
  }

  private void listFoundBooksAuthor() {
    printAuthor(books);
    final List<Book> booksFound = findBooksByAuthor(provideAuthor());
    bookSorter.sortByAuthor(booksFound);
    printList(booksFound);
    filterByCategory();
  }

  private void listFoundBooksGenre() {
    printGenre(books);
    final List<Book> booksFound = findBooksByGenre(provideGenre());
    bookSorter.sortByGenre(booksFound);
    printList(booksFound);
    filterByCategory();
  }

  private void listFoundBooksKind() {
    printKind(books);
    final List<Book> booksFound = findBooksByKind(provideKind());
    bookSorter.sortByKind(booksFound);
    printList(booksFound);
    filterByCategory();
  }
}