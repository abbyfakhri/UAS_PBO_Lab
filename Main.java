
import account.UserList;
import datamodel.Book;
import datamodel.ItemList;
import datamodel.Magazine;
import menu.Menu;

public class Main{

    public static void main(String [] args){
        
        Menu menu = new Menu();
        
        initiateData();

        menu.showMainMenu();
        
    }

    private static void print(String input){
        System.out.println(input);
    }

        public static void initiateData(){
        
        UserList userList = new UserList();

        userList.addAccount("abby", "123");
        userList.addAccount("grace", "123");
        userList.addAccount("marchia", "123");
        userList.userCount();

        ItemList itemList = new ItemList();

        Book book1 = new Book();
        book1.setTitle("Cara Mencintai");
        book1.setItemCount(3);
        book1.setNumberOfPages(100);
        book1.setPublisher("Surya Ciptaka");
        book1.setGenre("Jenaka");
        book1.setAuthor("Abby Fakhri");

        Book book2 = new Book();
        book2.setTitle("Cara Melepaskan");
        book2.setItemCount(69);
        book2.setNumberOfPages(211);
        book2.setPublisher("Penerbit Jago");
        book2.setGenre("Horror");
        book2.setAuthor("Cipika Cipiki");

        Book book3 = new Book();
        book3.setTitle("Ternak Lele untuk Lulusan Ilmu Komputer");
        book3.setItemCount(100);
        book3.setNumberOfPages(215);
        book3.setGenre("Bisnis");
        book3.setPublisher("Ilkomp Futura");
        book3.setAuthor("Grace MWA");

        Book book4 = new Book();
        book4.setTitle("Belajar Java dalam 24 Jam");
        book4.setItemCount(1);
        book4.setNumberOfPages(80);
        book4.setGenre("Komputer");
        book4.setPublisher("Belas Kasih");
        book4.setAuthor("Ucok Batubara");

        Book book5 = new Book();
        book5.setTitle("Membuat AI dalam Satu Jam");
        book5.setItemCount(2);
        book5.setNumberOfPages(112);
        book5.setGenre("Komputer");
        book5.setPublisher("Cahaya Ilahi");
        book5.setAuthor("Taylor Swift");

        Magazine magazine1 = new Magazine();
        magazine1.setTitle("Time Magazine");
        magazine1.setItemCount(12);
        magazine1.setPublisher("TIME");
        magazine1.setIssueNumber("321");
        magazine1.setIsMonthly(true);

        Magazine magazine2 = new Magazine();
        magazine2.setTitle("Vogue");
        magazine2.setItemCount(33);
        magazine2.setPublisher("Vogue international");
        magazine2.setIssueNumber("821");
        magazine2.setIsMonthly(false);

        Magazine magazine3 = new Magazine();
        magazine3.setTitle("Cosmopolitan");
        magazine3.setItemCount(3);
        magazine3.setPublisher("Cosmo");
        magazine3.setIssueNumber("88");
        magazine3.setIsMonthly(true);

        Magazine magazine4 = new Magazine();
        magazine4.setTitle("Southern Living Magazine");
        magazine4.setItemCount(2);
        magazine4.setPublisher("SLM");
        magazine4.setIssueNumber("540");
        magazine4.setIsMonthly(false);

        Magazine magazine5 = new Magazine();
        magazine5.setTitle("US Weekly Magazine");
        magazine5.setItemCount(1);
        magazine5.setPublisher("UWM");
        magazine5.setIssueNumber("800");
        magazine5.setIsMonthly(true);


        itemList.addNewBook(book1);
        itemList.addNewBook(book2);
        itemList.addNewBook(book3);
        itemList.addNewBook(book4);
        itemList.addNewBook(book5);
        
        itemList.addNewMagazine(magazine1);
        itemList.addNewMagazine(magazine2);
        itemList.addNewMagazine(magazine3);
        itemList.addNewMagazine(magazine4);
        itemList.addNewMagazine(magazine5);
    }
}