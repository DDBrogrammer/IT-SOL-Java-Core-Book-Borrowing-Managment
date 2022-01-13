package service;

import entities.Book;
import entities.BorrowBook;

public class BorrowBookService {
    public void printBorrowBookList(BorrowBook[] borrowBookList){
        for(int i=0;i<= borrowBookList.length-1;i++){
            if(borrowBookList[i].getReader().getId()!=0){
                System.out.println("                                                               ");
                System.out.println(borrowBookList[i].getReader().toString());
                 for(int u=0;u<=borrowBookList[i].getBookList().length-1;u++){
                     System.out.println(borrowBookList[i].getBookList()[u].toString()+"Số lượng:"+borrowBookList[i].getQuantity()[u]);
                 }
                System.out.println("                                                               ");
            }
        }
    }
    public int getTrueLength(BorrowBook[] borrowBookList){
        int count = 0;
        for(int i=0;i<=borrowBookList.length-1;i++){
            if(borrowBookList[i].getReader().getId()!=0){
                count=count+1;
            }
        }
        return count;
    }
    public void printBorrowBookListSortByName(BorrowBook[] borrowBookList){
        BorrowBook temp = new BorrowBook();
        for (int i = 0; i < getTrueLength(borrowBookList) - 1; i++) {
            for (int j = i + 1; j < getTrueLength(borrowBookList); j++) {
                if (borrowBookList[i].getReader().getName().compareTo(borrowBookList[j].getReader().getName()) > 0) {
                    temp = borrowBookList[i];
                    borrowBookList[i] = borrowBookList[j];
                    borrowBookList[j] = temp;
                }
            }
        }
        System.out.println("danh sách sau khi sắp xếp là :");
        printBorrowBookList(borrowBookList);
    }
    public void printBorrowBookListSortByNumberOfBook(BorrowBook[] borrowBookList){
        BorrowBook temp = new BorrowBook();
        for (int i = 0; i < getTrueLength(borrowBookList) - 1; i++) {
            for (int j = i + 1; j < getTrueLength(borrowBookList); j++) {
                if (getTotalFormArray(borrowBookList[i].getQuantity())<getTotalFormArray(borrowBookList[j].getQuantity())) {
                    temp = borrowBookList[i];
                    borrowBookList[i] = borrowBookList[j];
                    borrowBookList[j] = temp;
                }
            }
        }
        System.out.println("danh sách sau khi sắp xếp là :");
        printBorrowBookList(borrowBookList);
    }
    public int getTotalFormArray(int[] numberArr){
        int count =0;
        for (int i=0;i<=numberArr.length-1;i++){
            count=count+numberArr[i];
        }
        return count;
    }



}
