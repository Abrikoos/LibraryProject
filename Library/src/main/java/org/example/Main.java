package org.example;

import org.example.controller.RegisterBookController;
import org.example.domain.Books;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        int menuChoice;
        do {
            menuChoice = menu.showOptions();
            switch (menuChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                    // Option 6: Administrator. Has option to register books and clear the database/
                case 6:
                    RegisterBookController rb = new RegisterBookController();
                    rb.persistBook(rb.registerBook());
                    break;
                case 0:
                    break;

            }

        } while (menuChoice != 0);


    }
}