package org.example;

import org.example.controller.RegisterBookController;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        DatabaseHelper dh = new DatabaseHelper();
        dh.populateDatabase();
        int menuChoice;
        do {
            menuChoice = menu.showOptions();
            switch (menuChoice) {
                // Search Book
                case 1:
                    break;
                // Show all books
                case 2:
                    break;
                // Check out book
                case 3:
                    break;
                // Check in book
                case 4:
                    break;

                // Option 5: Administrator. Has option to register books, delete one book and clear the database.
                case 5:
                    String answerYesNo = menu.yesOrNo("Do you want to register a book?");
                    switch (answerYesNo) {
                        case "Y":
                            RegisterBookController rb = new RegisterBookController();
                            rb.persistBook(rb.registerBook());
                            break;
                        case "N":
                            answerYesNo = menu.yesOrNo("Would you like to delete a book from the database?");
                            switch (answerYesNo){
                                case "Y":
                                    dh.deleteBook();
                                case "N":
                                answerYesNo = menu.yesOrNo("Would you like to clear the book database?");
                                switch (answerYesNo) {
                                    case "Y":
                                        dh.clearDatabase();
                                        dh.populateDatabase();
                                        break;
                                    case "N":
                                        System.out.println("Please choose another option\n");
                                        break;
                                }
                            }

                    }
                case 0:
                    break;

                default:
                    System.out.println("Please enter a number between 0 and 5. \n");
            }
        } while (menuChoice != 0);

        if(menuChoice == 0){
            System.out.println("Goodbye! \n");
        }
    }
}