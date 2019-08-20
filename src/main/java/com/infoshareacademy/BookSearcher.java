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
        final List<Book> booksFound = findBooks(provideAuthor(), provideTitle(), provideAudio());
        BooksPrinter.printListOfBooks(booksFound);
    }

    private String provideAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Podaj autora lub pomiń wciskając ENTER:");
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
        System.out.println(" Podaj tytuł lub pomiń wciskając ENTER");
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

    private boolean provideAudio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Czy książka ma mieć wersję audio? (T/N)");
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

    private List<Book> findBooks(String author, String title, Boolean hasAudio) {
        return books.stream()
                .filter(
                        book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()) && book.getTitle()
                                .toLowerCase().contains(title.toLowerCase())
                                && book.getHasAudio() == hasAudio)
                .collect(Collectors.toList());
    }
}
