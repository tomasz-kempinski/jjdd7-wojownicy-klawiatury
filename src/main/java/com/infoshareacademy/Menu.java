package com.infoshareacademy;

import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co chcesz zrobic ? \n 1- Przegladanie zbiorow \n 2- Rezerwacja pozycji/anulowanie rezerwacji");
        String choice = scanner.nextLine();
        if (choice=="1"){
            System.out.println("Jak chcesz wyszukac ksiazke? \n 1- Lista ksiazek dostepnych w bazie \n 2- Wyszukiwanie ksiazek wg: autora, tytulu, wersji audio ");
            choice = scanner.nextLine();
            //teraz trzeba wywolac odpowiednia klase/metode ktora utworzymy pod te rzeczy
        } else if(choice=="2"){
            System.out.println("1- Rezerwacja pozycji \n 2-anulowanie pozycji");
            choice = scanner.nextLine();


        }
    }
}
