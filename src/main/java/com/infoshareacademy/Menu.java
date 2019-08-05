package com.infoshareacademy;

import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co chcesz zrobic ? \n 1- Przegladanie zbiorow \n 2- Rezerwacja pozycji/anulowanie rezerwacji");
        String choice = scanner.nextLine();
        if (choice=="1"){
            browsingCollections();

        } else if(choice=="2"){
        }
    }

    public void browsingCollections(){
        Scanner scanner = new Scanner(System.in);


    }
}
