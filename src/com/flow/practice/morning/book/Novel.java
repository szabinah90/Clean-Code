package com.flow.practice.morning.book;

public class Novel extends Book {
    String genre;
    static int novelCounter;

    public Novel(String title, String author, String publisher, int datePublished) {
        super(title, author, publisher, datePublished);
        genre = "Young adult";
        novelCounter++;
    }

    public Novel(String title, String author, String publisher, int datePublished, String genre) {
        super(title, author, publisher, datePublished);
        this.genre = genre;
        novelCounter++;
    }

    // Getters and setters
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static int getNovelCounter() {
        return novelCounter;
    }

    @Override
    public String toString() {
        return "Novel: " + super.toString() + "; genre: " + genre;
    }
}
