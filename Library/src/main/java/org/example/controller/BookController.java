package org.example.controller;

import org.example.domain.Book;

import java.util.Scanner;

public class BookController {

    public Book addBook(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter serial number of the book: ");
        int serialNumber = input.nextInt();
        input.nextLine();

        System.out.println("Enter book name: ");
        String bookTitle = input.nextLine();

        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        System.out.println("Enter Quantity of Books:");
       int bookQuantity = input.nextInt();
        int bookQuantityCopy = bookQuantity;
        return new Book(serialNumber, bookTitle, authorName, bookQuantity, bookQuantityCopy);
    }


}
