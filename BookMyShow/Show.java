package BookMyShow;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private Screen screen;
    public Show(LocalTime startTime,LocalTime endTime,LocalDate date,Screen screen){
        this.startTime=startTime;
        this.endTime=endTime;
        this.date=date;
        this.screen=screen;
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
}
