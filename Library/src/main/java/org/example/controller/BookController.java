package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.DatabaseHelper;
import org.example.domain.Menu;
import org.example.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookController {
    String persistenceUnitName = "jpa-hiber-postgres-pu";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    private final DatabaseHelper dh = new DatabaseHelper();
    private final Menu menu;

    public BookController(Menu m) {
        this.menu = m;
    }

    private final Scanner scanner = new Scanner(System.in);

    public Book registerBook() {


        System.out.println("Enter book name: ");
        String bookTitle = scanner.nextLine();

        System.out.println("Enter Author Name:");
        String authorName = scanner.nextLine();

        System.out.println("Enter Quantity of Books:");
        int bookQuantity = scanner.nextInt();
        return new Book(bookTitle, authorName, bookQuantity);
    }

    public void persistBook(Book b) {
        tx.begin();
        em.persist(b);
        tx.commit();
    }

    public List<Book> getBooks() {
        String sqlQuery = ("SELECT b FROM Book b ORDER BY serialNumber");
        return em.createQuery(sqlQuery).getResultList();
    }

    public void showDatabase() {
        List<Book> books = getBooks();
        dh.printLibrary(books);
    }

    public void checkOutBook() {
        boolean checkOutAnother = true;
        List<Book> books = new ArrayList<>();
        while (checkOutAnother) {
            System.out.println("Give the serial number of your book: ");
            long serialNumber = scanner.nextLong();
            String sqlQuery = "SELECT b FROM Book b";
            Book b = em.find(Book.class, serialNumber);
            b.setBookQuantity(b.getBookQuantity() - 1);
            books.add(b);
            String response = menu.yesOrNo("Do you want to check out another book?");
            if (response.equals("N")) {
                checkOutAnother = false;
            }
        }
        tx.begin();
        for (Book b : books) {
            em.persist(b);
        }
        tx.commit();

    }

    public void checkInBook() {
        boolean checkOutAnother = true;
        List<Book> books = new ArrayList<>();
        while (checkOutAnother) {
            System.out.println("Give the serial number of your book: ");
            long serialNumber = scanner.nextLong();
            String sqlQuery = "SELECT b FROM Book b";
            Book b = em.find(Book.class, serialNumber);
            b.setBookQuantity(b.getBookQuantity() + 1);
            books.add(b);
            String response = menu.yesOrNo("Do you want to check in another book?");
            if (response.equals("N")) {
                checkOutAnother = false;
            }
        }
        tx.begin();
        for (Book b : books) {
            em.persist(b);
        }
        tx.commit();
    }
}
