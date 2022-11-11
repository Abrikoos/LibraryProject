package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.domain.Book;

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

    public void showDatabase(){

    }

    public void clearDatabase(){
        String sqlQuery = "DELETE Book";
        tx.begin();
        em.createQuery(sqlQuery).executeUpdate();
        tx.commit();
    }

    public void deleteBook(){
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
}
