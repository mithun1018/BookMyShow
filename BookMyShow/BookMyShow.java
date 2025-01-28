package BookMyShow;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class BookMyShow {
    private static ArrayList<User> userArrayList=new ArrayList<>();
    private static ArrayList<Admin> adminArrayList=new ArrayList<>();
    private static ArrayList<String> locationArrayList=new ArrayList<>();
    private static HashMap<String,Theatre> theatreHashMap=new HashMap<>();
    private static HashMap<String,ArrayList<Movie>> MovieHashMap=new HashMap<>();
    private static DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("HH-mm");


    public static ArrayList<User> getUserArrayList(){
        return userArrayList;
    }
    public static ArrayList<Admin> getAdminArrayList(){
        return adminArrayList;
    }
    public static ArrayList<String> getLocationArrayList() {
        return locationArrayList;
    }
    public static HashMap<String, Theatre> getTheatreHashMap() {
        return theatreHashMap;
    }
    public static DateTimeFormatter getDateFormatter() {
        return dateFormatter;
    }
    public static DateTimeFormatter getTimeFormatter() {
        return timeFormatter;
    }
    public static HashMap<String, ArrayList<Movie>> getMovieHashMap() {
        return MovieHashMap;
    }
}
