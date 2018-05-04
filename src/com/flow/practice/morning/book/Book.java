package com.flow.practice.morning.book;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int datePublished;

    // Constructors

    public Book() {
        title = "Object Orinted Planning and Programming";
        author = "Angster Erzsébet";
        publisher = "Kiskapu";
        datePublished = 2001;

    }

    public Book(String title, String author, String publisher, int datePublished) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.datePublished = datePublished;
    }

    // Getters and setters
    protected final String getTitle() {
        return title;
    }

    protected final void setTitle(String title) {
        this.title = title;
    }

    protected final String getAuthor() {
        return author;
    }

    protected final void setAuthor(String author) {
        this.author = author;
    }

    protected final String getPublisher() {
        return publisher;
    }

    protected final void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected final int getDatePublished() {
        return datePublished;
    }

    protected final void setDatePublished(int datePublished) {
        this.datePublished = datePublished;
    }

    @Override
    public String toString() {
        return "title: " + title + "; author: " + author + "; publisher: " + publisher + "; date published: " +
                datePublished;
    }
}
