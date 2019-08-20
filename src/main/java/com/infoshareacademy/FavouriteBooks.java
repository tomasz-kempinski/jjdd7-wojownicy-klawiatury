package com.infoshareacademy;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FavouriteBooks {
    ScreenCleaner screenCleaner = new ScreenCleaner();
    public void favoriteBooksMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println( "1- Wyświetlenie ulubionych książek");
        System.out.println( "2- Dodanie ulubionej książki");
        System.out.println( "3- Usunięcie ulubionej książki");
        System.out.println( "9- Powrót do menu");

        if (scanner.hasNextInt()){
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    screenCleaner.cleanScreen();
                    favouriteBooksList();
                    break;
                case 2:
                    screenCleaner.cleanScreen();
                    favouriteBooksAdd(-1);
                    break;
                case 3:
                    screenCleaner.cleanScreen();
                    favouriteBookRemove();
                    break;
                case 9:
                    screenCleaner.cleanScreen();
                    Menu menu = new Menu();
                    menu.menu();
                    break;
                default:
                    screenCleaner.cleanScreen();
                    favoriteBooksMenu();
                    break;

            }
        }
    }

    private void favouriteBooksList(){
        try {
            File file = new File("favouriteBooks.txt");
            Scanner scanner = new Scanner(file);
            String books = scanner.nextLine();
            char[] favouriteBooksChar = books.toCharArray();
            System.out.println(Arrays.toString(favouriteBooksChar));
        }
        catch (FileNotFoundException e){
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

    private void favouriteBookRemove(){

    }
}
