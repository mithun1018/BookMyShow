package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminAction {
    public static Admin checkAdmin() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Admin name: ");
        String name = scan.nextLine();
        System.out.print("Enter Password: ");
        String password = scan.nextLine();
        ArrayList<Admin> adminsAvailable = BookMyShow.getAdminArrayList();
        for (Admin individualAdmin : adminsAvailable) {
            if (individualAdmin.getadminName().equals(name) && individualAdmin.getPassword().equals(password)) {
                return individualAdmin;
            } else if (individualAdmin.getadminName().equals(name) && !individualAdmin.getPassword().equals(password)) {
                return new Admin(null, null);
            }
        }
        return null;
    }

    public static void adminAction(Scanner scan) {
        while (true) {
            System.out.println("1.add location\n2.add theatre\n3.add movie\n4.view all theatre\n5.view all movie");
            int adminChoice = Integer.parseInt(scan.nextLine());
            if (adminChoice == 1) {
                AdminAction.addlocation(scan);
            } else if (adminChoice == 2) {
                AdminAction.addTheatre(scan);
            } else if (adminChoice == 3) {

            } else if (adminChoice == 4) {
                 AdminAction.viewTheatre(scan);
            }

        }

    }

    public static void addlocation(Scanner scan) {
        System.out.println("enter the location");
        String location = scan.nextLine();


        if (BookMyShow.getLocationArrayList().contains(location)) {
            System.out.println("location Already Exist");
            return;
        }
        BookMyShow.getLocationArrayList().add(location);
        System.out.println("Location added Successfully");
    }

    public static void addTheatre(Scanner scan) {
        int i = 1;
        for (String dupLocation : BookMyShow.getLocationArrayList()) {
            System.out.println(i + dupLocation);
            i++;
        }
        System.out.println("enter Location ");
        String enteredLocation = scan.nextLine();
        if (BookMyShow.getLocationArrayList().contains(enteredLocation)) {
            System.out.println("enter Theatre name");
            String theatre = scan.nextLine();
            if (BookMyShow.getTheatreArrayList().keySet().contains(theatre)) {
                System.out.println("Theatre Already Exist");
                return;
            }
            System.out.println("enter no.of Screen");
            int screenCount = Integer.parseInt(scan.nextLine());
            HashMap<String, Screen> dupScreenHashMap = new HashMap<>();
            for (int j = 0; j < screenCount; j++) {
                AdminAction.addScreen(scan, dupScreenHashMap);
            }
            return;
        }
        System.out.println("location not found");
    }

    public static void addScreen(Scanner scan, HashMap<String, Screen> dupScreenHashMap) {
        System.out.println("enter the Screen name");
        String screenName = scan.nextLine();
        if (dupScreenHashMap.keySet().contains(screenName)) {
            System.out.println("Screen Already Exist");
        }
        System.out.println("enter the no.of Seats: ");
        int seatCount = Integer.parseInt(scan.nextLine());
        System.out.println("enter the no.of grid :");
        String gridNumber = scan.nextLine();
        var grid = Utilities.addGrid(seatCount, gridNumber);
        dupScreenHashMap.put(screenName, new Screen(screenName, seatCount, gridNumber, grid));
        if (grid != null) {
            for (var dupGrid : grid.entrySet()) {
                System.out.println(dupGrid);
            }
        }
    }

    public static void viewTheatre(Scanner scan) {
        if (!BookMyShow.getTheatreArrayList().isEmpty()) {
            int i = 1;
            for (var dupTheatre : BookMyShow.getTheatreArrayList().keySet()) {
                System.out.println(i + dupTheatre.);
                i++;
            }

        }
    }
}


