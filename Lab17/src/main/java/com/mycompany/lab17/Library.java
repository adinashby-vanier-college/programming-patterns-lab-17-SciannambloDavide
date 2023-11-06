package com.mycompany.lab17;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private static Library libraryObject;
    private List<Book> books;
    private List<LibraryObserver> observers;

    private Library() {
        books = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Library getInstance() {
        if (libraryObject == null) {
            libraryObject = new Library();
        }
        return libraryObject;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
        notifyBookRemoved(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void registerObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(LibraryObserver observer) {
        observers.remove(observer);
    }


    private void notifyBookRemoved(Book book) {
        for (LibraryObserver observer : observers) {
            observer.updateBookRemoved(book);
        }
    }

    public static Library getLibraryObject() {
        return libraryObject;
    }

    public static void setLibraryObject(Library libraryObject) {
        Library.libraryObject = libraryObject;
    }

    public List<LibraryObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<LibraryObserver> observers) {
        this.observers = observers;
    }

    void setBooks(ArrayList<Book> books) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

      
}
