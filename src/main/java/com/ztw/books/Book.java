package com.ztw.books;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    @Id private long id;
    @Column private String title;
    @Column private int pages;

    @ManyToOne
    @JoinColumn(name = "fk_author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    public Book() {}

    public Book(long id, String title, Author author, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}