package com.infoshareacademy;

import java.util.Scanner;

public class FavouriteBooks {
    public void favoriteBooksMenu(){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<90; i++){
            System.out.println("");
        }
        System.out.println( "1- Wyświetlenie ulubionych książek");
        System.out.println( "2- Dodanie ulubionej książki");
        System.out.println( "3- Usunięcie ulubionej książki");
        System.out.println( "9- Powrót do menu");

        if (scanner.hasNextInt()){
            int choice = scanner.nextInt();
            switch (choice){
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

    private void favouriteBooksList(){

    }

    public void favouriteBooksAdd(int book){

    }

    private void favouriteBookRemove(){

    }
}
