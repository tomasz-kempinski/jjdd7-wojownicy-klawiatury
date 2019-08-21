package com.infoshareacademy;


import java.io.IOException;

public class ScreenCleaner {

  public void cleanScreen() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (InterruptedException | IOException e) {
      System.out.println("Błąd systemu operacyjnego");
    }
  }
}
