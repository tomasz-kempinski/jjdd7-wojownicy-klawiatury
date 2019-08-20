package com.infoshareacademy;

import java.util.Scanner;

class Menu {
    void menu() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 90; i++) {
            System.out.println("");
        }
        System.out.println(" Co chcesz zrobić?\n");
        System.out.println(" 1- Przeglądanie zbiorów");
        System.out.println(" 2- Rezerwacja pozycji/anulowanie rezerwacji");
        System.out.println(" 3- Ulubione książki");
        System.out.println(" 9- Zakończ program");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    browsingCollections();
                    break;
                case 2:
                    reservations();
                    break;
                case 3:
                    FavouriteBooks favouriteBooks = new FavouriteBooks();
                    favouriteBooks.favoriteBooksMenu();
                    break;
                case 9:
                    break;
                default:
                    menu();
                    break;
            }
        } else {
            System.out.println(" Podaj właściwą wartość!");
            menu();
        }
    }

    private void browsingCollections() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 40; i++) {
            System.out.println("");
        }
        System.out.println(" 1- Lista ksiażek");
        System.out.println(" 2- Wyszukiwanie ksiażek (wg autora, tytułu, wersji audio)");
        System.out.println(" 3- Przeglądanie pojedynczej pozycji");
        System.out.println(" 9- Powrót");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    BookList bookList = new BookList();
                    System.out.println("\n########################### Lista książek ###########################\n");
                    bookList.listBooks();
                    decision();
                    break;
                case 2:
                    System.out.println("\n######################### Wyszukiwanie książek #########################\n");
                    BookSearcher bookSearcher = new BookSearcher();
                    bookSearcher.listBooksFound();
                    decision();
                    break;
                case 3:
                    SingleBookView singleBookView = new SingleBookView();
                    System.out.println("\n################### Przeglądanie pojedynczej pozycji ####################\n");
                    singleBookView.selectBook();
                    break;
                case 9:
                    menu();
                    break;
                default:
                    System.out.println(" Podaj własciwa wartość!");
                    browsingCollections();
                    break;
            }
        } else {
            System.out.println(" Podaj własciwą wartość!");
            browsingCollections();
        }
    }

    private String reservations() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 40; i++) {
            System.out.println("");
        }
        System.out.println(" Podaj Imię i Nazwisko     (9- powrót do początku)");
        String name = scanner.nextLine();

        if (name.equals("9")) {
            menu();
            return null;
        } else if (name.length() < 3) {
            System.out.println(" Podaj prawidłowe dane!");
            reservations();
            return null;
        } else {
            reservationMenu(name);
        }
        return null;
    }

    private String reservationMenu(String name) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 90; i++) {
            System.out.println("");
        }
        System.out.println(" 1- Rezerwacja");
        System.out.println(" 2- Anulowanie rezerwacji");
        System.out.println(" 3- Popraw imię i nazwisko");
        System.out.println(" 9- Powrót do poczatku");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(name + " rezerwacja");
                    System.out.println(" Funkcja w czasie implementacji");
                    decision();
                    return name;
                case 2:
                    System.out.println(" " + name + " anulowanie rezerwacji");
                    System.out.println(" Funkcja w czasie implementacji");
                    decision();
                    return name;
                case 3:
                    reservations();
                    break;
                case 9:
                    menu();
                    break;
                default:
                    System.out.println(" Podaj prawidłowe wartości!");
                    reservationMenu(name);
                    break;
            }
        } else {
            System.out.println(" Podaj właściwą wartość!");
            reservationMenu(name);
        }
        return null;
    }

    private void decision() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 90; i++) {
            System.out.println("");
        }
        int decision;
        System.out.println(" 1- Powrót do menu ");
        System.out.println(" 2- Wyjście ");
        if (scanner.hasNextInt()) {
            decision = scanner.nextInt();
            switch (decision) {
                case 1:
                    menu();
                    break;
                case 2:
                    break;
                default:
                    System.out.println(" Podaj właściwe dane!");
                    decision();
            }
        } else {
            System.out.println(" Podaj właściwe dane!");
            decision();
        }
    }
}
