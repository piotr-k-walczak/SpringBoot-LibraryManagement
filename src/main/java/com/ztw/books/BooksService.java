package com.ztw.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService implements IBooksService {

    @Autowired private BookRepository bookRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private AuthorRepository authorRepository;

    @Override
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(long id){
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void addBook(Book book){
        if(!bookRepository.existsById(book.getId())){
            bookRepository.save(book);
        }
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.deleteById(book.getId());
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void assignAuthor(long bookId, long authorId) {
        Book book = getBook(bookId);
        book.setAuthor(getAuthor(authorId));
        bookRepository.save(book);
    }

    @Override
    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthor(long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Book> getAuthorBooks(long id) {
        return bookRepository.findByAuthorId(id);
    }

    @Override
    public void addAuthor(Author author) {
        if(!authorRepository.existsById(author.getId())){
            authorRepository.save(author);
        }
    }

    @Override
    public void updateAuthor(Author author) {
        authorRepository.deleteById(author.getId());
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Book> getUserBooks(long id) {
        return bookRepository.findByUserId(id);
    }

    @Override
    public void addUser(User user) {
        if(!userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(User user) {
        userRepository.deleteById(user.getId());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void assignUser(long bookId, long userId) {
        Book book = getBook(bookId);
        if (book != null){
            book.setUser(getUser(userId));
        }
        bookRepository.save(book);
    }

    @Override
    public void freeBook(long bookId) {
        Book book = getBook(bookId);
        book.setUser(null);
        bookRepository.save(book);
    }


}
