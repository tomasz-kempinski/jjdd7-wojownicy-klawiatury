package com.infoshareacademy;

import java.util.Scanner;
import java.util.List;

class BookList {
    void listBooks() {
        List<Book> books = Parser.getBooks();
        int lines = 20;
        int bookCounter = 0;
        int currentLine;
        int currentPage = 0;
        String nextPageCheck;
        Scanner scanner = new Scanner(System.in);
        do {
            if (currentPage > 0) {
                System.out.println("Enter- Kontynuuj wyświetlanie Z- Zakoncz");
                nextPageCheck = scanner.nextLine();
                if (nextPageCheck.equals("Z") || nextPageCheck.equals("z")) {
                    break;
                }
            }
            currentLine = 0;
            do {
                currentPage++;
                currentLine++;
                System.out.println(bookCounter + 1 + ". \"" + books.get(bookCounter).getTitle() + "\" - " + books.get(bookCounter).getAuthor());
                bookCounter++;
            } while (currentLine < lines && currentPage < books.size());
        } while (currentPage < books.size());
    }
}
