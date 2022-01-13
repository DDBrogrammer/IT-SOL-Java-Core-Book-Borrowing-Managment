package service;

import entities.Book;
import entities.Reader;
import helper.Helper;
import helper.ValidateReader;

public class ReaderService {
    private Helper helper=new Helper();
    private ValidateReader validateReader =new ValidateReader();
    public void printReaderList(Reader[] readerList){
        for(int i=0;i<=readerList.length-1;i++){
            if(readerList[i].getId()!=0){
                System.out.println(readerList[i].toString());
            }
        }
    }
    public Reader getReader ( Reader [] readerList) {
        String name, address, phoneNumber, type;
        do {
            name= helper.getString("Nhập tên người đọc:");
            if (validateReader.validateName(name)) {
                break;
            }
        } while (true);
        do {
            address= helper.getString("Nhập địa chỉ của người đọc:");
            if (validateReader.validateAddress(address)) {
                break;
            }
        } while (true);

        do {
            phoneNumber= helper.getString("Nhập số điện thoại người đọc: ");
            if (validateReader.validatePhoneNumber(phoneNumber)) {
                break;
            }
        } while (true);

        do {
            type= helper.getString("Nhập loại bạn đọc: ");
            if (validateReader.validateType(type)) {
                break;
            }
        } while (true);
        Reader newReader = new Reader(name,address,phoneNumber, validateReader.getValidatedReaderId(readerList), type);
        return newReader;
    }
    public  Reader[]  getInputListReader( Reader [] readerList){
        int numberOfReader= helper.getInt("Nhập số lượng người đọc cần thêm: ");
        Reader[] newReaderList= new Reader[numberOfReader];
        for (int i=0;i<=numberOfReader-1 ; i++){
            newReaderList[i] = getReader( readerList);
        }
        return newReaderList;
    }


    public static int getTrueReaderLength( Reader[] readerList){
        int u=0;
        for(int i=0;i<readerList.length-1; i++){
            if(readerList[i].getId()!=0){
                u++;
            }

        }
        return u;
    }
    public Reader getReaderById(Reader[] readerList ){
        Reader reader=new Reader("","","",0,"");
        int readerId;
        do{
            readerId= helper.getInt("Nhập id người đọc");
            if(validateReader.checkReaderExist(readerId,readerList)){
                break;
            }
        }while(true);
        for(int i=0;i<=readerList.length-1;i++){
            if(readerList[i].getId()== readerId){
                reader.setId(readerId);
                reader.setName(readerList[i].getName());
                reader.setAddress(readerList[i].getAddress());
                reader.setPhoneNumber(readerList[i].getPhoneNumber());
                reader.setType(readerList[i].getType());
            }
        }
       return reader;


    }
}
