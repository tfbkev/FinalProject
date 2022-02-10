import java.util.ArrayList;
import java.util.Scanner;

public class BMW {

    static ArrayList<Automobile> vehicleList = new ArrayList<>();

    public static void AddVehicle() {

        Scanner scnr = new Scanner(System.in);
        System.out.println();
        String mthYeartest = scnr.nextLine();
        int indexofMonthyear = vehicleList.indexOf(mthYeartest);
        if (indexofMonthyear != -1){System.out.println("Add a Vehicle");
        System.out.println("Enter Vehicle Make: ");
        String make = scnr.next();
        System.out.println("Enter Vehicle Model: ");
        String model = scnr.next();
        System.out.println("Enter Vehicle Color: ");
        String color = scnr.next();
        System.out.println("Enter Vehicle Year: ");
        int year = scnr.nextInt();
        System.out.println("Enter Vehicle Mileage: ");
        int mileage = scnr.nextInt();
//     Having a hardtime understanding how to get this to run in the main
//     I want to be able to type in "add car" into a scanner which would have this method run                                
        Automobile newAuto = new Automobile(make, model, color, year, mileage);
        vehicleList.add(newAuto);

    }
        


    }

}
