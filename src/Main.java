import entities.Book;
import entities.BorrowBook;
import entities.Reader;
import helper.ValidateBook;
import helper.ValidateBorrowBook;
import service.BookService;
import helper.Helper;
import service.BorrowBookService;
import service.ReaderService;

public class Main {
    static BorrowBook[] borrowBookList = new BorrowBook[100];
    static Book[] bookList=new Book[100];
    static Reader[] readerList=new Reader[100];
    static Helper helper=new Helper();
    static BookService bookService =new BookService();
    static ReaderService readerService =new ReaderService();
    static BorrowBookService borrowBookService=new BorrowBookService();
    static ValidateBook validateBook=new ValidateBook();
    static ValidateBorrowBook validateBorrowBook=new ValidateBorrowBook();
    public static void main(String[] args) {
       setTempBookListData();
       setTempReaderListData();
       setTempBorrowBookListData();
        boolean run=true;
        do {
            helper.printMenu();
            int chose=helper.getInt(" ");
            switch(chose) {
                case 1:
                    int chose_1;
                    do {
                        chose_1 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Thêm sách.\n"
                                + "[2] Xem danh sách sách.\n"
                                + "[3] Quay lại.\n"
                                 );
                        if(chose_1>=1 && chose_1<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_1==1){
                            Book[] newBookList = bookService.getInputListBook(bookList);
                            mergeNewBookListAndSetId(newBookList);
                            System.out.println("Thêm mới thành công ");
                            bookService.printBookList(bookList);
                    }else if(chose_1==2){
                        bookService.printBookList(bookList);
                    }else if(chose_1==3){
                        break;
                    }
                    boolean checkContinue_1= helper.askYesNo();
                    if(checkContinue_1){
                        break;
                    } else{run=false;}

                case 2:
                    int chose_2;
                    do {
                        chose_2 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Thêm người đọc.\n"
                                + "[2] Xem danh sách người đọc.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_2>=1 && chose_2<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_2==1){
                        Reader[] newReaderList = readerService.getInputListReader(readerList);
                        mergeNewReaderListAndSetId(newReaderList);
                        System.out.println("Thêm mới thành công ");
                        readerService.printReaderList(readerList);
                    }else if(chose_2==2){
                        readerService.printReaderList(readerList);
                    }else if(chose_2==3){
                        break;
                    }
                    boolean checkContinue_2= helper.askYesNo();
                    if(checkContinue_2){
                        break;
                    } else{run=false;}

                case 3:
                    int chose_3;
                    do {
                        chose_3 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Thêm bản ghi mượn sách.\n"
                                + "[2] Xem danh sách bản ghi mượn sách.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_3>=1 && chose_3<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if (chose_3==1){
                        int numberOfBookID;
                        int numberOfBook;
                        readerService.printReaderList(readerList);
                        System.out.println("Chọn từ danh sách người đọc đã có");
                        Reader reader=readerService.getReaderById(readerList);
                        System.out.println("Đã chọn người dùng: "+reader.toString());
                        do{
                         numberOfBookID= helper.getInt("Chọn số lượng đầu sách:");
                        if(!validateBorrowBook.simpleValidateNumberOfBook(numberOfBookID)){
                            System.out.println("Vượt quá số lượng cho mượn");
                        }else break;
                        } while(true);
                        Book[] arrBook= new Book[numberOfBookID];
                        for(int i=0;i<=arrBook.length-1;i++){
                            arrBook[i]= new Book(0,"","",0,"",0);
                        }
                        int[] quantity=new int[numberOfBookID];
                        for(int i=0;i<=arrBook.length-1;i++){
                            quantity[i]= 0;
                        }
                        bookService.printBookList(bookList);
                        for(int i=0;i<arrBook.length;i++){
                            System.out.println("Chọn từ danh sách đầu sách đã có");
                            Book book =bookService.getBookById(bookList);
                            System.out.println("Đã chọn sách: "+book.toString());
                            do{
                                 numberOfBook= helper.getInt("Nhập số lượng sách cần mượn:");
                                if(!validateBorrowBook.simpleValidateNumberOfBook(numberOfBook)){
                                    System.out.println("Vượt quá số lượng cho mượn");
                                }else if(!validateBorrowBook.validateBorrowBook(borrowBookList,reader.getId(),book.getId(),numberOfBook,bookList)){
                                    System.out.println("");
                                }else  break;
                            }while(true);
                            arrBook[i].setId(book.getId());
                            arrBook[i].setName(book.getName());
                            arrBook[i].setAuthor(book.getAuthor());
                            arrBook[i].setPublishingYear(book.getPublishingYear());
                            arrBook[i].setQuantity(book.getQuantity());
                            arrBook[i].setField(book.getField());
                            quantity[i]=numberOfBook;
                        }
                        BorrowBook borrowBook=new BorrowBook(arrBook,reader,quantity);
                        mergeNewBorrowBook(borrowBook);
                        System.out.println(borrowBook.toString());
                    }else if(chose_3==2){
                        borrowBookService.printBorrowBookList(borrowBookList);

                    } else if(chose_3==3){
                        break;
                    }
                    boolean checkContinue_3= helper.askYesNo();
                    if(checkContinue_3){
                        break;
                    } else{run=false;}
                case 4:
                    int chose_4;
                    do {
                        chose_4 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Sắp xếp danh sách theo tên.\n"
                                + "[2] Sắp xếp danh sách theo số lượng sách.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_4>=1 && chose_4<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_4==1){
                        borrowBookService.printBorrowBookListSortByName(borrowBookList);
                    }else if(chose_4==2){
                     borrowBookService.printBorrowBookListSortByNumberOfBook(borrowBookList);
                    } else if(chose_4==3){
                        break;
                    }
                    boolean checkContinue_4= helper.askYesNo();
                    if(checkContinue_4){
                        break;
                    } else{run=false;}

                case 5:
                    run=false;
                    break;

                default:
                    System.out.println("Bạn phải nhập số nguyên trong khoảng từ 1 đến 5");
            }
        }
        while (run);
        System.out.println("Đã thoát chương trình");
    }

   static public void setTempBookListData(){
        for(int i=0;i<=bookList.length-1;i++){
            bookList[i]= new Book(0,"","",0,"",0);
        }
       for(int i=0;i<= 5;i++){
           bookList[i]= new Book(10000+i,"nau an co ban "+i,"godon ramsay"+i,2004,"CNTT",i+10);
       }

    }
    static public void setTempReaderListData(){
        for(int i=0;i<= readerList.length-1;i++){
            readerList[i]= new Reader("","","",0,"");
        }
        for(int i=0;i<= 5;i++){
            readerList[i]= new Reader("daido "+i,"hanoi "+i,"0961130568",10000+i,"HS");
        }
    }
   static public void setTempBorrowBookListData(){
        Book[] tempBookList_1= new Book[5];
        for(int i=0;i<= tempBookList_1.length-1;i++){
             tempBookList_1[i]=new Book(0,"","",0,"",0);
        }
         int [] tempQuantity_1=new int [5];
        for(int i=0;i<=tempQuantity_1.length-1;i++){
           tempQuantity_1[i]=0;
        }
         Reader tempReader=new Reader("","","",0,"");
        for(int i=0;i<= borrowBookList.length-1;i++){
            borrowBookList[i]= new BorrowBook(tempBookList_1,tempReader,tempQuantity_1);
        }
    }


    public static void mergeNewBookListAndSetId ( Book[] newBookList ){
        int id=10000;
        int t=0;
        int trueBookListLength= bookService.getTrueBookLength(bookList);
        System.out.println(trueBookListLength);
        int newBookListLength=newBookList.length;
        System.out.println(newBookListLength);
        int totalLength= trueBookListLength+newBookListLength;
        for(int i=trueBookListLength;i<= totalLength-1;i++){
            bookList[i]=new Book(trueBookListLength+id,
                    newBookList[t].getName(),
                    newBookList[t].getAuthor(),
                    newBookList[t].getPublishingYear(),
                    newBookList[t].getField(),
                    newBookList[t].getQuantity());
            t++;
            id++;
        }
    }
    public static void mergeNewBorrowBook(BorrowBook borrowBook){
        boolean check=true;
        for(int i=0;i<=borrowBookList.length-1;i++){
            if(borrowBookList[i].getReader().getId()==0 && check==true){
                borrowBookList[i].setQuantity(borrowBook.getQuantity());
                borrowBookList[i].setBookList(borrowBook.getBookList());
                borrowBookList[i].setReader(borrowBook.getReader());
                check=false;
            }
        }    }
    public static void mergeNewReaderListAndSetId ( Reader[] newReaderList ){
        int id=10000;
        int t=0;
        int trueReaderListLength= readerService.getTrueReaderLength(readerList);

        int newReaderListLength=newReaderList.length;

        int totalLength= trueReaderListLength+newReaderListLength;
        for(int i=trueReaderListLength;i<= totalLength-1;i++){
            readerList[i]=new Reader(newReaderList[t].getName(),
                    newReaderList[t].getAddress(),
                    newReaderList[t].getPhoneNumber(),
                    trueReaderListLength+id,
                    newReaderList[t].getType());
            t++;
            id++;
        }
    }


}
