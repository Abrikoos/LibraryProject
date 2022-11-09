package org.example;

import java.util.Scanner;

public class Menu {
    public int showOptions() {
        Scanner menuNumber = new Scanner(System.in);
        System.out.println("Please choose one of the options below:");
        System.out.println("Option 1: Register Book");
        System.out.println("Option 2: Search Book");
        System.out.println("Option 3: Show All Books");
        System.out.println("Option 4: Check Out Book");
        System.out.println("Option 5: Check In Book");
        System.out.println("Option 0: Exit Application");
        System.out.printf("Enter your number:\t");
       int menuChoice = menuNumber.nextInt();
       return menuChoice;
    }
}
