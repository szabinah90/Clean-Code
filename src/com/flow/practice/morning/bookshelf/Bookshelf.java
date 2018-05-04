package com.flow.practice.morning.bookshelf;

import com.flow.practice.morning.book.*;
import java.util.ArrayList;

public class Bookshelf {

    static ArrayList<Book> myBookshelf = new ArrayList<Book>();

    // Regeny Egri_csillagok,Gárdonyi_Géza,Móra,1901 Tankonyv Kalkulus1,Toth_Istvan,Tankönyv_kiadó,1997 Regeny Alas_Babylon,Pat_Frank,Lippincott,1959,Post-apocalyptic

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("Regeny")) {
                String[] bookProperties = args[i + 1].split(",");

                // title
                String[] title = bookProperties[0].split("_");
                String titleString = "";
                for (int j = 0; j < title.length; j++) {
                    titleString += title[j] + " ";
                }
                titleString = titleString.trim();

                // author
                String[] author = bookProperties[1].split("_");
                String authorString = "";
                for (int k = 0; k < author.length; k++) {
                    authorString += author[k] + " ";
                }
                authorString = authorString.trim();

                // publisher
                String[] publisher = bookProperties[2].split("_");
                String publisherString = "";
                for (int l = 0; l < publisher.length; l++) {
                    publisherString += publisher[l] + " ";
                }
                publisherString = publisherString.trim();

                // date
                int datePub = Integer.parseInt(bookProperties[3]);

                if (bookProperties.length == 5) {
                    // genre, if custom
                    String[] genre = bookProperties[4].split("_");
                    String genreString = "";
                    for (int m = 0; m < genre.length; m++) {
                        genreString += genre[m] + " ";
                    }
                    genreString = genreString.trim();

                    Novel novel = new Novel(titleString, authorString, publisherString, datePub, genreString);
                    putOnBookshelf(myBookshelf, novel);
                } else {
                    Novel novel = new Novel(titleString, authorString, publisherString, datePub);
                    putOnBookshelf(myBookshelf, novel);
                }
                i += 1;
            }
            if (args[i].equals("Tankonyv")) {
                String[] bookProperties = args[i + 1].split(",");

                // title
                String[] title = bookProperties[0].split("_");
                String titleString = "";
                for (int j = 0; j < title.length; j++) {
                    titleString += title[j] + " ";
                }
                titleString = titleString.trim();

                // author
                String[] author = bookProperties[1].split("_");
                String authorString = "";
                for (int k = 0; k < author.length; k++) {
                    authorString += author[k] + " ";
                }
                authorString = authorString.trim();

                // publisher
                String[] publisher = bookProperties[2].split("_");
                String publisherString = "";
                for (int l = 0; l < publisher.length; l++) {
                    publisherString += publisher[l] + " ";
                }
                publisherString = publisherString.trim();

                int datePub = Integer.parseInt(bookProperties[3]);

                if (bookProperties.length == 5) {
                    // genre, if custom
                    String[] subject = bookProperties[4].split("_");
                    String subjectString = "";
                    for (int m = 0; m < subject.length; m++) {
                        subjectString += subject[m] + " ";
                    }
                    subjectString = subjectString.trim();
                    Textbook textbook = new Textbook(titleString, authorString, publisherString, datePub, subjectString);
                    putOnBookshelf(myBookshelf, textbook);
                } else {
                    Textbook textbook = new Textbook(titleString, authorString, publisherString, datePub);
                    putOnBookshelf(myBookshelf, textbook);
                }
                i += 1;
            }
        }

        for (int i = 0; i < myBookshelf.size(); i ++) {
            System.out.println(myBookshelf.get(i));
        }
        System.out.println("Number of novels on the shelf: " + Novel.getNovelCounter());

    }

    public static ArrayList<Book> putOnBookshelf(ArrayList<Book> bookshelf, Book book) {
        bookshelf.add(book);
        return bookshelf;
    }
}