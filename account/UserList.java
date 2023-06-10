package account;

import java.util.ArrayList;

public class UserList {
    private static ArrayList<User>userData = new ArrayList<User>();

    public User isLogin(String username, String password){
        
        User user = null;

        for(User usr:userData){
            if(username.equals(usr.getUsername()) && password.equals(usr.getPassword())){
                user =  usr;
                return user;
            }
        }

        return user;

    }

    public boolean isAlreadyExist(String username){
        
        boolean isExist = false;

        for(User usr:userData){
            if(username.equals(usr.getUsername())){
                isExist = true;
            }
        }

        return isExist;

    }



    public void addAccount(String username, String password){
        boolean isAlreadyExist = isAlreadyExist(username);

        if(!isAlreadyExist  && userData.size() < 0){
            System.out.println("fail to create account");
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        System.out.println("account created");
        userData.add(user);

        return;
    }

    public void userCount(){
        System.out.println("user count: "+userData.size());
    }
}
