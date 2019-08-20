package com.infoshareacademy;

import java.io.FileNotFoundException;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    Parser parser = new Parser();
    parser.parseFileToObjects();
    ScreenCleaner screenCleaner = new ScreenCleaner();
    screenCleaner.cleanScreen();
    Menu menu = new Menu();
    menu.menu();
  }
}
