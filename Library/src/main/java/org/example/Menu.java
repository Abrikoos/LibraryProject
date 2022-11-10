package org.example;

import java.util.Scanner;

public class Menu {
    public int showOptions() {
        Scanner menuNumber = new Scanner(System.in);
        System.out.println("""
                Please choose one of the options below: \n
                Option 1: Search Book
                Option 2: Show All Books
                Option 3: Check Out Book
                Option 4: Check In Book
                Option 5: Administrator menu
                Option 0: Exit Application
                Enter your number: 
                """);
//        System.out.println("Please choose one of the options below:");
//        System.out.println("Option 1: Search Book");
//        System.out.println("Option 2: Show All Books");
//        System.out.println("Option 3: Check Out Book");
//        System.out.println("Option 4: Check In Book");
//        System.out.println("Option 5: Administrator");
//        System.out.println("Option 0: Exit Application");
//        System.out.printf("Enter your number:\t");
        int menuChoice = menuNumber.nextInt();
        return menuChoice;
    }

    public String yesOrNo(String string) {
        System.out.println(string);
        Scanner yesOrNoInput = new Scanner(System.in);
        System.out.println("""                             
                                    Press 'Y' for 'yes'.
                                    Press 'N' for 'no'.
                                    """);
        String yesOrNoAnswer = yesOrNoInput.nextLine().toUpperCase();
        if (!yesOrNoAnswer.equals("Y") && !yesOrNoAnswer.equals("N")) {
            System.out.println("Please try again.");
            yesOrNo(string);
        }
        return yesOrNoAnswer;
    }
}
