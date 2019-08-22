package com.infoshareacademy;

import static com.infoshareacademy.BookRepository.getBookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BookFilterService {

  Scanner scanner = new Scanner(System.in);
  private List<Book> books;


  public BookFilterService() {
    this.books = getBookRepository();
  }

  private void printList(List<Book> printListBook) {
    //BookSorter bookSorter = new BookSorter();
    //bookSorter.sortByTitle(printListBook);
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
              " \nEnter -> Kontynuuj wyświetlanie || Z -> Zakończ");
          nextPageCheck = scanner.nextLine();
          if (nextPageCheck.equalsIgnoreCase("Z")) {
            Menu menu = new Menu();
            menu.menu();
            break;
          }
        }
        currentLine = 0;
        do {
          String hasAudio;
          if (printListBook.get(bookCounter).getHasAudio()) {
            hasAudio = "TAK";
          } else {
            hasAudio = "NIE";
          }
          currentPage++;
          currentLine++;
          System.out.println(
              bookCounter + 1 + ". \""
                  + " Autor: " + "\" - " + printListBook.get(bookCounter).getAuthor() + "\" - "
                  + " Tytuł: " + "\" - " + printListBook.get(bookCounter).getTitle() + "\" - "
                  + " Gatunek: " + "\" - " + printListBook.get(bookCounter).getGenre() + "\" - "
                  + " Wersja audio: " + "\" - " + hasAudio + "\" - ");
          bookCounter++;
        } while (currentLine < lines && currentPage < printListBook.size());
      } while (currentPage < printListBook.size());
    }
  }


  public void filterByCategory() {
    System.out.println(" Filtrowanie według kategorii: ");
    System.out.println("1. Autor");
    System.out.println("2. Tytuł");
    System.out.println("3. Gatunek");
    System.out.println("4. AudioBook");
    System.out.println("5. Powrót");
    String choice = scanner.nextLine();
    switch (choice) {
      case "1":
        listFoundBooksAuthor();
        break;
      case "2":
        listFoundBooksTitle();
        break;
      case "3":
        listFoundBooksGenre();
        break;
      case "4":
        listFoundBooksAudio();
      default:
        System.out.println("Zły wybór");
    }
  }

  private void printAuthor(List<Book> bookRepository) {
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

  private void printTitle(List<Book> bookRepository) {
    List<String> titleList = new ArrayList<>();
    for (Book book : bookRepository) {
      if (!titleList.contains(book.getTitle())) {
        titleList.add(book.getTitle());
      }
    }
    int counter = 1;
    for (String title : titleList) {
      System.out.println(counter + "." + " " + title);
      counter++;
    }
  }

  private void printGenre(List<Book> bookRepository) {
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

  private String provideAuthor() {
    System.out.println(" Wybierz autora z powyższej listy: ");
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

  private String provideTitle() {
    System.out.println(" Wybierz tytuł z powyższej listy: ");
    String title = scanner.nextLine();

    if (title.length() == 0) {
      return "";
    } else if (title.length() < 3) {
      System.out.println(" Wpisz co najmniej 3 znaki!");
      return provideTitle();
    } else {
      return title;
    }
  }

  private String provideGenre() {
    System.out.println(" Wybierz gatunek z powyższej listy: ");
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

  private boolean provideAudio() {
    System.out.println(" Wybierz czy chcesz wyświetlić książki z audio: (T/N) ");
    String audio = scanner.nextLine();
    boolean hasAudio = false;

    if (!audio.equalsIgnoreCase("T") && !audio.equalsIgnoreCase("N")) {
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

  private List<Book> findBooksByTitle(String title) {
    return books.stream()
        .filter(
            book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
        .collect(Collectors.toList());
  }

  private List<Book> findBooksByGenre(String genre) {
    return books.stream()
        .filter(
            book -> book.getGenre().toLowerCase().contains(genre.toLowerCase()))
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
    printList(booksFound);
  }

  private void listFoundBooksTitle() {
    printTitle(books);
    final List<Book> booksFound = findBooksByTitle(provideTitle());
    printList(booksFound);
  }

  private void listFoundBooksGenre() {
    printGenre(books);
    final List<Book> booksFound = findBooksByGenre(provideGenre());
    printList(booksFound);
  }

  private void listFoundBooksAudio() {
    final List<Book> booksFound = findBooksByAudio(provideAudio());
    printList(booksFound);
  }
}

