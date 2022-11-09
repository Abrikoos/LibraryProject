package org.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Scanner;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long serialNumber;
    public String bookTitle;
    public String authorName;
    public int bookQuantity;
    public int bookQuantityCopy;

    public Book(long serialNumber, String bookName, String authorName, int bookQuantity, int bookQuantityCopy) {
        this.serialNumber = serialNumber;
        this.bookTitle = bookName;
        this.authorName = authorName;
        this.bookQuantity = bookQuantity;
        this.bookQuantityCopy = bookQuantityCopy;
    }

    public Book(String bookName, String authorName, int bookQuantity, int bookQuantityCopy) {
        this.serialNumber = serialNumber;
        this.bookTitle = bookName;
        this.authorName = authorName;
        this.bookQuantity = bookQuantity;
        this.bookQuantityCopy = bookQuantityCopy;
    }
    public Book(long serialNumber, String bookName, String authorName) {
        this.serialNumber = serialNumber;
        this.bookTitle = bookName;
        this.authorName = authorName;
    }

    public Book(String authorTitle, String bookTitle) {
        this.bookTitle = bookTitle;
        this.authorName = authorTitle;
    }

    public Book() {

    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getBookQuantityCopy() {
        return bookQuantityCopy;
    }

    public void setBookQuantityCopy(int bookQuantityCopy) {
        this.bookQuantityCopy = bookQuantityCopy;
    }
}
