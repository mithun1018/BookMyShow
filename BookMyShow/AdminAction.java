package BookMyShow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminAction {
    public static Admin checkAdmin() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Admin name: ");
        String name = scan.nextLine();
        System.out.print("Enter Password: ");
        String password = scan.nextLine();
        ArrayList<Admin> adminsAvailable = BookMyShow.getAdminArrayList();
        for (Admin individualAdmin : adminsAvailable) {
            if (individualAdmin.getadminName().equals(name) && individualAdmin.getPassword().equals(password)) {
                return individualAdmin;
            } else if (individualAdmin.getadminName().equals(name) && !individualAdmin.getPassword().equals(password)) {
                return new Admin(null, null);
            }
        }
        return null;
    }

    public static void adminAction(Scanner scan) {
        while (true) {
            System.out.println("1.add location\n2.add theatre\n3.add movie\n4.view all theatre\n5.view all movie");
            int adminChoice = Integer.parseInt(scan.nextLine());
            if (adminChoice == 1) {
                AdminAction.addlocation(scan);
            } else if (adminChoice == 2) {
                AdminAction.addTheatre(scan);
            } else if (adminChoice == 3) {
                AdminAction.addMovie(scan);

            } else if (adminChoice == 4) {
                 AdminAction.viewTheatre();
            } else if (adminChoice==5) {
                AdminAction.viewMovie(scan);
            }

        }

    }

    public static void addlocation(Scanner scan) {
        System.out.println("enter the location");
        String location = scan.nextLine();


        if (BookMyShow.getLocationArrayList().contains(location)) {
            System.out.println("location Already Exist");
            return;
        }
        BookMyShow.getLocationArrayList().add(location);
        System.out.println("Location added Successfully");
    }

    public static void addTheatre(Scanner scan) {
        int i = 1;
        for (String dupLocation : BookMyShow.getLocationArrayList()) {
            System.out.println(i + dupLocation);
            i++;
        }
        System.out.println("enter Location ");
        String enteredLocation = scan.nextLine();
        if (BookMyShow.getLocationArrayList().contains(enteredLocation)) {
            System.out.println("enter Theatre name");
            String theatreName = scan.nextLine();
            if (BookMyShow.getTheatreHashMap().keySet().contains(theatreName)) {
                System.out.println("Theatre Already Exist");
                return;
            }
            System.out.println("enter no.of Screen");
            int screenCount = Integer.parseInt(scan.nextLine());
            HashMap<String, Screen> dupScreenHashMap = new HashMap<>();
            for (int j = 0; j < screenCount; j++) {
                AdminAction.addScreen(scan, dupScreenHashMap);
                BookMyShow.getTheatreHashMap().put(theatreName,new Theatre(theatreName,enteredLocation,dupScreenHashMap));
            }
            return;
        }
        System.out.println("location not found");
    }

    public static void addScreen(Scanner scan, HashMap<String, Screen> dupScreenHashMap) {
        System.out.println("enter the Screen name");
        String screenName = scan.nextLine();
        if (dupScreenHashMap.keySet().contains(screenName)) {
            System.out.println("Screen Already Exist");
        }
        System.out.println("enter the no.of Seats: ");
        int seatCount = Integer.parseInt(scan.nextLine());
        System.out.println("enter the no.of grid :");
        String gridNumber = scan.nextLine();
        var grid = Utilities.addGrid(seatCount, gridNumber);
        dupScreenHashMap.put(screenName, new Screen(screenName, seatCount, gridNumber, grid));
        if (grid != null) {
            for (var dupGrid : grid.entrySet()) {
                System.out.println(dupGrid);
            }
        }
    }

    public static void viewTheatre() {
        if (!BookMyShow.getTheatreHashMap().isEmpty()) {
            int i = 1;
                System.out.println("Available Theatre: ");
                for (String key : BookMyShow.getTheatreHashMap().keySet()) {
                    System.out.println(i + " - " + key);
                    i++;
                    System.out.println("Available Screen: ");
                    for (var screen : BookMyShow.getTheatreHashMap().get(key).getScreenHashMap().entrySet()) {
                        System.out.println("  " + screen.getKey());
                    }
                }

        }
    }
    public static void addMovie(Scanner scan) {
        Theatre theatre = null;
        System.out.println("enter the movie Name: ");
        String movieName = scan.nextLine();
        System.out.println("enter the movie Date:");
        LocalDate date = LocalDate.parse(scan.nextLine(), BookMyShow.getDateFormatter());
        System.out.println("enter the duration (minutes)");
        long duration = Long.parseLong(scan.nextLine());
        if (BookMyShow.getLocationArrayList().isEmpty()){
            System.out.println("location is Empty");
            return;
        }
            while (true) {
                for (String dupLocation : BookMyShow.getLocationArrayList()) {
                    System.out.println("-" + dupLocation);
                }
                System.out.println("enter the location");
                String location = scan.nextLine();
                if (BookMyShow.getLocationArrayList().contains(location)) {
                        for (var theatreInLoc : BookMyShow.getTheatreHashMap().entrySet()) {
                            String loc = theatreInLoc.getValue().getTheatrelocation();
                            if (loc.equals(location)) {
                                System.out.println(theatreInLoc.getValue().getTheatrename());
                            }
                        }
                        System.out.println("enter the Theatre Name: ");
                        String theatreName = scan.nextLine();
                        if (BookMyShow.getTheatreHashMap().containsKey(theatreName)) {
                            theatre = BookMyShow.getTheatreHashMap().get(theatreName);
                            while (true) {
                                for (var screens : theatre.getScreenHashMap().keySet()) {
                                    System.out.println(" - " + screens);
                                }
                                System.out.println("enter the Screen name: ");
                                String screenName = scan.nextLine();
                                if (theatre.getScreenHashMap().containsKey(screenName)) {
                                    Screen screen = theatre.getScreenHashMap().get(screenName);
                                    while (true) {
                                        System.out.println("Enter the show Start Time: ");
                                        LocalTime startTime = LocalTime.parse(scan.nextLine(), BookMyShow.getTimeFormatter());
                                        LocalTime endTime = startTime.plusMinutes(duration + 30);
                                        var showScreen = theatre.getScreenHashMap().get(screenName);
                                        for (var allShow : showScreen.getShowHashSet()) {
                                            if (!(startTime.isBefore(allShow.getStartTime()) && endTime.isBefore(allShow.getStartTime())
                                                    || startTime.isAfter(allShow.getStartTime()) && endTime.isAfter(allShow.getEndTime()))) {
                                                System.out.println("show already exist...");
                                                continue;
                                            }
                                            break;
                                        }

                                        System.out.println("enter the Show Date: ");
                                        LocalDate showDate = LocalDate.parse(scan.nextLine(), BookMyShow.getDateFormatter());
                                        Show newShow = new Show(startTime, endTime, showDate);
                                        screen.getShowHashSet().add(newShow);
                                        ArrayList<Movie> newMovie = new ArrayList<>();
                                        newMovie.add(new Movie(movieName, date, duration, location, theatre, screen, newShow));
                                        BookMyShow.getMovieHashMap().put(movieName, newMovie);
                                        System.out.println("SuccessFully movie added");
                                        return;
                                    }
                                } else {
                                    System.out.println("Screen not found \n Enter correct Screen...");
                                }
                            }
                        } else {
                            System.out.println("Theatre not found \n Enter correct Theatre...");
                        }

                } else {
                    System.out.println("location not found \n Enter correct location...");

                }
            }

    }



    public static void viewMovie(Scanner scan){
        for (var allMovie:BookMyShow.getMovieHashMap().keySet()){
            ArrayList<Movie> showMovie=BookMyShow.getMovieHashMap().get(allMovie);
            for (var movie:showMovie){
                System.out.println("Location: "+movie.getLocation());
                System.out.println("Theatre Name -> "+movie.getTheatre().getTheatrename());
                System.out.println("Screen Name --> "+movie.getScreen().getScreenName());
                System.out.println("Movie Name ---> "+movie.getMovieName());

            }
        }


    }


}
