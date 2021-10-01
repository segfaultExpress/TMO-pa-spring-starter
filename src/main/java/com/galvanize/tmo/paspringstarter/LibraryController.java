package com.galvanize.tmo.paspringstarter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.galvanize.tmo.paspringstarter.Book;

@RestController
public class LibraryController {

    public List<Book> LibraryBooks = new ArrayList<Book>();

    /**
     * Health check, used for checking api is up
     * 
     * @return "Hello world!"
     */
    @GetMapping("/health")
    public String health() {
        return "Hello World!";
    }


    /**
     * Returns the total number of books that have been created
     * 
     * @return A list of all books added
     */
    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return LibraryBooks;
    }

    /**
     * Creates a book given parameters for that book
     * @param Book The book to be added to the library
     * @return The same book object, with an additional unique identifier
     */
    @PostMapping("/api/books")
    public Book createBook(@RequestBody Book newBook) {
        newBook.id = getBookId();
        
        LibraryBooks.add(newBook);

        return newBook;
    }

    /**
     * Deletes all books in the library
     * 
     * @return Empty response
     */
    @DeleteMapping("/api/books")
    public ResponseEntity<HttpStatus> deleteBooks() {
        LibraryBooks.clear();
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    /**
     * Gets a unique ID for each book. For simplicity, we are just using the LibraryBooks array size
     * 
     * @return A unique id for a book object
     */
    public int getBookId() {
        return LibraryBooks.size() + 1;
    }
}
