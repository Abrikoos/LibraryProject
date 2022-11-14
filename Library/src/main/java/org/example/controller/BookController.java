package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.DatabaseHelper;
import org.example.domain.Book;

import java.util.List;
import java.util.Scanner;

public class BookController {
    String persistenceUnitName = "jpa-hiber-postgres-pu";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

   DatabaseHelper dh = new DatabaseHelper();

    public Book registerBook() {
        Scanner input = new Scanner(System.in);

//        System.out.println("Enter serial number of the book: ");
//        int serialNumber = input.nextInt();
//        input.nextLine();

        System.out.println("Enter book name: ");
        String bookTitle = input.nextLine();

        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        int bookQuantity = input.nextInt();
        return new Book(bookTitle, authorName, bookQuantity);
    }

    public void persistBook(Book b) {
        tx.begin();
        em.persist(b);
        tx.commit();
    }

public List<Book> getBooks(){
        String sqlQuery = ("SELECT b FROM Book b");
        return em.createQuery(sqlQuery).getResultList();
}
    public void showDatabase() {
        List<Book> books = getBooks();
        dh.printLibrary(books);
    }
}
