package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;

public class Utilities {
    public static HashMap<Character, ArrayList<String>> addGrid(int seatCount,String gridNumber){
        var stringOFGrid=gridNumber.split("\\*");
        int totalGrid=0;
        for (String dupStringOFGrid:stringOFGrid){
            totalGrid+=Integer.parseInt(dupStringOFGrid);
        }
        if (seatCount%totalGrid==0){
             HashMap<Character, ArrayList<String>> seatGridHashMap=new HashMap<>();
            char alphabet='A';
            while (seatCount>=0){
                ArrayList<String> seatArangement=new ArrayList<>();
                for (int col=0;col<stringOFGrid.length;col++){
                    int seatsInEachGrid=Integer.parseInt(stringOFGrid[col]);
                    for (int i=0;i<seatsInEachGrid;i++){
                        seatArangement.add("_");
                    }
                    if(col<stringOFGrid.length-1){
                        seatArangement.add("<SPACE>");
                    }

                }
                seatGridHashMap.put(alphabet,seatArangement);
                alphabet++;
                seatCount=seatCount-totalGrid;
            }
            return seatGridHashMap;
        }
        return null;
    }
}
