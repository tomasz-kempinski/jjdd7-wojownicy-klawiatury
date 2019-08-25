package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;

public class App {

  public static void main(String[] args) {
    BookParseService bookParseService = new BookParseService();
    bookParseService.parseFileToObjects();
    new ScreenCleaner().cleanScreen();
    Menu menu = new Menu();
    menu.menu();
    bookParseService.saveObjectsToFile();
  }
}
