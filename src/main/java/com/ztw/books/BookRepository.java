package com.ztw.books;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByUserId(Long userId);
}
