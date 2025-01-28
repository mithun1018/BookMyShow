package BookMyShow;

import java.util.Scanner;
public class BookMyShowAction {
    public  void start(){
        Scanner scan=new Scanner(System.in);
        BookMyShow.getAdminArrayList().add(new Admin("123","1234"));
        while (true){
            System.out.println("1.Admin\n2.User\n3.Register\n4.exit\nEnter your choice");
            int choice=Integer.parseInt(scan.nextLine());
            if (choice==1){
                Admin currentAdmin= AdminAction.checkAdmin();
                if(currentAdmin==null){
                    System.out.println("no admin found");
                }
                else if(currentAdmin.getPassword()== null) {
                    System.out.println("Admin password is wrong ");

                }
                else {
                    System.out.println("login successful");
                    AdminAction.adminAction(scan);
                }

            } else if (choice==2) {
                User currentUser= UserAction.checkUser();
                if (currentUser==null){
                    System.out.println("user not found");
                    while (true) {
                        System.out.println("if you want to register a new account:\n1.Yes\n2.No\nEnter your choice");
                        int userChoice = Integer.parseInt(scan.nextLine());
                        if (userChoice == 1) {
                            UserAction.addUser(scan);
                            System.out.println("new user added successfully");
                            break;
                        } else if (userChoice == 2) {
                            System.out.println("Thank you For the visit...");
                            System.exit(1);
                        } else {
                            System.out.println("invalid input");
                        }
                    }
                }
                else if (currentUser.getPassword()==null) {
                    System.out.println("password wrong");
                }
                else {
                    System.out.println("login successful");
                    UserAction.userAction(scan,currentUser);
                }

            } else if (choice==3) {
                UserAction.addUser(scan);
                System.out.println("new user added successfully");

            }
        }
    }

}
