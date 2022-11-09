package org.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Scanner;

@Entity
public class Book {
    @Id
    public int serialNumber;
    public String bookTitle;
    public String authorName;
    public int bookQuantity;
    public int bookQuantityCopy;

    public Book(int serialNumber, String bookName, String authorName, int bookQuantity, int bookQuantityCopy) {
        this.serialNumber = serialNumber;
        this.bookTitle = bookName;
        this.authorName = authorName;
        this.bookQuantity = bookQuantity;
        this.bookQuantityCopy = bookQuantityCopy;
    }

    public Book(int serialNumber, String bookName, String authorName) {
    }

    public Book(String authorName, String bookTitle) {
    }

    public Book() {

    }
}
