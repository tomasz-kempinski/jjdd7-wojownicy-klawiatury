package com.infoshareacademy;

import java.util.Scanner;

public class BookList {
    public void listBooks() {
        int pages = 10;
        int lines = 20;
        int currentLine;
        int currentPage = 0;
        String nextPageCheck = "K";
        Scanner scanner = new Scanner(System.in);
        do {
            currentPage++;
            currentLine = 0;

            do {
                currentLine++;
                System.out.println("One line");
            } while (currentLine < lines);
            System.out.println("Wybierz K- Kontynuuj wyświetlanie Z- Zakoncz");
            nextPageCheck = scanner.nextLine();
            if (nextPageCheck.equals("Z") || nextPageCheck.equals("z")) {
                break;
            }
        } while (currentPage < pages);
    }
}

