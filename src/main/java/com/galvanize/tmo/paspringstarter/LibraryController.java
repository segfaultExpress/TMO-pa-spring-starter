package com.galvanize.tmo.paspringstarter;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.tmo.paspringstarter.Book;

@RestController
public class LibraryController {

    public Library LibraryBooks = new Library();

    /**
     * Health check, used for checking api is up
     * 
     * @return "Hello world!"
     */
    @GetMapping("/health")
    public String health() {
        return "Hello World! v0.2";
    }


    /**
     * Returns the total number of books that have been created
     * 
     * @return A list of all books added
     */
    @GetMapping("/api/books")
    public Library getBooks() {
        return LibraryBooks;
    }

    /**
     * Creates a book given parameters for that book
     * @param Book The book to be added to the library
     * @return The same book object, with an additional unique identifier
     */
    @PostMapping(value = "/api/books", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
        newBook.id = getBookId();
        
        LibraryBooks.add(newBook);

        return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);
    }

    /**
     * Deletes all books in the library
     * 
     * @return Empty response
     */
    @DeleteMapping("/api/books")
    public ResponseEntity<HttpStatus> deleteBooks() {
        LibraryBooks.books.clear();
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    /**
     * Gets a unique ID for each book. For simplicity, we are just using the LibraryBooks array size
     * 
     * @return A unique id for a book object
     */
    public int getBookId() {
        return LibraryBooks.books.size() + 1;
    }
}
