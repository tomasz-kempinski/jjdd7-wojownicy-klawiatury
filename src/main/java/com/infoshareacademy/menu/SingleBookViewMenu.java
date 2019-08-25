package com.infoshareacademy.menu;


import static com.infoshareacademy.BookRepository.getBookRepository;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookList;
import com.infoshareacademy.BookSearchHandler;
import com.infoshareacademy.FavouriteBooks;
import com.infoshareacademy.ScreenCleaner;
import com.infoshareacademy.SingleBookView;
import java.util.List;
import java.util.Scanner;

public class SingleBookViewMenu {

  private ScreenCleaner screenCleaner = new ScreenCleaner();
  private BookList bookList = new BookList();
  private SingleBookView singleBookView = new SingleBookView();
  private List<Book> books = getBookRepository();

  public void selectBook() {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    int choice;
    long id=-1;
    System.out.println(" Podaj ID książki która chcesz wyświetlić");
    if (scanner.hasNextInt()) {
       long userId = scanner.nextInt();
      for (Book book : books) {
        if (userId == book.getId()) {
          id = userId;
          break;
        }
      }
        if (id!=-1 ) {
          screenCleaner.cleanScreen();
          singleBookView.singleBookView(id);
          System.out.println(" 1- Wyświetlenie innej książki    2- Powrót do Menu");
          System.out.println(" 3- Lista książek                 4- Wyszukiwanie książek");
          System.out.println(" 5- Dodaj książkę do ulubionych ");
          if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            switch (choice) {
              case 1:
                screenCleaner.cleanScreen();
                selectBook();
                break;
              case 2:
                screenCleaner.cleanScreen();
                menu.menu();
                break;
              case 3:
                screenCleaner.cleanScreen();
                bookList.listBooks();
                break;
              case 4:
                screenCleaner.cleanScreen();
                BookSearchHandler bookSearchHandler = new BookSearchHandler();
                bookSearchHandler.listFoundBooks();
                break;
              case 5:
                screenCleaner.cleanScreen();
                FavouriteBooks favouriteBooks = new FavouriteBooks();
                favouriteBooks.favouriteBooksAdd(id);
                System.out.println(" Książka dodana do ulubionych poprawnie ");
                menu.menu();
                break;
              default:
                screenCleaner.cleanScreen();
                System.out.println(" Podaj prawidłową wartość!");
                menu.menu();
                break;
            }
          } else {
            screenCleaner.cleanScreen();
            System.out.println(" Zła wartość- powrót do Menu ");
            menu.menu();
          }
      } else {
        screenCleaner.cleanScreen();
        System.out.println(" Podaj liczbę odpowiadającą ID książki!");
        System.out.println(" 1- Wyświetl listę książek 2- Wyszukaj książkę");
        System.out.println(" 3- Wpisz numer książki ponownie ");
        if (scanner.hasNextInt()) {
          choice = scanner.nextInt();
          switch (choice) {
            case 1:
              screenCleaner.cleanScreen();
              bookList.listBooks();
              break;
            case 2:
              screenCleaner.cleanScreen();
              BookSearchHandler bookSearchHandler = new BookSearchHandler();
              System.out.println(" Wyszukiwanie książek");
              bookSearchHandler.listFoundBooks();
              break;
            default:
              screenCleaner.cleanScreen();
              System.out.println(" Podaj prawidlowe dane! ");
              selectBook();
          }
        }
      }
    } else {
      screenCleaner.cleanScreen();
      System.out.println(" Podaj liczbę!");
      selectBook();
    }
  }
}


