package com.kodilla.testing.library;

import org.junit.*;
import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class BookDirectoryTestSuite {
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();

        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);

        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);
        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        //Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfAmountOfBooks() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> resultList0Books = new ArrayList<>();
        List<Book> resultList1Book = generateListOfNBooks(1);
        List<Book> resultList5Books = generateListOfNBooks(5);

        LibraryUser libraryUser0 = new LibraryUser("First0", "Last0", "99121200000");
        LibraryUser libraryUser1 = new LibraryUser("First1", "Last1", "99121200001");
        LibraryUser libraryUser5 = new LibraryUser("First5", "Last5", "99121200005");

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser0)).thenReturn(resultList0Books);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(resultList1Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5)).thenReturn(resultList5Books);
        //When
        List<Book> theList0Books = bookLibrary.listBooksInHandsOf(libraryUser0);
        List<Book> theList1Books = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> theList5Books = bookLibrary.listBooksInHandsOf(libraryUser5);
        //Then
        assertEquals(0, theList0Books.size());
        assertEquals(1, theList1Books.size());
        assertEquals(5, theList5Books.size());
    }

    @Test
    public void testRentABookIsPossible() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        Book book1 = new Book("Title1", "Author1", 2001);
        Book book2 = new Book("Title2", "Author2", 2002);

        LibraryUser libraryUser1 = new LibraryUser("First1", "Last1", "99121200001");
        LibraryUser libraryUser2 = new LibraryUser("First2", "Last2", "99121200002");

        when(libraryDatabaseMock.rentABook(libraryUser1, book1)).thenReturn(true);
        when(libraryDatabaseMock.rentABook(libraryUser2, book2)).thenReturn(false);
        //When
        boolean possible = bookLibrary.rentABook(libraryUser1, book1);
        boolean notPossible = bookLibrary.rentABook(libraryUser2, book2);
        //Then
        assertTrue(possible);
        assertFalse(notPossible);
    }

    @Test
    public void testRentABookSameAsAlreadyRented() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListBooks = new ArrayList<>();
        Book book = new Book("Title", "Author", 2000);
        resultListBooks.add(book);
        LibraryUser libraryUser = new LibraryUser("First", "Last", "99121200000");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListBooks);
        //When
        boolean notPossible = bookLibrary.rentABook(libraryUser, book);
        //Then
        assertFalse(notPossible);
    }

    @Test
    public void testReturnBooks() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("First", "Last", "99121200000");
        when(libraryDatabaseMock.returnBooks(libraryUser)).thenReturn(3);
        //When
        int returnedBooks = bookLibrary.returnBooks(libraryUser);
        //Then
        assertEquals(3, returnedBooks);
    }
}
