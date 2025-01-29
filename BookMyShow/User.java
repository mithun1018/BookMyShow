package BookMyShow;
public class User {
    private String username;
    private String password;
    private String userLocation;
    public User(String username,String password,String userLocation)//to get username and password
    {
        this.username=username;
        this.password=password;
        this.userLocation=userLocation;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getUserLocation() {return userLocation;}
    public void setUserLocation(String location){
        this.userLocation=location;
    }
}

