package com.infoshareacademy;

import java.util.Scanner;

class Menu {
    void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co chcesz zrobic ? \n 1- Przegladanie zbiorow \n 2- Rezerwacja pozycji/anulowanie rezerwacji \n 9- Zakoncz program");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                browsingCollections();

                break;
            case "2":
                reservations();
                break;
            case "9":
                break;
            default:
                System.out.println("Podaj wartosc 1, 2 lub 9!!");
                menu();
                break;
        }
    }

    private void browsingCollections() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1- Lista ksiazek \n 2- Wyszukiwanie ksiazek (wg autora, tytulu, wersji audio). \n 3- Przegladanie pojedynczej pozycji \n 9- powrot");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                //zamienic na klase generujaca liste ksiazek
                System.out.println("Lista ksiazek");
                break;
            case "2":
                //zamienic na klase wyszukujaca ksiazke
                System.out.println("Wyszukiwanie ksiazek");
                break;
            case "3":
                //zamienic na klase dajaca mozliwosc przegladanie pojedynczej pozycji
                System.out.println("Przegladanie pojedynczej pozycji");
                break;
            case "9":
                menu();
                break;
            default:
                System.out.println("Podaj wlasciwa wartosc !");
                browsingCollections();
                break;

        }
    }

    private String reservations() {
        //trzeba bedzie ogarnac jakos polaczenie z rezerwacjami albo anulowaniem
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj Imie i Nazwisko     (9- powrot do poczatku)");
        String name = scanner.nextLine();

        if (name.equals("9")) {
            menu();
            return null;
        } else if (name.length() < 3) {
            System.out.println("Podaj prawidlowe dane !");
            reservations();
            return null;
        }

        System.out.println(" 1- rezerwacja \n 2- anulowanie rezerwacji \n 9- powrot do poczatku");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println(name + " rezerwacja");

                return name;

            case "2":
                System.out.println(name + " anulowanie rezerwacji");
                return name;

            case "9":
                menu();
                break;

            default:
                System.out.println("Podaj prawidlowe wartosci !");
                reservations();
                break;
        }
        return null;
    }
}
