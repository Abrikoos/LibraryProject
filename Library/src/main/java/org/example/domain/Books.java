package org.example.domain;

import java.util.Scanner;

public class Books{

    Book[] Books = new Book[100];
    public static int count;

    Scanner input = new Scanner(System.in);

    public int compareBookObjects(Book b1, Book b2){
        if (b1.bookTitle.equalsIgnoreCase(b2.bookTitle)){
            System.out.println("Book with this name already exists.");
            return 0;
        }
        if(b1.serialNumber == b2.serialNumber){
            System.out.println("Book with this serial number already exists.");
        return 0;
        }
        return 1;
    }

//    public void addBook(Book b){
//        for(int i=0; i < count; i++){
//            if(this.compareBookObjects(b, this.Books[i]) == 0)
//                return;
//        }
//        if(count<100){
//            Books[count] = b;
//            count ++;
//        }
//        else{
//            System.out.println("No space to add more books at this moment.");
//        }
//    }



}
