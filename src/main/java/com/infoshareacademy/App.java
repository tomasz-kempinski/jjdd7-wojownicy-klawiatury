package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.repository.BookRepository;
import java.io.FileNotFoundException;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    Parser parser = new Parser();
    parser.parseFileToObjects();
    new ScreenCleaner().cleanScreen();
    Menu menu = new Menu();
    menu.menu();
  }
}
