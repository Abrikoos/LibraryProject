package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPATests {
    private static final Logger logger = LoggerFactory.getLogger(JPATests.class);
    private EntityTransaction tx;
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    @Test
    void setUp() {
        String persistenceUnitName = "jpa-hiber-postgres-pu";
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @Test
    void persistBookWithoutAtGeneratedValue() {
        logger.info("start persistBookWithoutAtGeneratedValue");
        tx.begin();
        em.persist(new Book( "John Scofield", "Surviving in the Java Logging Hell"));
        tx.commit();

        // abbreviated in here is your working code
        logger.info("finish persistBookWithoutAtGeneratedValue");
    }


}
