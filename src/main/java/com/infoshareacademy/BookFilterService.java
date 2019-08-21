package com.infoshareacademy;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BookFilterService {

    public void filterByCategory() {
        System.out.println(" Filtrowanie według kategorii: ");
        System.out.println("1. Autor");
        System.out.println("2. Tytuł");
        System.out.println("3. Gatunek");
        System.out.println("4. AudioBook");
        System.out.println("5. Powrót");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                printAuthor(BookRepository.getBookRepository());
                enterAuthorName();
                break;
            case "2":
                printTitle(BookRepository.getBookRepository());
                enterTitle();
                break;
            case "3":
                printGenre(BookRepository.getBookRepository());
                enterGenre();
                break;
            case "4":
                printAudioBook(BookRepository.getBookRepository());
                enterAudioBook();
            default:
                System.out.println("Zły wybór");
        }
    }

    private void printAuthor(List<Book> bookRepository) {
        List<String> authorList = new ArrayList<>();
        for (Book book : bookRepository) {
            if (!authorList.contains(book.getAuthor())) {
                authorList.add(book.getAuthor());
            }
        }
        int counter = 1;
        for (String book : authorList) {
            System.out.println(counter + "." + " " + book);
            counter++;
        }
    }

    private List<String> enterAuthorName() {
        Scanner scanner = new Scanner(System.in);
        List<String> authorList = new ArrayList<>();
        boolean isSearchFinished = false;
        do {
            System.out.println("Podaj imię i nazwisko autora z listy:");
            String book = scanner.nextLine();
            boolean isFoundAuthor = false;
            for (int i = 0; i < BookRepository.getBookRepository().size(); i++) {
                if (book.toLowerCase().replaceAll("\\s", "").equals(BookRepository.getBookRepository()
                        .get(i).getAuthor().toLowerCase().replaceAll("\\s", ""))) {
                    authorList.add(book);
                    isFoundAuthor = true;

                    break;
                }
            }
            if (!isFoundAuthor) {
                System.out.println("Nie ma takiego autora " + book + " na liście.");
            }
            System.out.println("Czy chcesz wybrać kolejnego autora?");
            isSearchFinished = isSearchFinishedAndScanner(scanner, isSearchFinished);
        } while (!isSearchFinished);
        return authorList;
    }

    private void printTitle(List<Book> bookRepository) {
        List<String> titleList = new ArrayList<>();
        for (Book book : bookRepository) {
            if (!titleList.contains(book.getTitle())) {
                titleList.add(book.getTitle());
            }
        }
        int counter = 1;
        for (String title : titleList) {
            System.out.println(counter + "." + " " + title);
            counter++;
        }
    }

    private List<String> enterTitle() {
        Scanner scanner = new Scanner(System.in);
        List<String> titleList = new ArrayList<>();
        boolean isSearchFinished = false;
        do {
            System.out.println("Podaj tytuł książki z listy:");
            String title = scanner.nextLine();
            boolean isFoundTitle = false;
            for (int i = 0; i < BookRepository.getBookRepository().size(); i++) {
                if (title.toLowerCase().replaceAll("\\s", "").equals(BookRepository.getBookRepository()
                        .get(i).getTitle().toLowerCase().replaceAll("\\s", ""))) {
                    titleList.add(title);
                    isFoundTitle = true;

                    break;
                }
            }
            if (!isFoundTitle) {
                System.out.println("Nie ma książki o takim tytule " + title + " na liście.");
            }
            System.out.println("Czy chcesz wybrać inny tytuł?");
            isSearchFinished = isSearchFinishedAndScanner(scanner, isSearchFinished);
        } while (!isSearchFinished);
        return titleList;
    }

    private void printGenre(List<Book> bookRepository) {
        List<String> genreList = new ArrayList<>();
        for (Book book : bookRepository) {
            if (!genreList.contains(book.getGenre())) {
                genreList.add(book.getGenre());
            }
        }
        int counter = 1;
        for (String genre : genreList) {
            System.out.println(counter + "." + " " + genre);
            counter++;
        }
    }

    private List<String> enterGenre() {
        Scanner scanner = new Scanner(System.in);
        List<String> genreList = new ArrayList<>();
        boolean isSearchFinished = false;
        do {
            System.out.println("Podaj gatunek książki z listy:");
            String genre = scanner.nextLine();
            boolean isFoundGenre = false;
            for (int i = 0; i < BookRepository.getBookRepository().size(); i++) {
                if (genre.toLowerCase().replaceAll("\\s", "").equals(BookRepository.getBookRepository()
                        .get(i).getGenre().toLowerCase().replaceAll("\\s", ""))) {
                    genreList.add(genre);
                    isFoundGenre = true;

                    break;
                }
            }
            if (!isFoundGenre) {
                System.out.println("Nie ma książki o takim gatunku " + genre + " na liście.");
            }
            System.out.println("Czy chcesz wybrać inny gatunek?");
            isSearchFinished = isSearchFinishedAndScanner(scanner, isSearchFinished);
        } while (!isSearchFinished);
        return genreList;
    }

    private void printAudioBook(List<Book> bookRepository) {
        List<Boolean> audioBookList = new ArrayList<>();
        for (Book book : bookRepository) {
            if (!audioBookList.contains(book.getHasAudio())) {
                audioBookList.add(book.getHasAudio());
            }
        }
        int counter = 1;
        for (Boolean audioBook : audioBookList) {
            System.out.println(counter + "." + " " + audioBook);
            counter++;
        }
    }

    private List<Boolean> enterAudioBook() {
        Scanner scanner = new Scanner(System.in);
        List<Boolean> audioBookList = new ArrayList<>();
        boolean isSearchFinished = false;
        do {
            System.out.println("Podaj swój wybór: ");
            Boolean audioBook = scanner.hasNext();
            boolean isFoundAudioBook = false;
            for (int i = 0; i < BookRepository.getBookRepository().size(); i++) {
                if (audioBook.equals(BookRepository.getBookRepository()
                        .get(i).getHasAudio())) {
                    audioBookList.add(audioBook);
                    isFoundAudioBook = true;

                    break;
                }
            }
            if (!isFoundAudioBook) {
                System.out.println("To jest zły wybór: " + audioBook + ".");
            }
            System.out.println("Czy chcesz dokonać innego wyboru?");
            isSearchFinished = isSearchFinishedAndScanner(scanner, isSearchFinished);
        } while (!isSearchFinished);
        return audioBookList;
    }

    private boolean isSearchFinishedAndScanner(Scanner scanner, boolean isSearchFinished) {
        System.out.println("1 - Tak");
        System.out.println("2 - Nie");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                break;
            case "2":
                isSearchFinished = true;
                break;
            default:
                System.out.println("Wybierz 1 lub 2 !");
                scanner.nextLine();
        }
        return isSearchFinished;
    }
}

