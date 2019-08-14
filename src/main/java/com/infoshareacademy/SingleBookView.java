package com.infoshareacademy;

import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.Parser.getBooks;

public class SingleBookView {
    BookList bookList = new BookList();

    public void selectBook(){
        Scanner scanner = new Scanner(System.in);
        List<Book> books = getBooks();
        int choice;
        int bookNumber;
        System.out.println(" Podaj numer książki, którą chcesz zobaczyć");
        if (scanner.hasNextInt()){
            bookNumber=scanner.nextInt();
            if(bookNumber<=books.size()){
                singleBookView(bookNumber);
            }else {
                System.out.println(" Podaj liczbę odpowiadającą książce!");
                System.out.println(" 1- Wyświetl listę książek 2- Wyszukaj książkę");
                System.out.println(" 3- Wpisz numer książki ponownie");
                if(scanner.hasNextInt()){
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1: bookList.listBooks();
                        break;
                        case 2: //trzeba dodać przejście do wyszukiwania książek
                            System.out.println("Wyszukiwanie książek");
                            break;
                        default:selectBook();
                    }
                }

            }
        }else {
            System.out.println(" Podaj liczbę!");
            selectBook();
        }
    }


    private void singleBookView(int bookNumber) {
        List<Book> books = getBooks();
        Scanner scanner = new Scanner(System.in);
        String hasAudio;
        int choice;
        if (books.get(bookNumber).getHasAudio()){
            hasAudio = "tak";
        } else {
            hasAudio = "nie";
        }
        System.out.println(books.get(bookNumber).getAuthor());
        System.out.println(books.get(bookNumber).getTitle());
        System.out.println(books.get(bookNumber).getKind());
        System.out.println(books.get(bookNumber).getGenre());
        System.out.println(" Książka posiada wersje audio: " + hasAudio);

        System.out.println(" 1- Wyświetlenie kolejnej książki 2- Powrót do Menu");
        System.out.println(" 3- Lista książek                 4- Wyszukiwanie książek");
        if(scanner.hasNextInt()){
            choice= scanner.nextInt();
            switch (choice){
                case 1: selectBook();
                break;
                case 2: Menu menu = new Menu();
                menu.menu();
                break;
                case 3: bookList.listBooks();
                break;
                case 4://dodać przejście do wyszukiwania książek
                default:
                    System.out.println("Podaj prawidłową wartość!");
                    singleBookView(bookNumber);


            }
        }



    }
}

