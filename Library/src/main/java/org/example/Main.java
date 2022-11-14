package org.example;


public class Main {

    private static final DatabaseHelper dh = new DatabaseHelper();
    private static final Menu menu = new Menu();

    public static void main(String[] args) {

        dh.populateDatabase();
        menu.switchMenu();
    }
}