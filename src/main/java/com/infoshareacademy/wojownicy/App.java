package com.infoshareacademy.wojownicy;

import com.infoshareacademy.wojownicy.menu.Menu;
import com.infoshareacademy.wojownicy.service.BookParseService;
import com.infoshareacademy.wojownicy.service.ScreenCleaner;

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
