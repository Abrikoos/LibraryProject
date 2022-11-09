package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JPATest {
    String persistenceUnitName = "jpa-hiber-postgres-pu";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    EntityManager em = emf.createEntityManager();


    @Test
    @DisplayName("Select all the entities of type Book")
    void selectBookTitleFromJPQLQuery() {
        var queryString = "SELECT b.bookTitle FROM Book b";
        var jpqlQuery = em.createQuery(queryString, String.class);
        var titles = jpqlQuery.getResultList();

        assertThat(titles).containsExactly("Surviving in the Java Logging Hell",
                "Enjoying living in the Java Logging Heaven","Living in the Java Logging World");
    }

    @Test
    @DisplayName("Select all the entities of type Book")
    void selectFavoriteTitleFromJPQLQuery() {
        addBooksToTable();

        var queryString = "SELECT b.bookTitle FROM Book b WHERE b.bookTitle=''";
        var jpqlQuery = em.createQuery(queryString, String.class);
        var books = jpqlQuery.getResultList();
        var titles = jpqlQuery.getResultList();

        assertThat(titles).isEqualTo("Surviving in the Java Logging Hell");
    }

    @Test
    @DisplayName("Select all the entities of type Book")
    void createJPQLQueryOnEntityBook() {

        addBooksToTable();

        var queryString = "SELECT b FROM Book b";
        var jpqlQuery = em.createQuery(queryString, Book.class);
        var books = jpqlQuery.getResultList();
        var numberOfBooksRetrieved = books.size();

        assertThat(numberOfBooksRetrieved).isEqualTo(books.size());
    }

    private void addBooksToTable() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(new Book(1, "John", "Surviving in the Java Logging Hell"));
        em.persist(new Book(2, "Jack", "Enjoying living in the Java Logging Heaven"));
        em.persist(new Book(3, "Jane", "Living in the Java Logging World"));
        tx.commit();
    }

}
