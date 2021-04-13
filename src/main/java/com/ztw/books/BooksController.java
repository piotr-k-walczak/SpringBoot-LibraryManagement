package com.ztw.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {

    @Autowired IBooksService booksService;

    @GetMapping(value = "/get/books")
    public ResponseEntity<Object> getBooks(){
        return new ResponseEntity<>(booksService.getBooks(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/book/{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") int id){
        return new ResponseEntity<>(booksService.getBook(id), HttpStatus.OK);
    }

    @PostMapping(value = "/post/book")
    public ResponseEntity<Object> postBook(@RequestBody Book book){
        booksService.addBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/book/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") long id){
        booksService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/put/book")
    public ResponseEntity<Object> updateBook(@RequestBody Book book){
        booksService.updateBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/assign/book/{bookId}/author/{authorId}")
    public ResponseEntity<Object> assignBookToAuthor(@PathVariable("bookId") long bookId,
                                                     @PathVariable("authorId") long authorId){
        booksService.assignAuthor(bookId, authorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/assign/book/{bookId}/user/{userId}")
    public ResponseEntity<Object> assignBookToUser(@PathVariable("bookId") long bookId,
                                                     @PathVariable("userId") long userId){
        booksService.assignUser(bookId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/free/book/{bookId}")
    public ResponseEntity<Object> freeBook(@PathVariable("bookId") long bookId){
        booksService.freeBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/get/authors")
    public ResponseEntity<Object> getAuthors(){
        return new ResponseEntity<>(booksService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/author/{id}")
    public ResponseEntity<Object> getAuthor(@PathVariable("id") int id){
        return new ResponseEntity<>(booksService.getAuthor(id), HttpStatus.OK);
    }

    @PostMapping(value = "/post/author")
    public ResponseEntity<Object> postAuthor(@RequestBody Author author){
        booksService.addAuthor(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/author/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable("id") long id){
        booksService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/put/author/{id}")
    public ResponseEntity<Object> updateAuthor(@RequestBody Author author){
        booksService.updateAuthor(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/get/users")
    public ResponseEntity<Object> getUsers(){
        return new ResponseEntity<>(booksService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/user/{id}")
    public ResponseEntity<Object> getUsers(@PathVariable("id") int id){
        return new ResponseEntity<>(booksService.getUser(id), HttpStatus.OK);
    }

    @PostMapping(value = "/post/user")
    public ResponseEntity<Object> postUser(@RequestBody User user){
        booksService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") long id){
        booksService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/put/user/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user){
        booksService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
