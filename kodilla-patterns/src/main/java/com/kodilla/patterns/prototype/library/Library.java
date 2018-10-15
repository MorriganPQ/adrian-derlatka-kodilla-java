package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name).append('\n');
        for (Book book: books) {
            s.append(book).append('\n');
        }
        return s.toString();
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = this.shallowCopy();
        clonedLibrary.books = new HashSet<>();
        for (Book book: books) {
            clonedLibrary.getBooks().add(book);
        }
        return clonedLibrary;
    }
}
