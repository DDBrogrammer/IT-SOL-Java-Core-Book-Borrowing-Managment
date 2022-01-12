package service;

import entities.Reader;
import helper.Helper;

public class ReaderService {
    private Helper helper=new Helper();
    public void printReaderList(Reader[] readerList){
        for(int i=0;i<=readerList.length-1;i++){
            System.out.println(readerList[i].toString());
        }
    }
    public Reader getReader () {
        String name= helper.getStringInfor("Enter reader name:");
        String address= helper.getStringInfor("Enter address name: ");
        String phoneNumber= helper.getStringInfor("Enter phone number: ");
        String type = helper.getStringInfor("Enter type: ");
        Reader newReader = new Reader(name,address,phoneNumber,1000,type);
        return newReader;
    }


}
