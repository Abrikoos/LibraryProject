package org.example;

import org.example.controller.BookController;

import java.util.Scanner;

public class Menu {
    private final DatabaseHelper dh = new DatabaseHelper();
   private final BookController bc = new BookController();

    public int showOptions() {
        Scanner menuNumber = new Scanner(System.in);
        System.out.println("""
                -------------------------------------------
                | Please choose one of the options below: |
                |                                         |
                | Option 1: Show All Books                |
                | Option 2: Check Out Book                |
                | Option 3: Check In Book                 |
                | Option 4: Administrator menu            |
                | Option 0: Exit Application              |
                -------------------------------------------
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

    public int adminMenu() {
        Scanner adminMenuNr = new Scanner(System.in);
        System.out.println("""
                -------------------------------------------
                | Please choose one of the options below: |
                |                                         |
                | Option 1: Register Book                 |
                | Option 2: Delete Book                   |
                | Option 3: Clear database                |
                -------------------------------------------
                Enter one of the given option numbers: 
                """);
        int adminChoice = adminMenuNr.nextInt();
        return adminChoice;
    }

    public void switchMenu() {
        int menuChoice;
        do {
            menuChoice = this.showOptions();
            switch (menuChoice) {
/*                // Search Book
                case 1:
                    break;*/
                // Show all books
                case 1:
                    bc.showDatabase();
                    break;
                // Check out book
                case 2:
                    bc.checkOutBook();
                    break;
                // Check in book
                case 3:
                    bc.checkInBook();
                    break;

                // Option 5: Administrator. Has option to register books, delete one book and clear the database.
                case 4:
                    int adminChoice;
                    adminChoice = this.adminMenu();
                    switch (adminChoice) {
                        case 1:
                            String answerYesNo = this.yesOrNo("\nDo you want to register a book?");
                            switch (answerYesNo) {
                                case "Y":
                                    BookController rb = new BookController();
                                    rb.persistBook(rb.registerBook());
                                    break;
                                case "N":
                                    adminMenu();
                                    break;
                            }
                        case 2:
                            answerYesNo = this.yesOrNo("\nDo you want to register a book?");
                            switch (answerYesNo) {
                                case "Y":
                                    BookController rb = new BookController();
                                    rb.persistBook(rb.registerBook());
                                    break;
                                case "N":
                                    adminMenu();
                                    break;
                            }
                        case 3:
                            answerYesNo = this.yesOrNo("\nWould you like to delete a book from the database?");
                            switch (answerYesNo) {
                                case "Y":
                                    dh.deleteBook();
                                case "N":
                                    answerYesNo = this.yesOrNo("\nWould you like to clear the book database?");
                                    switch (answerYesNo) {
                                        case "Y":
                                            dh.clearDatabase();
                                            dh.populateDatabase();
                                            break;
                                        case "N":
                                            System.out.println("\nPlease choose another option\n");
                                            break;
                                    }
                            }
                    }
                case 0:
                    return;

                default:
                    System.out.println("Please enter a number between 0 and 5. \n");
            }
        } while (menuChoice != 0);

        if (menuChoice == 0) {
            System.out.println("Goodbye! \n");
        }

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
