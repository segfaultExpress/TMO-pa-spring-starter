package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
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
}