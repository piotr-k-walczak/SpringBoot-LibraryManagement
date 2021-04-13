package com.ztw.books;

public interface IBooksService {

    public abstract Iterable<Book> getBooks();
    public abstract Book getBook(long id);
    public abstract void addBook(Book book);
    public abstract void updateBook(Book book);
    public abstract void deleteBook(long id);
    public abstract void assignAuthor(long bookId, long authorId);

    public abstract Iterable<Author> getAuthors();
    public abstract Author getAuthor(long id);
    public abstract void addAuthor(Author author);
    public abstract void updateAuthor(Author author);
    public abstract void deleteAuthor(long id);

    public abstract Iterable<User> getUsers();
    public abstract User getUser(long id);
    public abstract void addUser(User user);
    public abstract void updateUser(User user);
    public abstract void deleteUser(long id);

    public abstract void assignUser(long bookId, long userId);
    public abstract void freeBook(long bookId);
}