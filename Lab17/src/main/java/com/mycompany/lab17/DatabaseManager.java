/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DatabaseManager {

    private static final String DATABASE_URL = "jdbc:sqlite:src/main/resources/LibrarySystem.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static void addBook(Book book) {
        String sql = "INSERT INTO books(authorfname, authorlname, title) VALUES(?, ?, ?)";

        try ( Connection connection = getConnection();  PreparedStatement pstatement = connection.prepareStatement(sql)) {

            pstatement.setString(1, book.getAuthorFName());
            pstatement.setString(2, book.getAuthorLName());
            pstatement.setString(3, book.getTitle());
            pstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeBook(Book book) {
        String sql = "DELETE  FROM books WHERE authorfname = ? AND authorlname = ? AND title = ?";

        try ( Connection connection = getConnection();  PreparedStatement pstatement = connection.prepareStatement(sql)) {
            pstatement.setString(1, book.getAuthorFName());
            pstatement.setString(2, book.getAuthorLName());
            pstatement.setString(3, book.getTitle());
            pstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public static void clear() {
    String sqlDeleteAllBooks = "DELETE FROM books";

    try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
        statement.executeUpdate(sqlDeleteAllBooks);
        System.out.println("All books have been removed from the database.");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    public static void initialize() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS books ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "authorfname TEXT NOT NULL,"
                + "authorlname TEXT NOT NULL,"
                + "title TEXT NOT NULL)";

        try ( Connection connection = getConnection();  Statement statement = connection.createStatement()) {
            statement.execute(sqlCreateTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadBooks(Library library) {
        String sqlSelectAllBooks = "SELECT * FROM books";

        try ( Connection connection = getConnection();  Statement statement = connection.createStatement();  ResultSet rs = statement.executeQuery(sqlSelectAllBooks)) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("authorfname"),
                        rs.getString("authorlname"),
                        rs.getString("title"));
                library.addBook(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
