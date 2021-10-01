package com.galvanize.tmo.paspringstarter;

public class Book {
    public int id;
    public String author;
    public String title;
    public int yearPublished;

    /**
     * Constructor for Book object, we just assume id, author, title, etc are valid
     * 
     * @return New Book object
     */
    public Book(int id, String name, String title, int yearPublished) {
        this.id = id;
        this.author = name;
        this.title = title;
        this.yearPublished = yearPublished;
    }
}