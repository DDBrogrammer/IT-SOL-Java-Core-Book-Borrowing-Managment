package helper;

import java.util.Scanner;

public class Helper {
    public  void printMenu() {
        System.out.println("Choses action:\n"
                + "[1] Airport management.\n"
                + "[2] Fixed wing airplane management.\n"
                + "[3] Helicopter management group.\n"
                + "[4] Close program." );

    }

    public  int getInt(String ask) {
        boolean run=true;
        int a=0;
        while(run==true) {try {
            Scanner sc = new Scanner(System.in);
            System.out.println(ask);
            a = sc.nextInt();
            run=false;

        }catch(Exception e ) {
            System.out.println("You must enter a number :v");
        }

        }

        return (int)a;
    }

    public  String getStringInfor(String ask) {
        boolean run=true;
        String s="";
        while(run==true) {try {
            Scanner sc = new Scanner(System.in);
            System.out.println(ask);
            s = sc.nextLine();
            run=false;
        }
        catch(Exception e ) {
            System.out.println("You must enter some text :D");
        }

        }
        return s;
    }

    public  Double getDoubleInfor(String ask) {
        boolean run=true;
        Double d=0.0;
        while(run==true) {try {
            Scanner sc = new Scanner(System.in);
            System.out.println(ask);
            d = sc.nextDouble();
            run=false;
        }
        catch(Exception e ) {
            System.out.println("You must enter anumber :D");
        }

        }
        return (Double)d;
    }

    public  boolean askYesNo() {
        boolean ok=false;
        boolean runAgain=true;
        String ans="";
        while(runAgain==true) {
            try {
                ans = getStringInfor("Do you want to continue with another function \n" +
                        "[Y]  yes\n" +
                        "[N]  no\n" +
                        "Choose an option: "); }catch (Exception e) {
                // TODO: handle exceptions
                ans = getStringInfor("You must enter Y(yes) or N(no).");
            }
            if(ans.toUpperCase().equals("Y")) {
                ok=true;
                runAgain=false;
            }else if(ans.toUpperCase().equals("N")) {
                ok=false;
                runAgain=false;
            }else {
                runAgain=true;
            }


        }
        return ok;

    }

}
