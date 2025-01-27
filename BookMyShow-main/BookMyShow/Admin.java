package BookMyShow;

public class Admin {
    private String adminName;
    private String password;
    public Admin(String adminName,String password)//to get username and password
    {
        this.adminName=adminName;
        this.password=password;
    }
    public String getadminName(){
        return adminName;
    }
    public String getPassword(){
        return password;
    }
}
