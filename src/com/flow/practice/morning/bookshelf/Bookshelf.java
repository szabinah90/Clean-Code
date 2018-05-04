package com.flow.practice.morning.bookshelf;

import com.flow.practice.morning.book.*;
import java.util.ArrayList;
import java.util.HashMap;

// Novel Egri_csillagok,Gárdonyi_Géza,Móra,1901 Textbook Kalkulus1,Toth_Istvan,Tankönyv_kiadó,1997 Novel Alas_Babylon,Pat_Frank,Lippincott,1959,Post-apocalyptic

public class Bookshelf {

    private String[] arguments;
    private ArrayList<Book> myBookshelf = new ArrayList<>();
    private int iterator = 0;

    private void setArguments(String[] array) {
        arguments = array;
    }

    private boolean isTextbook() {
        return arguments[iterator].equals("Textbook");
    }

    private boolean isNovel() {
        return arguments[iterator].equals("Novel");
    }

    private boolean hasParameters() {
        return (!(arguments[iterator + 1]).equals("Novel") || arguments[iterator + 1].equals("Textbook"));
    }

    private boolean has5thParameter() {
        return (arguments[iterator].split(",").length == 5);
    }

    private String[] prepareArguments() {
        return arguments[iterator + 1].split(",");
    }

    private HashMap<String, Object> getOptions() {
        HashMap<String, Object> options = new HashMap<>();
        String[] properties = prepareArguments();

        options.put("title", gettingTitle(properties[0]));
        options.put("author", gettingAuthor(properties[1]));
        options.put("publisher", gettingPublisher(properties[2]));
        options.put("date", gettingDate(properties[3]));

        if (isTextbook() && has5thParameter()) {
            options.put("subject", getting5thParameter(properties[4]));
        } else if (isNovel() && has5thParameter()) {
            options.put("genre", getting5thParameter(properties[4]));
        }

        return options;
    }

    private String gettingTitle(String titleString) {
        return removeUnderline(titleString);
    }

    private String gettingAuthor(String authorString) {
        return removeUnderline(authorString);
    }

    private String gettingPublisher(String publisherString) {
        return removeUnderline(publisherString);
    }

    private int gettingDate (String dateString) {
        return Integer.parseInt(dateString);
    }

    private String getting5thParameter(String paramString) {
        return removeUnderline(paramString);
    }

    private String removeUnderline(String paramString) {
       return paramString = paramString.replace("_", " ");
    }


    private void createDefaultBook() {
        myBookshelf.add(new Book());
        iterator += 1;
    }

    private void createTextbook() {
        HashMap<String, Object> options = getOptions();
        if (has5thParameter()) {
          myBookshelf.add(new Textbook((String) options.get("title"), (String) options.get("author"), (String) options.get("publisher"),
                  (int) options.get("date"), (String) options.get("subject")));
        } else {
         myBookshelf.add(new Textbook((String) options.get("title"), (String) options.get("author"), (String) options.get("publisher"),
                 (int) options.get("date")));
        }
        iterator += 2;
    }

    private void createNovel() {
        HashMap<String, Object> options = getOptions();
        if (has5thParameter()) {
            myBookshelf.add(new Novel((String) options.get("title"), (String) options.get("author"), (String) options.get("publisher"),
                    (int) options.get("date"), (String) options.get("genre")));
        } else {
            myBookshelf.add(new Novel((String) options.get("title"), (String) options.get("author"), (String) options.get("publisher"),
                    (int) options.get("date")));
        }
        iterator += 2;
    }

    private void createSpecificBook() {
        if (isTextbook()) {
            createTextbook();
        }
        else {
            createNovel();
        }
    }

    private void createBook() {
        if (hasParameters()) {
            createSpecificBook();
        } else {
          createDefaultBook();
        }
    }

    public void iterate() {
        while (iterator < arguments.length) {
            createBook();
        }
    }

    public static void main(String[] args) {

        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setArguments(args);
        bookshelf.iterate();


        for (Book book : bookshelf.myBookshelf) {
            System.out.println(book);
        }
    }
}