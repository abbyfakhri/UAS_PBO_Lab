import java.util.Scanner;

import account.Users;
import menu.Menu;

public class Main{

    public static void showMainMenu(){
        Scanner scan = new Scanner(System.in);
        boolean session = true;
        boolean status = false;
        Menu menu = new Menu();

        while(session){
            System.out.println("welcome to abby's library");
            System.out.println("Identify yourself");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("input: ");
    
            int input = scan.nextInt();
    
            if(input == 1){
                // go to user page

                menu.showUserMenu();
            }
            else if(input == 2){
                // go to admin page
                menu.showUserMenu();
                
            }
            else if(input == 3){
                System.out.println("see you again...");
                session = false;
                
            }
            else{
                System.out.println("invalid input, please try again");
            }

            System.out.println("-----------------------------");


        }

        scan.close();
    }

    public static void main(String [] args){
        
        //showMainMenu();
        Users user = new Users();

        user.addAccount("abby", "123");
        user.addAccount("grace", "123");
        user.addAccount("marchia", "123");
        user.userCount();

        System.out.println(user.isAccountExist("pantat", "123"));




        showMainMenu();
        
    }
}