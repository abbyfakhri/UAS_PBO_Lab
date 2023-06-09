package menu;
import java.util.Scanner;

import account.Users;

public class Menu {

    private boolean showLogin(){

        Users users = new Users();
        Scanner scan = new Scanner(System.in);
        boolean session = true;

            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.print("input: ");

            int input = 0;

            if(scan.hasNextInt()){
                input = scan.nextInt();

                if(input == 1){
                    System.out.println("logging in");

                    if(scan.hasNextLine()){
                        System.out.print("username: ");
                        String username = scan.nextLine();
                        scan.nextLine();
                        System.out.print("password: ");
                        String password = scan.nextLine();
                        
                        boolean isAccountExist = users.isAccountExist("abby", "123");

                        scan.nextLine();
                        System.out.println("is account exist: "+isAccountExist);


                        if(!isAccountExist){
                            System.out.println("can't find account, please try again");
                            showLogin();
                        }
                        scan.close();
                        return true;

                    }
                }
                else if(input == 2){
                    System.out.println("Signing up");
                }
                else if(input == 3){
                    System.out.println("See you again");
                    session = false;
                    scan.close();
                    return false;

                }
                else{
                    System.out.println("Invalid input, please try again");
                }
            }


        scan.close();

        return false;

    }
    
    public void showUserMenu(){

        boolean loginStatus = showLogin();

        if(!loginStatus){
            System.out.println("fail to login");
            return;
        }

        System.out.println("succesfully login");

        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        boolean session = true;

                    System.out.println("Welcome to the user menu");
                    System.out.println("What do you want to do?");
                    System.out.println("1. Browse books");
                    System.out.println("2. Borrow book");
                    System.out.println("3. Return book");
                    System.out.println("4. Exit");
                    System.out.print("input: ");

                    int input = 0;

                    if(scan.hasNextInt()){

                        input = scan.nextInt();
            
                        if(input == 1){
                            // show book list
                            System.out.println("Book list: ");
                        }
                
                        else if(input == 2){
                            // go to borrow book menu
                            System.out.println("borrow book");
                        }
                
                        else if(input == 3){
                            // go to return book menu
                            System.out.println("return book");
                        }
            
                        else if(input == 4){
                            // exit the menu
                            System.out.println("see you again");
                            session = false;
                            scan.close();
                            return;
                        }
                
                        else{
                            System.out.println("invalid input, please try again");
                            showLogin();
                        }

                    }
                    else{
                        System.out.println("invalid");
                    }
                    
        scan.close();
        return;

    }

    public void showAdminMenu(){

        boolean loginStatus = showLogin();

        if(!loginStatus){
            System.out.println("fail to login");
            return;
        }

        Scanner scan = new Scanner(System.in);
        boolean session = true;

        while(session){
            System.out.println("Welcome to the admin menu");
            System.out.println("What do you want to do?");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Update item");
            System.out.println("4. Exit");
            System.out.print("input: ");
            
            int input = scan.nextInt();
    
            if(input == 1){
                // add item menu
            }
    
            else if(input == 2){
                // remove item menu
            }
    
            else if(input == 3){
                // update item menu
            }

            else if(input == 4){
                // exit the menu
                System.out.println("see you again");
                session = false;
                scan.close();
                return;

            }
    
            else{
                System.out.println("invalid input, please try again");
            }

        }
        
        scan.close();
    }

}
