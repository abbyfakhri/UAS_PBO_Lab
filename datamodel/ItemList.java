package datamodel;

import java.util.ArrayList;

import helper.CommandLineTable;

public class ItemList {

    private static ArrayList<LibraryItem>libraryItems = new ArrayList<LibraryItem>();


    public LibraryItem getItemByIndex(int index){

        return libraryItems.get(index);

    }

    public void addItemCount(LibraryItem libraryItem){

        String title = libraryItem.getTitle();

        for(LibraryItem item: libraryItems){
            if(item.getTitle().equals(title)){
                item.setItemCount(item.getItemCount()+1);
            }
        }

    }

    public void reduceItemCount(LibraryItem libraryItem){

        String title = libraryItem.getTitle();

        for(LibraryItem item: libraryItems){
            if(item.getTitle().equals(title)){
                item.setItemCount(item.getItemCount()-1);
            }
        }

    }

    public void addNewBook(Book book){
        int index = getItemSize();
        libraryItems.add(index, book);
    }

    public void addNewMagazine(Magazine magazine){
        int index = getItemSize();
        libraryItems.add(index, magazine);
    }

    public int getItemSize(){
        return libraryItems.size();
    }

    public void removeItemByIndex(int index){
        libraryItems.remove(index);
        showAll();
    }


    public void showAll(){
        
        CommandLineTable table = new CommandLineTable();

        table.setShowVerticalLines(true);
        table.setHeaders("No.","title","item count","publisher");

        int num = 0;
        for(LibraryItem item: libraryItems){
            num++;
            String title = item.getTitle();
            String itemCount = String.valueOf(item.getItemCount()) ;
            String publisher = item.getPublisher();

            table.addRow(String.valueOf(num),title,itemCount,publisher);
        }

        table.print();
    }

    public void showBook(){
        CommandLineTable table = new CommandLineTable();
        table.setShowVerticalLines(true);
        table.setHeaders("title","item count","publisher");

        for(LibraryItem obj: libraryItems){
            if (obj instanceof Book){
                Book book = (Book) obj;
                //String category = book.getCategory();
                String title = book.getTitle();
                String itemCount = String.valueOf(book.getItemCount());
                String publisher = book.getPublisher();
                table.addRow(title,itemCount,publisher);
                
            }
        }

        table.print();
    }

    public int getItemCountByCategory(String category){
        int count = 0;

        for(LibraryItem item: libraryItems){
            if(item instanceof Book && category.equals("book")){
                count++;
            }

            if(item instanceof Magazine && category.equals("magazine")){
                count++;
            }
        }

        return count;
    }

    public void showCategory(String category){
        CommandLineTable table = new CommandLineTable();
        table.setShowVerticalLines(true);
        table.setHeaders("No.","title","item count","publisher");

        int num = 0;

        for(LibraryItem obj: libraryItems){
            if (obj instanceof Book && category.equals("book")){
                num++;
                Book book = (Book) obj;
                table.setHeaders("No.","Title","Author","Genre","Publisher","Stock","Pages");
                String title = book.getTitle();
                String itemCount = String.valueOf(book.getItemCount());
                String publisher = book.getPublisher();
                String genre = book.getGenre();
                String author = book.getAuthor();
                String numberOfPages = String.valueOf(book.getNumberOfPages());

                table.addRow(String.valueOf(num),title,author,genre,publisher,itemCount,numberOfPages);
                
            }

            if(obj instanceof Magazine && category.equals("magazine")){
                Magazine magazine = (Magazine) obj;
                num++;
                table.setHeaders("No.","Title","Publisher","Issue Number","Stock","isMonthly");
                String title = magazine.getTitle();
                String publisher = magazine.getPublisher();
                String issueNumber = magazine.getIssueNumber();
                String itemCount = String.valueOf(magazine.getItemCount());
                String isMonthly = Boolean.toString(magazine.getIsMonthly());
                table.addRow(String.valueOf(num),title,publisher,issueNumber,itemCount,isMonthly);
            }
        }

        table.print();
    }
    
}
