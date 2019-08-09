package com.infoshareacademy;

import java.util.Scanner;

class Menu {
    void menu() {
        Scanner scanner = new Scanner (System.in);

        System.out.println ("Co chcesz zrobic ?");
        System.out.println ("1- Przegladanie zbiorow");
        System.out.println ("2- Rezerwacja pozycji/anulowanie rezerwacji");
        System.out.println ("9- Zakoncz program");
        if (scanner.hasNextInt ( )) {
            int choice = scanner.nextInt ( );
            switch (choice) {
                case 1:
                    browsingCollections ( );
                    break;
                case 2:
                    reservations ( );
                    break;
                case 9:
                    break;
                default:
                    System.out.println ("Podaj wartosc 1, 2 lub 9!!");
                    menu ( );
                    break;
            }
        } else {
            System.out.println ("Podaj wlasciwa wartosc !");
            menu ( );
        }
    }

    private void browsingCollections() {
        Scanner scanner = new Scanner (System.in);
        System.out.println (" 1- Lista ksiazek");
        System.out.println (" 2- Wyszukiwanie ksiazek (wg autora, tytulu, wersji audio)");
        System.out.println (" 3- Przegladanie pojedynczej pozycji");
        System.out.println (" 9- Powrot");
        if (scanner.hasNextInt ( )) {
            int choice = scanner.nextInt ( );
            switch (choice) {
                case 1:
                    //zamienic na klase generujaca liste ksiazek
                    System.out.println ("Lista ksiazek");
                    break;
                case 2:
                    //zamienic na klase wyszukujaca ksiazke
                    System.out.println ("Wyszukiwanie ksiazek");
                    break;
                case 3:
                    //zamienic na klase dajaca mozliwosc przegladanie pojedynczej pozycji
                    System.out.println ("Przegladanie pojedynczej pozycji");
                    break;
                case 9:
                    menu ( );
                    break;
                default:
                    System.out.println ("Podaj wlasciwa wartosc !");
                    browsingCollections ( );
                    break;
            }
        } else {
            System.out.println ("Podaj wlasciwa wartosc! ");
            browsingCollections ( );
        }
    }

    private String reservations() {
        //trzeba bedzie ogarnac jakos polaczenie z rezerwacjami albo anulowaniem

        Scanner scanner = new Scanner (System.in);
        System.out.println ("Podaj Imie i Nazwisko     (9- powrot do poczatku)");
        String name = scanner.nextLine ( );

        if (name.equals ("9")) {
            menu ( );
            return null;
        } else if (name.length ( ) < 3) {
            System.out.println ("Podaj prawidlowe dane !");
            reservations ( );
            return null;
        } else {
            reservationMenu (name);
        }
        return null;
    }


    private String reservationMenu(String name) {
        Scanner scanner = new Scanner (System.in);

        System.out.println (" 1- rezerwacja");
        System.out.println (" 2- anulowanie rezerwacji");
        System.out.println (" 3- Popraw imie i nazwisko");
        System.out.println (" 9- powrot do poczatku");
        if (scanner.hasNextInt ( )) {
            int choice = scanner.nextInt ( );
            switch (choice) {
                case 1:
                    System.out.println (name + " rezerwacja");
                    return name;
                case 2:
                    System.out.println (name + " anulowanie rezerwacji");
                    return name;
                case 3:
                    reservations ( );
                    break;
                case 9:
                    menu ( );
                    break;

                default:
                    System.out.println ("Podaj prawidlowe wartosci !");
                    reservationMenu (name);
                    break;
            }
        } else {
            System.out.println ("Podaj wlasciwa wartosc !!");
            reservationMenu (name);
        }
        return null;
    }

}
