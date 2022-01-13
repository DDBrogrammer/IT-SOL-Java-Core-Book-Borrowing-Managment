package helper;

import entities.Book;
import entities.Reader;

public class ValidateBook {
    public Boolean checkBookExist(int id, Book[] bookList){
        boolean check=false;
        for (int i=0;i<=bookList.length-1;i++){
            if(bookList[i].getId()==id & bookList[i].getQuantity()!=0){
                check=true;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy đầu sách này");
        }
        return check;
    }
    public Boolean validateName( String name){
        if(name.length() == 0){
            System.out.println("Bạn chưa nhập tên sách");
            return false;
        }else if(
                name.length()>=200
        )  {
            System.out.println("Tên sách quá dài");
            return  false;
        } else {
            return true;}
    }

    public Boolean validateAuthor( String author){
        if(author.length() == 0){
            return false;
        }else if(
                author.length()>=100
        )  {
            System.out.println("Tên tác giả qúa dài");
            return  false;
        } else {
            return true;}
    }

    public Boolean validateYear( int year ){
        if(year< 2001){
            System.out.println("Sách quá cũ ");
            return false;
        }else if (year>=2023){
            System.out.println("Chưa đến năm 2023");
            return false;
        }else return true;
    }

    public Boolean validateField( String field){
        if(field.toUpperCase().equals("CNTT") ||
                field.toUpperCase().equals("KHTN")||
                field.toUpperCase().equals("VHNT")||
                field.toUpperCase().equals("DTVT")
                ){
            return true;
        }   else {
            System.out.println("Chỉ được nhập các mã CNTT,KHTN,VHNT,DTVT");
            return false;}
    }
    public Boolean validateQuantity(int quantity){
        if(quantity<=0){
            System.out.println("Số lượng sách không được âm hoặc bằng 0:");
            return false;
        } else return true;   }

    public int getValidatedBookId(Book[] bookList){
        int id=9999;
        for(int i=0;i<bookList.length-1;i++){
            if(bookList[i].getId()!=0){
                id=id+1;
            }
        }
        return id;
    }
    public boolean validateBookRemain(Book[] bookList,int num){
        boolean check=true;
        for(int i=0;i<=bookList.length-1;i++){
            if(num>bookList[i].getQuantity()){
                check=false;
            }
        }
        if (check==false){
            System.out.println("Không có đủ số sách yêu cầu ");
        }
        return check;}
}
