package com.infoshareacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FavouriteBooks {
    public void favoriteBooksMenu() {
        Scanner scanner = new Scanner(System.in);
        try {
            if (System.getProperty("os.name").contains("Mac") || System.getProperty("os.name").contains("Linux")) {
                System.out.println(System.getProperty("os.name"));
                Runtime.getRuntime().exec("clear");
            } else if (System.getProperty("os.name").contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
        } catch (IOException e) {
            System.out.println("Błąd systemu operacyjnego");
        }
        System.out.println("1- Wyświetlenie ulubionych książek");
        System.out.println("2- Dodanie ulubionej książki");
        System.out.println("3- Usunięcie ulubionej książki");
        System.out.println("9- Powrót do menu");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    favouriteBooksList();
                    break;
                case 2:
                    favouriteBooksAdd(-1);
                    break;
                case 3:
                    favouriteBookRemove();
                    break;
                case 9:
                    Menu menu = new Menu();
                    menu.menu();
                    break;
                default:
                    favoriteBooksMenu();
                    break;

            }
        }
    }

    private void favouriteBooksList() {
        try {
            File file = new File("favouriteBooks.txt");
            Scanner scanner = new Scanner(file);
            String books = scanner.nextLine();
            char[] favouriteBooksChar = books.toCharArray();
            System.out.println(Arrays.toString(favouriteBooksChar));
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku");
        }

    }

    public void favouriteBooksAdd(int book) {
        try {
            PrintWriter writer = new PrintWriter("favouriteBooks.txt");
            writer.println("zzz");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(" Brak pliku z książkami");
        }

    }

    private void favouriteBookRemove() {

    }
}
