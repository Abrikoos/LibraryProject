package org.example.daos;

import org.example.domain.Book;

import java.util.List;

public interface BookDaoServiceContract {

    void save(Book book);

    void update(Book book);

    void remove(Book book);

    Book getBookById(Long id);

    List<Book> getBooksByBookTitle(String Title);

    List<Book> getBooksByAuthorName(String authorName);
}
