package com.mycompany.lab17;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class LibraryController {

    private Library model;
    private mainFrame view;

    public LibraryController(Library model, mainFrame view) {
        this.model = model;
        this.view = view;
    }

    //control model object
    public void setBookName(String title, int index) {
        model.getBooks().get(index).setTitle(title);
    }

    public String getBookName(int index) {
        return model.getBooks().get(index).getTitle();
    }

    public void setAuthorFName(String fname, int index) {
        model.getBooks().get(index).setAuthorFName(fname);
    }

    public String getAuthorFName(int index) {
        return model.getBooks().get(index).getAuthorFName();
    }

    public void setAuthorLName(String lname, int index) {
        model.getBooks().get(index).setAuthorLName(lname);
    }

    public String getAuthorLName(int index) {
        return model.getBooks().get(index).getAuthorLName();
    }

    public Library getLibraryModel() {
        return model;
    }

    public void setLibraryModel(Library model) {
        this.model = model;
    }

    public void setLibraryBooks(ArrayList<Book> books) {
        model.setBooks(books);
    }

    public ArrayList<Book> getLibraryBooks() {
        return (ArrayList<Book>) model.getBooks();
    }

    public void setView(mainFrame view) {
        this.view = view;
    }

    public void addBook(String fname, String lname, String title) {
        Book newBook = new Book(fname, lname, title);
        model.addBook(newBook);

    }

    public void updateBookTextArea(LibraryController libraryController) {
        StringBuilder booksDisplay = new StringBuilder();
        
        for (Book book : libraryController.getLibraryBooks()) {
            booksDisplay.append(book.toString());
            booksDisplay.append("\n"); // Add a newline to separate each book's information
        }

        String[] bookArray = booksDisplay.toString().split("\n");
        view.bookList.setListData(bookArray);
    }

}
