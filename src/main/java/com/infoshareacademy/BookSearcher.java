package com.infoshareacademy;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.infoshareacademy.Parser.getBooks;

public class BookSearcher {

  private List<Book> books;

  public BookSearcher() {
    this.books = getBooks();
  }

  public void listBooksFound() {
    Scanner scanner = new Scanner(System.in);
    final List<Book> booksFound = findBooks(authorProvider(), titleProvider(), audioProvider());
    int lines = 20;
    int bookCounter = 0;
    int currentLine;
    int currentPage = 0;
    String nextPageCheck;
    do {
      if (currentPage > 0) {
        System.out
            .println(
                "\nEnter- Kontynuuj wyświetlanie || Z- Zakończ || W- wyświetl szczegóły książki ");
        nextPageCheck = scanner.nextLine();
        if (nextPageCheck.equalsIgnoreCase("Z")) {
          Menu menu = new Menu();
          menu.menu();
          break;
        }
        if (nextPageCheck.equalsIgnoreCase("W")) {
          SingleBookView singleBookView = new SingleBookView();
          singleBookView.selectBook();
          break;
        }
      }
      currentLine = 0;
      do {
        currentPage++;
        currentLine++;
        System.out.println(
            bookCounter + 1 + ". \"" + booksFound.get(bookCounter).getTitle() + "\" - " + booksFound
                .get(bookCounter).getAuthor());
        bookCounter++;
      } while (currentLine < lines && currentPage < booksFound.size());
    } while (currentPage < booksFound.size());
  }

  private String authorProvider() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj autora lub pomiń wciskając ENTER:");
    String author = scanner.nextLine();

    if (author.length() == 0) {
      return "";
    } else if (author.length() < 3) {
      System.out.println("Wpisz co najmniej 3 znaki!");
      return authorProvider();
    } else {
      return author;
    }
  }

  private String titleProvider() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj tytuł lub pomiń wciskając ENTER");
    String title = scanner.nextLine();

    if (title.length() == 0) {
      return "";
    } else if (title.length() < 3) {
      System.out.println("Wpisz co najmniej 3 znaki!");
      return titleProvider();
    } else {
      return title;
    }
  }

  private boolean audioProvider() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Czy książka ma mieć wersję audio? (T/N)");
    String audio = scanner.nextLine();
    boolean hasAudio = false;

    if (!audio.equalsIgnoreCase("T") && !audio.equalsIgnoreCase("N")) {
      System.out.println("Podaj prawidłowe dane!");
      audioProvider();
    } else if (audio.equalsIgnoreCase("T")) {
      hasAudio = true;
    }
    return hasAudio;
  }

  private List<Book> findBooks(String author, String title, Boolean hasAudio) {
    return books.stream()
        .filter(
            book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()) && book.getTitle()
                .toLowerCase().contains(title.toLowerCase())
                && book.getHasAudio() == hasAudio)
        .collect(Collectors.toList());
  }
}
