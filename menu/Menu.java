package menu;
import java.util.Scanner;

import account.User;
import account.UserList;
import datamodel.ItemList;
import datamodel.LibraryItem;

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
                            borrowBook();
        
                            showUserMenu();
                        }
                
                        else if(input == 3){
                            // go to return book menu
                            println("return book");
                            println("-----------------------------");
                            itemList.showCategory("book");
        
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
                            showUserMenu();
                        }

                        else if(input == 6){
                            println("Return Magazine");
                            itemList.showCategory("magazine");
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
            println("3. Update item");
            println("4. Exit");
            println("-----------------------------");
            
            print("input: ");
            println("-----------------------------");
            
            int input = scan.nextInt();
    
            if(input == 1){
                // add item menu
                println("adding new item");
                println("-----------------------------");
            
                showAdminMenu();
            }
    
            else if(input == 2){
                // remove item menu
                println("remove new item");
                println("-----------------------------");
            
                showAdminMenu();
            }
    
            else if(input == 3){
                // update item menu
                println("updating item");
                println("-----------------------------");
            
                showAdminMenu();
            }

            else if(input == 4){
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

    private void borrowBook(){
        println("Which Book do You Want to Borrow");
        print("Select by number on table: ");
        int input = scan.nextInt();


        currentUser.borrowItem(itemList.getItemByIndex(input-1));





        
    }

    private void println(String input){
        System.out.println(input);
    }

    private void print(String input){
        System.out.print(input);
    }

}
