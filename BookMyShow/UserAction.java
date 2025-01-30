package BookMyShow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
        boolean enteredMovie=false;
        for (var movie:BookMyShow.getMovieHashMap().keySet()) {
            ArrayList<Movie> showMovie = BookMyShow.getMovieHashMap().get(movie);
            for (var allMovie : showMovie) {
                if (allMovie.getMovieName().isEmpty()) {
                    System.out.println("no movies ");
                    return;
                }
                if (allMovie.getLocation().equals(currentUser.getUserLocation()) && allMovie.getDate().equals(selectedDate)) {
                    enteredMovie=true;
                }
            }
            if (enteredMovie){
                System.out.println(movie);
            }

        }
            System.out.println("1.Book tickets\n2.Change Date\n3.Change location\n4.exit\nEnter your choice:");
        int userChoice=Integer.parseInt(scan.nextLine());

            if (userChoice == 1) {
               UserAction.bookTickets(scan,currentUser,selectedDate);

            }
            else if (userChoice==2) {
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
    public static void bookTickets(Scanner scan,User currentUser,LocalDate selectedDate) {
        boolean enteredMovie = false;
        for (var movie : BookMyShow.getMovieHashMap().keySet()) {
            ArrayList<Movie> showMovie = BookMyShow.getMovieHashMap().get(movie);
            for (var allMovie : showMovie) {
                if (allMovie.getMovieName().isEmpty()) {
                    System.out.println("no movies ");
                    return;
                }
                if (allMovie.getLocation().equals(currentUser.getUserLocation()) && allMovie.getDate().equals(selectedDate)) {
                    enteredMovie = true;
                }
            }
            if (enteredMovie) {
                System.out.println(movie);
            }
        }
        System.out.println("enter the Movie Name: ");
        String movieName = scan.nextLine();
        ArrayList<Movie> showMovie = BookMyShow.getMovieHashMap().get(movieName);
        HashMap<String, HashSet<Show>> theatreContainShow = new HashMap<>();
        for (Movie getMovie : showMovie) {
            if (theatreContainShow.containsKey(getMovie.getTheatre().getTheatrename())) {
                theatreContainShow.get(getMovie.getTheatre().getTheatrename()).add(getMovie.getShow());
            } else {
                theatreContainShow.put(getMovie.getTheatre().getTheatrename(), new HashSet<Show>());
                theatreContainShow.get(getMovie.getTheatre().getTheatrename()).add(getMovie.getShow());
            }
        }
        for (String theatreName : theatreContainShow.keySet()) {
            System.out.println("Theatre Name" + theatreName);
            for (var showInTheatre : theatreContainShow.get(theatreName)) {
                System.out.println("show timing: " + showInTheatre.getStartTime() + "-" + showInTheatre.getEndTime());
            }
        }
        while (true){
            System.out.println("enter the Theatre Name: ");
        String theatreName = scan.nextLine();
        System.out.println("Enter the show timing: ");
        LocalTime showTime = LocalTime.parse(scan.nextLine(), BookMyShow.getTimeFormatter());
        Screen screen = null;
        for (var theatreKey : theatreContainShow.get(theatreName)) {
            if (theatreKey.getStartTime().equals(showTime)) {
                screen = theatreKey.getScreen();
                break;
            }
        }
        if (screen==null){
            continue;
        }
            System.out.println();
            for (var seat:screen.getSeatGridHashMap().entrySet()){
                System.out.println(seat.);
            }
    }




    }


}
