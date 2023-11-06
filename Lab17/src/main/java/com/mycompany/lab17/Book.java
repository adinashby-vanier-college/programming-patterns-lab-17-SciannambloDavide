/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab17;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Book {

    private String authorFName, authorLName, title;

    public Book() {
        this.authorFName = "John";
        this.authorLName = "Doe";
        this.title = "Untitled";
    }

    public Book(String authorFName, String authorLName, String title) {
        this.authorFName = authorFName;
        this.authorLName = authorLName;
        this.title = title;
    }

    public String getAuthorFName() {
        return authorFName;
    }

    public void setAuthorFName(String authorFName) {
        this.authorFName = authorFName;
    }

    public String getAuthorLName() {
        return authorLName;
    }

    public void setAuthorLName(String authorLName) {
        this.authorLName = authorLName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.authorFName);
        hash = 79 * hash + Objects.hashCode(this.authorLName);
        hash = 79 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.authorFName, other.authorFName)) {
            return false;
        }
        if (!Objects.equals(this.authorLName, other.authorLName)) {
            return false;
        }
        return Objects.equals(this.title, other.title);
    }

    @Override
    public String toString() {
        return title + " by " + authorFName + " " + authorLName;
    }

}
