package helper;

import entities.Book;
import entities.BorrowBook;

public class ValidateBorrowBook {
    public int countNumberOfDifferentBorrowedBook(BorrowBook [] borrowBookList, int readerId) {
        int count = 0;
        for (int i = 0; i <= borrowBookList.length - 1; i++) {
            if(borrowBookList[i].getReader().getId()==readerId){
                for (int t=0;t<=4;t++){
                    if(borrowBookList[i].getBookList()[t].getId()!=0){
                        count=count+1;
                    }
                }
            }

        }
        return count;
    }
    public int countNumberOfSameIdBorrowedBook(BorrowBook [] borrowBookList, int readerId, int bookId) {
        int quantity=0;
        for (int i = 0; i <= borrowBookList.length - 1; i++) {
            if(borrowBookList[i].getReader().getId()==readerId){
                for (int t=0;t<=4;t++){
                    if(borrowBookList[i].getBookList()[t].getId()==bookId){
                        quantity=borrowBookList[i].getQuantity()[t];
                    }
                }
            }

        }
        return quantity;
    }
    public boolean validateBorrowBook(BorrowBook[] borrowBookList, int readerId, int bookId,int quantity,Book [] bookList){
         boolean checkNotEnoughBook=true;
         boolean checkBorrowThanRule=true;
         if(countNumberOfSameIdBorrowedBook(borrowBookList,readerId,bookId)+quantity>3){
             System.out.println("Mượn nhiều hơn số lượng cho phép");
             checkBorrowThanRule=false;
         }
         for(int i=0;i<=bookList.length-1;i++){
             if(bookList[i].getId()==bookId){
                 if(bookList[i].getQuantity()<quantity){
                     System.out.println("Không đủ sách để cho mượn");
                     checkNotEnoughBook=false;
                 }
             }
         }
                  return checkBorrowThanRule && checkNotEnoughBook;
    }



}
