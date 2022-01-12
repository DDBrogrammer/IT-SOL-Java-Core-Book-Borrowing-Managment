package service;

import entities.Book;
import helper.Helper;

public class BookService {
    private Helper helper=new Helper();

    public void printBookList(Book[] readerList){
        for(int i=0;i<=readerList.length-1;i++){
            System.out.println(readerList[i].toString());
        }
    }
    public Book getBook (){
       String name= helper.getStringInfor("Enter book name:");
       String author= helper.getStringInfor("Enter author name: ");
       int publishingYear= helper.getInt("Enter publishing year: ");
       String field = helper.getStringInfor("Enter field: ");
       int quantity=helper.getInt("Enter number  of book: ");
        Book newBook = new Book(10000,name,author,publishingYear,field,quantity);
        return newBook;
    }
}
