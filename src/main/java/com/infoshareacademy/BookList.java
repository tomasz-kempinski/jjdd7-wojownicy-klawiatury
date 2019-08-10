package com.infoshareacademy;
import java.util.Scanner;
import java.util.List;

public class BookList {
    public void listBooks() {
        List<Book> books = Parser.getBooks();
        int lines = 20;
        int bookCounter = 0;
        int currentLine;
        int currentPage = 0;
        String nextPageCheck;
        Scanner scanner = new Scanner(System.in);

        do {
            currentLine = 0;
            do {
                currentPage++;
                currentLine++;
                System.out.println(bookCounter + 1 + ". " + books.get(bookCounter).getTitle() + "  " +books.get(bookCounter).getAuthor());
                bookCounter++;
            } while (currentLine < lines && currentPage< books.size());
            System.out.println("Enter- Kontynuuj wyświetlanie Z- Zakoncz");
            nextPageCheck = scanner.nextLine();
            if (nextPageCheck.equals("Z") || nextPageCheck.equals("z")) {
                break;
            }
        } while (currentPage < books.size());

    }
}
