package com.infoshareacademy;

import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    Parser parser = new Parser();
    parser.parseFileToObjects();
    Menu menu = new Menu();
    menu.menu();
  }
}
