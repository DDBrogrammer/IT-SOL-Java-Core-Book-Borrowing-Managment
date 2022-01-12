import java.text.SimpleDateFormat;
import java.util.Date;

public class BookBorrowingManagment {
    public static void main(String[] args) {


        Book book_1=new Book(1234,"book-1","Dai Do",2019,"CNTT");

    }
    public static void printMenu(){
    }
    public static void printReaderList(Reader [] readerList){
            for(int i=0;i<= readerList.length-1;i++){
                System.out.println(readerList[i]);
            }
    }
    public static void printBookList(Book [] bookList){
        for(int i=0;i<= bookList.length-1;i++){
            System.out.println(bookList[i]);
        }
    }
}

