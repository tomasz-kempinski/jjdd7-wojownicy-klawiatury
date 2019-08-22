package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;

import java.io.FileNotFoundException;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    new ScreenCleaner().cleanScreen();
    Menu menu = new Menu();
    menu.menu();
  }
}
