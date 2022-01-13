package entities;

import java.util.Arrays;

public class BorrowBook {
    private Book[] bookList;
    private Reader reader;
    private int[] quantity;

    @Override
    public String toString() {
        return "BorrowBook{" +
                "bookList=" + Arrays.toString(bookList) +
                ", reader=" + reader +
                ", quantity=" + Arrays.toString(quantity) +
                '}';
    }

    public Book[] getBookList() {
        return bookList;
    }

    public void setBookList(Book[] bookList) {
        this.bookList = bookList;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    public BorrowBook(Book[] bookList, Reader reader, int[] quantity) {
        this.bookList = bookList;
        this.reader = reader;
        this.quantity = quantity;
    }
    public BorrowBook() {

    }
}
