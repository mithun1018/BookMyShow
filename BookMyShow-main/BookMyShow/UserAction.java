package BookMyShow;

import java.util.ArrayList;
import java.util.Scanner;

public class UserAction {
    public static User checkUser(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter User name: ");
        String name = scan.nextLine();
        System.out.print("Enter Password: ");
        String password = scan.nextLine();
        ArrayList<User> userAvailable = BookMyShow.getUserArrayList();
        for (User individualUser : userAvailable)
        {
            if (individualUser.getUsername().equals(name) && individualUser.getPassword().equals(password))
            {
                return individualUser;
            } else if (individualUser.getUsername().equals(name)&&!individualUser.getPassword().equals(password)) {
                return new User(null,null);
            }
        }
        return null;
    }
    public static void addUser(Scanner scan){
        System.out.println("enter the name: ");
        String userName=scan.nextLine();
        System.out.println("enter password: ");
        String userPassword=scan.nextLine();
        BookMyShow.getUserArrayList().add(new User(userName,userPassword));
    }
}
