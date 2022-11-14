package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.domain.Book;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class DatabaseHelper {
    String persistenceUnitName = "jpa-hiber-postgres-pu";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public void populateDatabase() {
        String persistenceUnitName = "jpa-hiber-postgres-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(new Book("Gebroeders Leeuwenhart", "Astrid Lindgren", 5));
        em.persist(new Book("De Brief voor de Koning", "Tonke Dragt", 6));
        em.persist(new Book("Koning van Katoren", "Jan Terlouw", 7));
        tx.commit();
    }

    public void printLibrary(List<Book> books) {
        int columnSizeBookTitle = getColumnSize("Book title");
        int columnSizeAuthor = getColumnSize("Author");
        int columnSizeQuantity = getColumnSize("Quantity");
        int totalSize = 17 + columnSizeBookTitle + columnSizeAuthor + columnSizeQuantity;

        System.out.println("=".repeat(Math.max(0, totalSize)));
        String secondLineSectionOne = " ".repeat(Math.max(0, (totalSize - 14) / 2));
        if (totalSize % 2 != 0) {
            String secondLineSectionTwo = " ".repeat(Math.max(0, (totalSize - 14) / 2) + 1);
            System.out.println("|" + secondLineSectionOne + "List - Books" + secondLineSectionTwo + "|");
        } else {
            System.out.println("|" + secondLineSectionOne + "List - Books" + secondLineSectionOne + "|");
        }
        System.out.println("+" + "-".repeat((Math.max(0, totalSize - 2))) + "+");

        String fourthLineBookTitleSectionOne = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2));
        String fourthLineBookTitleSectionTwo = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2));
        if (columnSizeBookTitle % 2 != 0) {
            fourthLineBookTitleSectionTwo = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2) + 1);
        }

        String fourthLineAuthorSectionOne = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2));
        String fourthLineAuthorSectionTwo = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2));
        if (columnSizeAuthor % 2 != 0) {
            fourthLineAuthorSectionTwo = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2) + 1);
        }
        String fourthLineQuantitySectionOne = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2));
        String fourthLineQuantitySectionTwo = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2));

        if (columnSizeQuantity % 2 != 0) {
            fourthLineQuantitySectionTwo = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2) + 1);
        }
        System.out.println("|  ID  |" + fourthLineBookTitleSectionOne + "Book title" + fourthLineBookTitleSectionTwo + "|"
                + fourthLineAuthorSectionOne + "Author" + fourthLineAuthorSectionTwo + "|"
                + fourthLineQuantitySectionOne + "Quantity" + fourthLineQuantitySectionTwo + "|");
        System.out.println("+" + "=".repeat((Math.max(0, totalSize - 2))) + "+");

        for (Book book : books) {
            long serialNumber = book.getSerialNumber();
            String bookTitle = book.getBookTitle();
            String authorName = book.getAuthorName();
            int bookQuantity = book.getBookQuantity();

            System.out.println("| " + " ".repeat(Math.max(0, 4 - Integer.toString((int) serialNumber).length()))
                    + serialNumber + " | " + bookTitle + " ".repeat(Math.max(0, (columnSizeBookTitle - bookTitle.length()))) + " | "
                    + authorName + " ".repeat(Math.max(0, (columnSizeAuthor - authorName.length()))) + " | "
                    + bookQuantity + " ".repeat(Math.max(0, (columnSizeQuantity - Integer.toString(bookQuantity).length()))) + " |");

        }
        System.out.println("=".repeat(Math.max(0, totalSize)));
    }

    private int getColumnSize(String columnName) throws RuntimeException {
        String sqlQuery = "";
        switch (columnName) {
            case "Book title":
                sqlQuery = "SELECT bookTitle FROM Book b";
                break;
            case "Author":
                sqlQuery = "SELECT authorName FROM Book b";
                break;
            case "Quantity":
                sqlQuery = "SELECT bookQuantity FROM Book b";
                break;
            default:
                throw new RuntimeException("Invalid.");
        }
        ;

        List column = em.createQuery(sqlQuery).getResultList();
        int size = 0;
        for (int i = 0; i < column.size(); i++) {
            int tempValue = column.get(i).toString().length();
            if (tempValue > size) {
                size = tempValue;
            }
        }
        if (columnName.length() > size) {
            return columnName.length();
        } else {
            return size;
        }
    }

    public void clearDatabase() {
        String sqlQuery = "DELETE Book";
        tx.begin();
        em.createQuery(sqlQuery).executeUpdate();
        tx.commit();
    }

    public void deleteBook() {
        Scanner serialNrInput = new Scanner(System.in);
        System.out.println("Please type the serial number of the to be deleted book: ");
        long inputSerialNr = serialNrInput.nextLong();
        String sqlQuery = "DELETE FROM Book WHERE serialNumber = " + inputSerialNr;
        tx.begin();
        em.createQuery(sqlQuery).executeUpdate();
        tx.commit();
        System.out.println("Book with serial number: ' " + inputSerialNr + " ' has been removed from library.");
    }

    //drop methode


    public int compareBookObjects(Book b1, Book b2) {
        if (b1.bookTitle.equalsIgnoreCase(b2.bookTitle)) {
            System.out.println("Book with this name already exists.");
            return 0;
        }
        if (b1.serialNumber == b2.serialNumber) {
            System.out.println("Book with this serial number already exists.");
            return 0;
        }
        return 1;
    }
}
