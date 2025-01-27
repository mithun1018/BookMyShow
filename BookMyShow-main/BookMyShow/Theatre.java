package BookMyShow;

import java.util.HashMap;

public class Theatre {
    private  String theatrename;
    private  String theatrelocation;
    private HashMap<String,Screen> screenHashMap=new HashMap<>();
    public Theatre(String theatrename,String theatrelocation){
        this.theatrename=theatrename;
        this.theatrelocation=theatrelocation;
//        this.screenHashMap=screenHashMap;
    }

    public String getTheatrename() {
        return theatrename;
    }

    public String getTheatrelocation() {
        return theatrelocation;
    }

    public HashMap<String, Screen> getScreenHashMap() {
        return screenHashMap;
    }
}

