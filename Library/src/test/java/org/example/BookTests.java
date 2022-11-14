package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.controller.BookController;
import org.example.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTests {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hiber-postgres-pu");
    private EntityManager em = emf.createEntityManager();
    private BookController rbc = new BookController();
    private EntityTransaction tx = em.getTransaction();

    @BeforeEach
    @Test
    void setUp() {
        DatabaseHelper dh = new DatabaseHelper();
//        dh.clearDatabase();
        dh.populateDatabase();
    }

    @Test
    void registerBookTest(){
        Book b = rbc.registerBook();
        assertThat(b.getBookTitle()).isEqualTo("ASD");
        assertThat(b.getBookQuantity()).isEqualTo("ASD");
        assertThat(b.getAuthorName()).isEqualTo("ASD");
    }

    @Test
    void persistBookTest(){
        Book b = new Book("ADS", "Jan",20);
        rbc.persistBook(b);
      String sqlQuery = "SELECT b FROM Book b WHERE serialNumber = 2";
      Book bk = (Book) em.createQuery(sqlQuery).getSingleResult();
      assertThat(b.getBookTitle()).isEqualTo("ADS");
        assertThat(b.getAuthorName()).isEqualTo("Jan");

    }
}