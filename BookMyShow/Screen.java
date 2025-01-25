package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;

public class Screen {
    private String screenName;
    private int seatNumber;
    private String grid;
    private HashMap<Character, ArrayList<String>> seatGridHashMap=new HashMap<>();

    public Screen(String screenName,int seatNumber,String grid,HashMap<Character,ArrayList<String>> seatGridHashMap){
        this.screenName=screenName;
        this.seatNumber=seatNumber;
        this.grid=grid;
        this.seatGridHashMap=seatGridHashMap;
    }

    public String getScreenName() {
        return screenName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getGrid() {
        return grid;
    }

    public HashMap<Character, ArrayList<String>> getSeatGridHashMap() {
        return seatGridHashMap;
    }
}
