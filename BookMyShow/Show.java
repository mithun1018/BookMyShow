package BookMyShow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Show {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private Screen screen;
    private HashMap<Character, ArrayList<String>> showHashMap=new HashMap<>();
    public Show(LocalTime startTime,LocalTime endTime,LocalDate date,Screen screen,HashMap<Character,ArrayList<String>> showHashMap){
        this.startTime=startTime;
        this.endTime=endTime;
        this.date=date;
        this.screen=screen;
        this.showHashMap=showHashMap;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public Screen getScreen() {
        return screen;
    }

    public HashMap<Character, ArrayList<String>> getShowHashMap() {
        return showHashMap;
    }

    public void setShowHashMap(HashMap<Character, ArrayList<String>> showHashMap) {
        this.showHashMap = showHashMap;
    }
}
