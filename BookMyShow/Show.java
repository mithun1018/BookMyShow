package BookMyShow;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    public Show(LocalTime startTime,LocalTime endTime,LocalDate date){
        this.startTime=startTime;
        this.endTime=endTime;
        this.date=date;
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
}
