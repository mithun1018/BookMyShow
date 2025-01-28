package BookMyShow;

import java.time.LocalDate;
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
                return new User(null,null,null);
            }
        }
        return null;
    }
    public static void userAction(Scanner scan,User currentUser){
        System.out.println("User Location: "+currentUser.getUserLocation());
        System.out.println("Current Time"+ LocalDate.now());
        for (var movie:BookMyShow.getMovieHashMap().keySet()){
            ArrayList<Movie> showMovie=BookMyShow.getMovieHashMap().get(movie);
            for (var allMovie:showMovie){
                if (allMovie.getLocation().equals(currentUser.getUserLocation())&&allMovie.getDate().equals(LocalDate.now())){
                    allMovie.getMovieName();
                }
            }
        }


    }
    public static void addUser(Scanner scan){
        System.out.println("enter the name: ");
        String userName=scan.nextLine();
        System.out.println("enter password: ");
        String userPassword=scan.nextLine();
        System.out.println("enter the location: ");
        String userLocation=scan.nextLine();
        BookMyShow.getUserArrayList().add(new User(userName,userPassword,userLocation));
    }


}
