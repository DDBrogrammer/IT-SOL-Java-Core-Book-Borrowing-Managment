import entities.Book;
import entities.BorrowBook;
import entities.Reader;
import service.BookService;
import helper.Helper;
import service.ReaderService;

public class Main {
    static BorrowBook[] borrowBookList = new BorrowBook[100];
    static Book[] bookList=new Book[100];
    static Reader[] reader=new Reader[100];
    static Helper helper=new Helper();
    static BookService bookService =new BookService();
    static ReaderService readerService =new ReaderService();
    static int bookId=10000;
    static int readerId=10000;
    public static void main(String[] args) {
        helper.printMenu();
        Book[] bookList=getListBook();
        for(int i=0;i<=bookList.length-1;i++){
            System.out.println(bookList[i].toString());
        }
    }

    public static Book[]  getListBook(){
        int numberOfBook= helper.getInt("Enter number of book: ");
        Book[] newBookList= new Book[numberOfBook];
        for (int i=0;i<=numberOfBook-1 ; i++){
            newBookList[i]= bookService.getBook();
        }
        return newBookList;
    }

    public static Reader[]  getListReader(){
        int numberOfReader= helper.getInt("Enter number of reader: ");
        Reader[] newReaderList= new Reader[numberOfReader];
        for (int i=0;i<=numberOfReader-1 ; i++){
             newReaderList[i] = readerService.getReader();
        }
        return newReaderList;
    }






}
