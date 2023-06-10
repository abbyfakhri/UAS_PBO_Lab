package menu;
import java.util.Scanner;

import account.User;
import account.UserList;
import datamodel.Book;
import datamodel.ItemList;
import datamodel.LibraryItem;
import datamodel.Magazine;

public class Menu {

    private User currentUser = null;
    private static Scanner scan = new Scanner(System.in);
    ItemList itemList = new ItemList();

    public void showMainMenu(){

            println("-------------------------------");
            println("welcome to abby's library");
            println("Identify yourself");
            println("1. User");
            println("2. Admin");
            println("3. Exit");
            println("-------------------------------");
            print("input: ");
            
            int input = scan.nextInt();
            println("-----------------------------");

    
            if(input == 1){
                // go to user page

                showLogin();
            }
            else if(input == 2){
                // go to admin page
                showLogin();
                
            }
            else if(input == 3){
                println("see you again...");
                println("program close");
                return;
                
            }
            else{
                println("invalid input, please try again");
                showMainMenu();
            }

            println("-----------------------------");

    }

    

    public void showLogin(){

        UserList userList = new UserList();
            println("-----------------------------");
            println("1. Login");
            println("2. Signup");
            println("3. Exit");
            println("-----------------------------");

            print("input: ");
            
            int input = 0;
            
            if(scan.hasNextInt()){
                input = scan.nextInt();
                println("-----------------------------");

                if(input == 1){
                    println("logging in");

                    if(scan.hasNextLine()){
                        print("username: ");
                        String username = scan.next();
                        print("password: ");
                        String password = scan.next();

                        if(username.equals("Admin") && password.equals("123")){
                            println("Welcome Admin");
                            showAdminMenu();
                        }
                        currentUser = userList.isLogin(username, password);

                        if(currentUser == null){
                            println("can't find account, please try again");
                            showLogin();
                        }
                        println("Succesfully login");
                        println("-----------------------------");

                        showUserMenu();

                    }
                }
                else if(input == 2){
                    println("-----------------------------");

                    println("Signing up");

                    print("create username: ");
                    String username = scan.next();
                    print("create password: ");
                    String password = scan.next();

                    boolean isAccountExist = userList.isAlreadyExist(username);
                    

                    if(!isAccountExist){
                        userList.addAccount(username, password);
                        currentUser = userList.isLogin(username, password);
                        println("succesfuly creating new account");
                        showUserMenu();
                    }

                    println("account already exist, please try again");

                    showLogin();

                    println("-----------------------------");

                }
                else if(input == 3){
                    println("-----------------------------");

                    println("see you again");
                    showMainMenu();
                    println("-----------------------------");

                }
                else{
                    println("-----------------------------");

                    println("invalid input, please try again");
                    println("-----------------------------");

                    showLogin();
                }
            }

    }
    
    public void showUserMenu(){

        scan.nextLine();
                    println("-----------------------------");
                    println("Welcome to the user menu");
                    println("What do you want to do?");

                    println("1. Browse Book");
                    println("2. Borrow Book");
                    println("3. Return Book");
                    println("4. Browse Magazine");
                    println("5. Borrow Magazine");
                    println("6. Return Magazine");
                    println("7. My Borrow List");

                    println("8. Exit");
                    println("-----------------------------");
                    
                    print("input: ");
                    
                    
                    int input = 0;
                    
                    if(scan.hasNextInt()){
                        
                        input = scan.nextInt();
                        println("-----------------------------");
            
                        if(input == 1){
                            // show book list
                            println("Book list: ");

                            itemList.showCategory("book");
                            
                            showUserMenu();
                        }
                
                        else if(input == 2){
                            // go to borrow book menu
                            println("borrow book");
                            println("-----------------------------");
                            itemList.showCategory("book");
                            borrowItem("book");
        
                            showUserMenu();
                        }
                
                        else if(input == 3){
                            // go to return book menu
                            println("return book");
                            println("-----------------------------");
                            currentUser.showBorrowList();
                            returnItem();
        
                            showUserMenu();
                        }
                        else if(input == 4){
                            println("Browse Magazine");
                            itemList.showCategory("magazine");
                            showUserMenu();
                        }

                        else if(input == 5){
                            println("Borrow Magazine");
                            itemList.showCategory("magazine");
                            borrowItem("magazine");
                            showUserMenu();
                        }

                        else if(input == 6){
                            println("Return Magazine");
                            itemList.showCategory("magazine");
                            returnItem();
                            showUserMenu();
                        }

                        else if(input == 7){
                            println("My Borrow List");
                            currentUser.showBorrowList();
                            showUserMenu();
                        }
            
                        else if(input == 8){
                            // exit the menu
                            println("see you again");
                            println("-----------------------------");
                            currentUser = null;
        
                            showMainMenu();
                            
                        }
                
                        else{
                            println("invalid input, please try again");
                            println("-----------------------------");
        
                            showUserMenu();
                        }

                    }
                    else{
                        println("invalid");
                        println("-----------------------------");
             
                        showUserMenu();
                    }
                    
        return;

    }

    public void showAdminMenu(){
            println("-----------------------------");
            
            println("Welcome to the admin menu");
            println("What do you want to do?");
            println("1. Add item");
            println("2. Remove item");
            println("3. Exit");
            println("-----------------------------");
            
            print("input: ");
            int input = scan.nextInt();
            println("-----------------------------");
    
            if(input == 1){
                // add item menu
                println("adding new item");
                print("which one do you want to add, book/magazine? ");
                String categoryInput = scan.next();

                if(categoryInput.equals("book")){
                    // add new book
                    addNewItem("book");
                }
                else if(categoryInput.equals("magazine")){
                    addNewItem("magazine");
                }
                else{
                    println("invalid category input, please try again");
                    showAdminMenu();
                }
            
                showAdminMenu();
            }
    
            else if(input == 2){
                // remove item menu
                println("remove item");
                removeItem();
            
                showAdminMenu();
            }

            else if(input == 3){
                // exit the menu
                println("see you again");
                println("-----------------------------");
            
                showMainMenu();
            }
    
            else{
                println("invalid input, please try again");
                println("-----------------------------");
            
                showAdminMenu();
            }
    }

    private void removeItem(){
        itemList.showAll();

        println("which one do you want to remove?");
        print("enter item number on the table: ");
        int input = scan.nextInt();

        itemList.removeItemByIndex(input-1);

        println("succesfully removing item");
    }

    private void addNewItem(String category){

        if(category.equals("book")){
            println("Please add new book detail");
            scan.nextLine();
            print("book title: ");
            String title = scan.nextLine();
            scan.nextLine();
            print("publisher: ");
            String publisher = scan.nextLine();
            print("item count: ");
            int itemCount = scan.nextInt();
            scan.nextLine();
            print("genre: ");
            String genre = scan.nextLine();
            print("author: ");
            String author = scan.nextLine();
            print("number of pages: ");
            int numberOfPages = scan.nextInt();
            
            Book book = new Book();

            book.setTitle(title);
            book.setPublisher(publisher);
            book.setItemCount(itemCount);
            book.setGenre(genre);
            book.setAuthor(author);
            book.setNumberOfPages(numberOfPages);

            itemList.addNewBook(book);

            println("Succesfully adding new book");
            showAdminMenu();
        }

        else if(category.equals("magazine")){

            println("Please add new magazine details");
            scan.nextLine();
            print("magazine title: ");
            String title = scan.nextLine();
            scan.nextLine();
            print("publisher: ");
            String publisher = scan.nextLine();
            print("item count: ");
            int itemCount = scan.nextInt();
            print("issue number: ");
            String issueNumber = scan.next();
            print("is this magazine update monthly: ");
            boolean isMonthly = scan.nextBoolean();

            Magazine newMagazine = new Magazine();

            newMagazine.setTitle(title);
            newMagazine.setPublisher(publisher);
            newMagazine.setItemCount(itemCount);
            newMagazine.setIssueNumber(issueNumber);
            newMagazine.setIsMonthly(isMonthly);

            itemList.addNewMagazine(newMagazine);

            println("Succesfully adding new magazine");
            showAdminMenu();
        }

        else{
            println("Invalid input, please try again");
            showAdminMenu();
        }

    }

    private void borrowItem(String category){
        println("Which Book do You Want to Borrow");
        print("Select by number on table: ");
        int input = scan.nextInt();

        if(category.equals("magazine")){
            input += itemList.getItemCountByCategory("book");
        }

        LibraryItem item = itemList.getItemByIndex(input-1);

        if(item.getItemCount() <= 0){
            println("+------------------------------------+");
            println("|This item is currently not available|");
            println("+------------------------------------+");
            showUserMenu();
        }

        itemList.reduceItemCount(item);

        currentUser.borrowItem(item);

    }

    private void returnItem(){
        println("Which Book do You Want to Return");
        print("Select by Number on Table: ");
        int input = scan.nextInt();

        LibraryItem item = new LibraryItem();

        item = currentUser.getItemByIndex(input-1);
        
        currentUser.returnItem(input-1);

        itemList.addItemCount(item);
        
    }

    private void println(String input){
        System.out.println(input);
    }

    private void print(String input){
        System.out.print(input);
    }

}
