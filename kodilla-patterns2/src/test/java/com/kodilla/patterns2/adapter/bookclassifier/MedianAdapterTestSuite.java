package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> books = new HashSet<>();
        MedianAdapter medianAdapter = new MedianAdapter();

        books.add(new Book("Silvano Jasso Corona", "El Coral Cafe", 1995, "99-7735-055-8"));
        books.add(new Book("Lisimba Macias Mendoza", "El Dementes Deportista", 1950, "99-6880-548-3"));
        books.add(new Book("Adisa Amaya Rendon", "El Canción Colibrí", 1973, "99-7747-346-3"));
        books.add(new Book("Abdon Roldan Banda", "La Tintorería Colibrí", 1972, "99-6841-055-1"));
        books.add(new Book("Arber Deleon Aragon", "La Miel Dromedario", 2012, "99-6851-142-0"));
        books.add(new Book("Celedonio Cortes Sotelo", "La Música Camarón", 1981, "99-7763-946-9"));
        books.add(new Book("Noel Delgado Almaraz", "El Gordo Cafe", 1979, "99-7769-946-1"));

        // When
        int median = medianAdapter.publicationYearMedian(books);

        // Then
        assertEquals(1979, median);
    }
}
