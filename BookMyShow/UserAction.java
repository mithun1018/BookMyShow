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
    public static void showMovie(Scanner scan,User currentUser){
        LocalDate currentDate=LocalDate.now();
        LocalDate selectedDate=currentDate;
        while (true){
        System.out.println("User Location: "+currentUser.getUserLocation());
        System.out.println("Current Date: "+ currentDate);
        System.out.println("selected Date: "+ selectedDate);
        for (var movie:BookMyShow.getMovieHashMap().keySet()) {
            ArrayList<Movie> showMovie = BookMyShow.getMovieHashMap().get(movie);
            for (var allMovie : showMovie) {
                if (allMovie.getMovieName().isEmpty()) {
                    System.out.println("no movies ");
                    return;
                }
                if (allMovie.getLocation().equals(currentUser.getUserLocation()) && allMovie.getDate().equals(selectedDate)) {
                    if (allMovie.getMovieName().isEmpty()){
                        System.out.println("no movies...");
                    }
                    System.out.println(allMovie.getMovieName());
                }
            }
        }
            System.out.println("1.Book tickets\n2.Change Date\n3.Change location\n4.exit\nEnter your choice:");
        int userChoice=Integer.parseInt(scan.nextLine());

            if (userChoice == 1) {
                for (var movie:BookMyShow.getMovieHashMap().keySet()) {
                    ArrayList<Movie> showMovie = BookMyShow.getMovieHashMap().get(movie);
                    for (var allMovie : showMovie) {
                        if (allMovie.getLocation().equals(currentUser.getUserLocation()) && allMovie.getDate().equals(selectedDate)) {
                            if (allMovie.getMovieName().isEmpty()){
                                System.out.println("no movies...");
                                break;
                            }
                            System.out.println(allMovie.getMovieName());
                        }
                    }
                }
                System.out.println("enter the Movie Name: ");
                String movieName=scan.nextLine();
                ArrayList<Movie> showMovie=BookMyShow.getMovieHashMap().get(movieName);
                for (var movie:showMovie){
                    if (currentUser.getUserLocation().equals(movie.getLocation())&&selectedDate.equals(movie.getDate())) {
                        System.out.println("Movie Name -> " + movie.getMovieName());
                        System.out.println("Theatre Name --> " + movie.getTheatre().getTheatrename());
                        System.out.println("Screen Name ---> " + movie.getScreen().getScreenName());
                        System.out.println("Show Timeing---->" + movie.getShow().getStartTime() + "-" + movie.getShow().getEndTime());
                    }
                }


            } else if (userChoice==2) {
                System.out.println("enter the date(dd-mm-yyyy):");
                LocalDate newDate=LocalDate.parse(scan.nextLine(),BookMyShow.getDateFormatter());
                selectedDate=newDate;
            } else if (userChoice==3) {
                System.out.println("enter the location: ");
                String newLocation=scan.nextLine();
                currentUser.setUserLocation(newLocation);
            } else if (userChoice==4) {
                return;
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
