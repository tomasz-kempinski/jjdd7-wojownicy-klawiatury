package com.infoshareacademy;

import java.util.*;

import static com.infoshareacademy.Parser.*;

class BookList {
    void listBooks() {
        Config config = new Config();
        config.loadConfig("sort");
        String property = config.getProperty();
        List<Book> books = getBooks();
        int lines = 20;
        int bookCounter = 0;
        int currentLine;
        int currentPage = 0;
        String nextPageCheck;
        Scanner scanner = new Scanner(System.in);
        if (property.equals("ASC")) {
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });
        } else if (property.equals("DSC")) {
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });
            Collections.reverse(books);
        }
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
