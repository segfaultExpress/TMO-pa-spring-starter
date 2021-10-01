package com.galvanize.tmo.paspringstarter;

public class Book {
    public int id;
    private String name;
    private String title;
    private String yearPublished;

    public Book(int id, String name, String title, String yearPublished) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.yearPublished = yearPublished;
    }
}