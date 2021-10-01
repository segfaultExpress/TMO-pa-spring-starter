package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
    public List<Book> books;

    /**
     * Constructor for Library object, it is just a wrapper for now and so is very empty
     * 
     * @return New Library object
     */
    public Library() {
        books = new ArrayList<Book>();
    }

    /**
     * Add a book to a library and sort in alphabetical order (by title)
     */
    public void add(Book book) {
        books.add(book);

        Collections.sort(books, new BookComparator());
    }

    /**
     * Compare books to each other to assist sorting
     */
    class BookComparator implements Comparator<Book> {
        public final int compare(Book b1, Book b2) {
            return b1.title.compareTo(b2.title);
        }
    }
}