package account;
import java.util.ArrayList;

import datamodel.LibraryItem;
import helper.CommandLineTable;


public class User {
    
    private String username;
    private String password;

    private ArrayList<LibraryItem>borrowList = new ArrayList<LibraryItem>();

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void borrowItem(LibraryItem item){
        System.out.println("item added to your borrow list");
        borrowList.add(item);
    }

    public void returnItem(int index){
        System.out.println("succesfully returning item");
    }

    public void showBorrowList(){
        CommandLineTable table = new CommandLineTable();

        table.setShowVerticalLines(true);
        table.setHeaders("No.","title","publisher");

        int num = 0;

        for(LibraryItem item: borrowList){
            num++;

            String title = item.getTitle();
            String publisher = item.getPublisher();

            table.addRow(String.valueOf(num),title,publisher);
        }

        table.print();
    }

}
