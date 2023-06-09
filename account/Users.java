package account;

import java.util.ArrayList;

public class Users {
    private static ArrayList<String>usernameDataList = new ArrayList<String>();
    private static ArrayList<String>passwordDataList = new ArrayList<String>();

    public boolean isAccountExist(String username, String password){
        
        boolean isExist = false;

        for(int i = 0;i<usernameDataList.size();i++){
            if(usernameDataList.get(i).equals(username) && passwordDataList.get(i).equals(password)){
                isExist = true;
            }
        }

        return isExist;

    }

    public void addAccount(String username, String password){
        boolean isAlreadyExist = isAccountExist(username, password);

        int listSize = usernameDataList.size();

        if(!isAlreadyExist  && usernameDataList.size() < 0){
            System.out.println("fail to create account");
            return;
        }


        System.out.println("account created");
        usernameDataList.add(listSize, username);
        passwordDataList.add(listSize,password);
        listSize++;

        return;
    }

    public void userCount(){
        System.out.println("user count: "+usernameDataList.size());
    }


}
