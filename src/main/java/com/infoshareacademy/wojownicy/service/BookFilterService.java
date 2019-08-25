package com.infoshareacademy.wojownicy.service;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookRepository;

import com.infoshareacademy.wojownicy.clas.Book;
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

  private List<Book> books;


  public BookFilterService() {
    this.books = getBookRepository();
  }

  public void filterByCategory() {
    screenCleaner.cleanScreen();
    System.out.println(" 1- Autor");
    System.out.println(" 2- Gatunek");
    System.out.println(" 3- Rodzaj literacki");
    System.out.println(" 4- AudioBook");
    System.out.println(" 9- Powrót");
    String choice = scanner.nextLine();
    switch (choice) {
      case "1":
        screenCleaner.cleanScreen();
        listFoundBooksAuthor();
        break;
      case "2":
        screenCleaner.cleanScreen();
        listFoundBooksGenre();
        break;
      case "3":
        screenCleaner.cleanScreen();
        listFoundBooksKind();
        break;
      case "4":
        screenCleaner.cleanScreen();
        listFoundBooksAudio();
      case "9":
        screenCleaner.cleanScreen();
        menu.browsingCollections();
        break;
      default:
        screenCleaner.cleanScreen();
        System.out.println("Zły wybór");
    }
  }

  private void printList(List<Book> printListBook) {
    int lines = 20;
    int bookCounter = 0;
    int currentLine;
    int currentPage = 0;
    String nextPageCheck;
    if (printListBook.isEmpty()) {
      screenCleaner.cleanScreen();
      System.out.println(" \nNie znaleziono żadnych książek.");
    } else {
      do {
        if (currentPage > 0) {
          screenCleaner.cleanScreen();
          System.out.println(
              " \nEnter -> Kontynuuj wyświetlanie || Z -> Zakończ wyświetlanie");
          nextPageCheck = scanner.nextLine();
          if (nextPageCheck.equalsIgnoreCase("Z")) {
            filterByCategory();
          }
        }
        currentLine = 0;
        do {
          currentPage++;
          currentLine++;
          screenCleaner.cleanScreen();
          System.out.println(
              bookCounter + 1 + ". \""
                  + " Autor: " + printListBook.get(bookCounter).getAuthor() + "   "
                  + " Tytuł: " + printListBook.get(bookCounter).getTitle() + "   "
                  + "  Id:   " + printListBook.get(bookCounter).getId());
          bookCounter++;
        } while (currentLine < lines && currentPage < printListBook.size());
      } while (currentPage < printListBook.size());
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
      screenCleaner.cleanScreen();
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
      screenCleaner.cleanScreen();
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
      screenCleaner.cleanScreen();
      System.out.println(counter + "." + " " + kind);
      counter++;
    }
  }

  private String provideAuthor() {
    screenCleaner.cleanScreen();
    System.out.println(" Wpisz imię i nazwisko autora z powyższej listy: ");
    String author = scanner.nextLine();
    if (author.length() == 0) {
      return "";
    } else if (author.length() < 3) {
      screenCleaner.cleanScreen();
      System.out.println(" Wpisz co najmniej 3 znaki!");
      return provideAuthor();
    } else {
      return author;
    }
  }

  private String provideGenre() {
    screenCleaner.cleanScreen();
    System.out.println(" Wpisz gatunek z powyższej listy: ");
    String genre = scanner.nextLine();

    if (genre.length() == 0) {
      return "";
    } else if (genre.length() < 3) {
      screenCleaner.cleanScreen();
      System.out.println(" Wpisz co najmniej 3 znaki!");
      return provideGenre();
    } else {
      return genre;
    }
  }

  private String provideKind() {
    screenCleaner.cleanScreen();
    System.out.println(" Wpisz rodzaj literacki z powyższej listy: ");
    String kind = scanner.nextLine();

    if (kind.length() == 0) {
      return "";
    } else if (kind.length() < 3) {
      screenCleaner.cleanScreen();
      System.out.println(" Wpisz co najmniej 3 znaki!");
      return provideKind();
    } else {
      return kind;
    }
  }

  private boolean provideAudio() {
    screenCleaner.cleanScreen();
    System.out.println(" Wybierz czy chcesz wyświetlić książki z audio: (T/N) ");
    String audio = scanner.nextLine();
    boolean hasAudio = false;

    if (!audio.equalsIgnoreCase("T") && !audio.equalsIgnoreCase("N")) {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj prawidłowe dane!");
      provideAudio();
    } else if (audio.equalsIgnoreCase("T")) {
      hasAudio = true;
    }
    return hasAudio;
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

  private List<Book> findBooksByAudio(Boolean hasAudio) {
    return books.stream()
        .filter(
            book -> book.getHasAudio() == hasAudio)
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

  private void listFoundBooksAudio() {
    final List<Book> booksFound = findBooksByAudio(provideAudio());
    printList(booksFound);
    filterByCategory();
  }
}

