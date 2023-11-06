/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab17;

/**
 *
 * @author 2276744
 */
public class Lab17 {

    public static void main(String[] args) {
        try {
            DatabaseManager.initialize();

//            Book book = new Book("Robert", "Munsch", "Smelly Socks");
//            Book book2 = new Book("Harper", "Lee", "To Kill a MockingBird");
//            Book book3 = new Book("Markus", "Zusak", "The Book Thief");
//            Book book4 = new Book("George", "Orwell", "1984");
//            DatabaseManager.addBook(book);
//            DatabaseManager.addBook(book2);
//            DatabaseManager.addBook(book3);
//            DatabaseManager.addBook(book4);

            Library library = Library.getInstance();
            DatabaseManager.loadBooks(library);
//            DatabaseManager.clear();
            mainFrame mainForm = new mainFrame();
            LibraryController libraryController = new LibraryController(library, mainForm);
            mainForm.setLibraryController(libraryController);
            
            libraryController.updateBookTextArea(libraryController);

            mainForm.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace(); // This will print any exceptions that occur
        }

    }
}
