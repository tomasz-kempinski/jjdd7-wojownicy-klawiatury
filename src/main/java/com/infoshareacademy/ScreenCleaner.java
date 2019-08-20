package com.infoshareacademy;

import java.io.IOException;

public class ScreenCleaner {
    public void screenClean(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }catch (IOException e){
            System.out.println("Błąd systemu operacyjnego");
        }
    }
}
