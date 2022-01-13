package helper;

import entities.Book;
import entities.Reader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateReader {
    private String PHONE_NUMBER_REGEX= "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    public Boolean validateName( String name){
        if(name.length() == 0){
            System.out.println("Bạn chưa nhập tên người đọc");
            return false;
        }else if(
                name.length()>=100
        )  {
            System.out.println("Tên người đọc quá dài");
            return  false;
        } else {
            return true;}
    }
    public Boolean validateAddress(String address) {
        if(address.length() == 0){
            System.out.println("Bạn chưa nhập địa chỉ người đọc");
            return false;
        }else if(
                address.length()>=200
        )  {
            System.out.println("Địa chỉ quá dài");
            return  false;
        } else {
            return true;}
    }
    public Boolean validatePhoneNumber(String phone) {
        Pattern p = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher m = p.matcher(phone);
        boolean b = m.matches();
        if(phone.length() == 0){
            System.out.println("Bạn chưa nhập số điện thoại của người đọc");
            return false;
        }else if(
                phone.length()>11
        )  {
            System.out.println("Số điện thoại quá dài");
            return  false;
        } else if( !b){
            System.out.println("Số điện thoại không hợp lệ");
            return false;}
        else{
            return true;

        }    }
    public Boolean validateType( String field){
        if(field.toUpperCase().equals("GV") ||
                field.toUpperCase().equals("SV")||
                field.toUpperCase().equals("HVCH")
        ){
            return true;
        }   else {
            System.out.println("Chỉ được nhập các mã [GV]: Giáo Viên, [SV]: Sinh Viên,[VHNT]: Học Viên Cao Học");
            return false;}
    }
    public Boolean validateQuantity(int quantity){
        if(quantity<=0){
            System.out.println("Số lượng sách không được âm hoặc bằng 0:");
            return false;
        } else return true;   }
    public int getValidatedReaderId(Reader[] readerList){
        int id=9999;
        for(int i=0;i<readerList.length-1;i++){
            if(readerList[i].getId()!=0){
             id=id+1;
            }
        }
        return id;
    }
    public Boolean checkReaderExist(int id, Reader[] readerList){
        boolean check=false;
        for (int i=0;i<=readerList.length-1;i++){
            if(readerList[i].getId()==id){
                check=true;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy người đọc này");
        }
        return check;
    }

}
