package BookMyShow;

import java.time.LocalDate;

public class Movie {
    private String movieName;
    private LocalDate date;
    private long duration;
    private String location;
    private Theatre theatre;
    private Screen screen;
    private Show show;
    public Movie(String movieName,LocalDate date,long duration,String location,Theatre theatre,Screen screen,Show show){
        this.movieName=movieName;
        this.date=date;
        this.duration=duration;
        this.location=location;
        this.theatre=theatre;
        this.screen=screen;
        this.show=show;
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public Show getShow() {
        return show;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
