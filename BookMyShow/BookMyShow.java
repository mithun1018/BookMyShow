package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;

public class BookMyShow {
    private static ArrayList<User> userArrayList=new ArrayList<>();
    private static ArrayList<Admin> adminArrayList=new ArrayList<>();
    private static ArrayList<String> locationArrayList=new ArrayList<>();
    private static HashMap<String,Theatre> theatreHashMap=new HashMap<>();
    public static ArrayList<User> getUserArrayList(){
        return userArrayList;
    }
    public static ArrayList<Admin> getAdminArrayList(){
        return adminArrayList;
    }


    public static ArrayList<String> getLocationArrayList() {
        return locationArrayList;
    }


    public static HashMap<String, Theatre> getTheatreArrayList() {
        return theatreHashMap;
    }
}
