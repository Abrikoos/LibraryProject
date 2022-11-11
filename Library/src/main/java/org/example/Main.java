package org.example;

import org.example.controller.RegisterBookController;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        DatabaseHelper dh = new DatabaseHelper();
        dh.populateDatabase();
        menu.switchMenu();

    }
}