package com.infoshareacademy;

import java.util.Scanner;
import java.util.List;

public class BookList {
    public void listBooks() {
        List<Book> books = Parser.getBooks();
        int lines = 20;
        int additionalLines = books.size()%lines;
        int pages = (books.size() / lines) + additionalLines;
        int bookCounter = 0;
        int currentLine;
        int currentPage = 0;
        String nextPageCheck = "K";

        Scanner scanner = new Scanner(System.in);
        do {
            currentPage++;
            currentLine = 0;
            do {
                currentLine++;
                System.out.println(bookCounter + 1 + ". " + books.get(bookCounter).getTitle() + "  " +books.get(bookCounter).getAuthor());
                bookCounter++;
            } while (currentLine < lines);
            System.out.println("Wybierz K- Kontynuuj wyświetlanie Z- Zakoncz");
            nextPageCheck = scanner.nextLine();
            if (nextPageCheck.equals("Z") || nextPageCheck.equals("z")) {
                break;
            }
        } while (currentPage < pages);

    }
}
