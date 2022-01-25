package service;

import entities.Book;
import entities.Reader;
import helper.Helper;
import helper.ValidateBook;

import java.util.Locale;

public class BookService {
    private Helper helper=new Helper();
    private ValidateBook validateBook=new ValidateBook();

    public void printBookList(Book[] readerList){
        for(int i=0;i<=readerList.length-1;i++){
            if(readerList[i].getId()!=0){
            System.out.println(readerList[i].toString());}
        }
    }
    public Book getBook (Book[] bookList ){
        String name,author,field ;
        int publishingYear, quantity;
        do {
            name= helper.getString("Nhập tên sách:");
            if (validateBook.validateName(name)) {
                break;
            }
        } while (true);

        do {
            author= helper.getString("Nhập tên tác giả: ");
            if (validateBook.validateAuthor(author)) {
                break;
            }
        } while (true);

       do{ publishingYear= helper.getInt("Nhập năm xuất bản: ");
           if(validateBook.validateYear(publishingYear)){
               break;
           }
       }
       while(true);

        do{ field = helper.getString("Nhập chuyên ngành (CNTT,KHTN,VHNT,DTVT): ");
            if(validateBook.validateField(field)){
                break;
            }
        }
        while(true);

        do{  quantity=helper.getInt("Nhập số lượng sách: ");
            if(validateBook.validateQuantity(quantity)){
                break;
            }
        }
        while(true);
        Book newBook = new Book(validateBook.getValidatedBookId(bookList), name,author,publishingYear,field,quantity);
        return newBook;
    }
    public  Book[] getInputListBook(Book[] bookList ){
        int numberOfBook= helper.getInt("Nhập số lượng đầu sách: ");
        Book[] newBookList= new Book[numberOfBook];
        for (int i=0;i<=numberOfBook-1 ; i++){
            newBookList[i]= getBook(bookList );
        }
        return newBookList;
    }
    public static int getTrueBookLength( Book[] bookList){
        int u=0;
        for(int i=0;i<bookList.length-1; i++){
            if(bookList[i].getId()!=0){
                u++;
            }

        }
        return u;
    }
    public Book getBookById(Book[] bookList ){
        Book book=new Book(0,"","",0,"",0);
        int readerId;
        do{
            readerId= helper.getInt("Nhập id sách:");
            if(validateBook.checkBookExist(readerId,bookList)){
                break;
            }
        }while(true);
        for(int i=0;i<=bookList.length-1;i++){
            if(bookList[i].getId()== readerId){
               book.setId(bookList[i].getId());
               book.setAuthor(bookList[i].getAuthor());
               book.setField(bookList[i].getField().toUpperCase(Locale.ROOT));
               book.setName(bookList[i].getName());
               book.setPublishingYear(bookList[i].getPublishingYear());
               book.setQuantity(bookList[i].getQuantity());
            }
        }
        return book;


    }

}
