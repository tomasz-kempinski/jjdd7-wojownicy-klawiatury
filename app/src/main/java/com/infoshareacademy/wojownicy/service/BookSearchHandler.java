package com.infoshareacademy.wojownicy.service;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookRepository;

import com.infoshareacademy.wojownicy.clas.Book;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookSearchHandler {

  private List<Book> books;

  public BookSearchHandler() {
    this.books = getBookRepository();
  }

  public void listFoundBooks() {
    final List<Book> booksFound = findBooks(provideAuthor(), provideTitle(), provideAudio());
    BooksPrinter.printListOfBooks(booksFound);
  }

  private List<Book> findBooks(String author, String title, String hasAudio) {
    if (hasAudio.equals("")) {
      return books.stream()
          .filter(
              book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()) && book
                  .getTitle()
                  .toLowerCase().contains(title.toLowerCase()))
          .collect(Collectors.toList());
    } else {
      return books.stream()
          .filter(
              book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()) && book
                  .getTitle()
                  .toLowerCase().contains(title.toLowerCase())
                  && book.getHasAudio() == Boolean.parseBoolean(hasAudio))
          .collect(Collectors.toList());
    }
  }

  private String provideAuthor() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" \nPodaj autora lub pomiń wciskając ENTER:");
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
    Scanner scanner = new Scanner(System.in);
    System.out.println(" \nPodaj tytuł lub pomiń wciskając ENTER");
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

  private String provideAudio() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" \nCzy książka ma mieć wersję audio? (T/N lub pomiń wciskając ENTER)");
    String input = scanner.nextLine();
    String hasAudio = "false";

    if (input.equals("")) {
      hasAudio = "";
    } else if (!input.equalsIgnoreCase("T") && !input.equalsIgnoreCase("N")) {
      System.out.println(" Podaj prawidłowe dane!");
      return provideAudio();
    } else if (input.equalsIgnoreCase("T")) {
      hasAudio = "true";
    }
    return hasAudio;
  }
}
