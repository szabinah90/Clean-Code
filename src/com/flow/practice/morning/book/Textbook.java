package com.flow.practice.morning.book;

public class Textbook extends Book {
    private String subject;

    // Constructors
    public Textbook(String title, String author, String publisher, int datePublished) {
        super(title, author, publisher, datePublished);
        subject = "Programming 1";
    }

    public Textbook(String title, String author, String publisher, int datePublished, String subject) {
        super(title, author, publisher, datePublished);
        this.subject = subject;
    }

    // Getters and setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Textbook: " + super.toString() + "; subject: " + subject;
    }
}
