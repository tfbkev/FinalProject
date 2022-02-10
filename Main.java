
// Import the Arraylist library for use in keeping track of the vehicles.
import java.io.IOException;
import java.util.ArrayList;
// Import the Scanner library to get data from the user.
import java.util.Scanner;

public class Main {
    // Create an ArrayList of Automobile objects to store a list of vehicles.
    // It is created here to allow access to the list througout the entire Main
    // class.
    static ArrayList<Automobile> vehicleList = new ArrayList<Automobile>();

    // Create a Scanner object to get information from the user when needed;
    // It is created here to reduce the amount of memory being used
    // and allow access to it globally.
    static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        // Clear the console screen.
        ClearScreen();

        // Initialize a variable to store the users choice.
        String userChoice = "";

        // Perform a loop until the users choice is a q for Quit.
        // Using do allows the loop to be run at least once before exiting.
        do {
            // Show the main menu and get the users input.
            userChoice = showMainMenu();

            // Determine which choice the user made.
            switch (userChoice) {
                // User wants to add a vechile.
                case "a":
                    // Run the AddVehicle method to allow the user to add a vehicle to the list.
                    AddVehicle();
                    break;
                // User wants to edit a vehicle.
                case "e":
                    // Show the menu header.
                    showMenuHeader();

                    // Ask user what the VIN is for the vehicle they want to edit.
                    System.out.println();
                    System.out.println("    What is the VIN for the vehicle you would like to edit?");
                    System.out.println();
                    System.out.print("    VIN: ");

                    // Get the VIN from the user.
                    String vinToEdit = scnr.nextLine();

                    // Run the EditVehicle function passing in the VIN the user entered.
                    EditVehicle(vinToEdit);
                    break;
                // User wants to delete a vehicle.
                case "d":
                    // Show the menu header.
                    showMenuHeader();

                    // Ask user what the VIN is for the vehicle they want to delete.
                    System.out.println();
                    System.out.println("    What is the VIN for the vehicle you would like to delete?");
                    System.out.println();
                    System.out.print("    VIN: ");

                    // Get the VIN from the user.
                    String vinToDelete = scnr.nextLine();

                    // Run the DeleteVehicle function passing in the VIN the user entered.
                    DeleteVehicle(vinToDelete);
                    break;
                // User wants to find a vehicle.
                case "f":
                    // Show the menu header.
                    showMenuHeader();

                    // Run the FindVehicles function to allow the user to specify their search.
                    ArrayList<Automobile> found = FindVehicles();

                    // Check to see if any vehicles were found.
                    if (found.size() > 0) {
                        // Run the PrintVehicleList function and pass the found list to show it to the
                        // user.
                        PrintVehicleList(found);
                    } else {
                        // Advise the user nothing was found.
                        System.out.println("    No vehicles were found.");

                        // Pause so the user can see the output.
                        Pause();
                    }
                    break;
                // User wants to print the list of vehicles in the master list.
                case "p":
                    // Run the PrintVehicleList function to print all the vehicles in the master
                    // list.
                    PrintVehicleList();
                    break;
                // User wants to quit the program.
                case "q":
                    // Clear the screen before the program exits.
                    ClearScreen();

                    // Exit the program.
                    return;
                // User entered an unrecognized choice.
                default:
                    // Advise the user that their choice is not valid.
                    System.out.print("Your choice is not valid.  Please choose again. Choice: ");
                    System.out.println(userChoice);

                    // Pause for user input.
                    Pause();
                    break;
            }
            // Continue the loop until the userChoice variable equals q.
        } while (true);
    }

    // The following functions are here to create a spiffy looking user interface
    // for the program.

    // This function will print out the menu header for the program so that it is
    // consistent all over.
    private static void showMenuHeader() {
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("* Welcome to Sapp Automotive Inventory System *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
    }

    // Shows the main menu asking what the user would like to do.
    // Returns the user's choice back to the main function.
    private static String showMainMenu() {
        // Initialize a return variable.
        String result = "";

        // Show the menu header.
        showMenuHeader();

        // Print the menu to the screen giving the user their choices.
        System.out.println();
        System.out.println("    What would you like to do?");
        System.out.println();
        System.out.println("        A: Add a vehicle to the list");
        System.out.println("        E: Edit a vehicle in the list");
        System.out.println("        D: Delete a vehicle from the list");
        System.out.println("        F: Find a vehicle from the list");
        System.out.println("        P: Print the list of vehicles");
        System.out.println("        Q: Quit the program");
        System.out.println();
        System.out.print("    Choice: ");

        // Get the users choice and store it in the return variable.
        result = scnr.nextLine();

        // Clear the screen before returning the value.
        ClearScreen();

        // Return the users choice back to the main function.
        // Convert the choice to lowercase to make it easier to validate.
        return result.toLowerCase();
    }

    // The following functions allow the user to interact with the vehicle master
    // list.

    // This function will prompt the user for the information for the vehicle they
    // would
    // like to add and then add it to the master vehicle list.
    private static void AddVehicle() {
        // Show the menu header.
        showMenuHeader();

        // Create an Automobile object to store the users input.
        Automobile newAutomobile = new Automobile();

        // Ask the user for the vehicle information.
        System.out.println();
        System.out.println("    Adding a new vehicle to the master list");
        System.out.println();
        System.out.print("    What is the VIN for the vehicle? ");
        newAutomobile.setVIN(scnr.nextLine());

        // Check if the VIN entered already exists in the master vehicle list.
        for (Automobile vehicle : vehicleList) {
            // Check if the current vehicle has a matching VIN.
            if (vehicle.getVIN().equals(newAutomobile.getVIN())) {
                // Advise the user that the VIN they are trying to add already exists.
                System.out.print(newAutomobile.getVIN());
                System.out.println(" already exists in the master vehicle list.");

                // Pause so the user can see the output.
                Pause();

                // Return to the main menu.
                return;
            }
        }

        System.out.print("    What is the year the vehicle was made? ");
        newAutomobile.setYear(scnr.nextInt());
        // Call the nextLine method of the Scanner to consume the errant new line that
        // nextInt does not process.
        scnr.nextLine();
        System.out.print("    What is the make of the vehicle? ");
        newAutomobile.setMake(scnr.nextLine());
        System.out.print("    What is the model of the vehicle? ");
        newAutomobile.setModel(scnr.nextLine());
        System.out.print("    What is the color of the vehicle? ");
        newAutomobile.setColor(scnr.nextLine());
        System.out.print("    What is the mileage for the vehicle? ");
        newAutomobile.setMileage(scnr.nextInt());
        // Call the nextLine method of the Scanner to consume the errant new line that
        // nextInt does not process.
        scnr.nextLine();

        // Add the vechile to the master list.
        vehicleList.add(newAutomobile);

        // Advise the user the vehicle was added.
        System.out.println();
        System.out.print(newAutomobile.getVIN());
        System.out.println(" was added to the master vehicle list.");

        // Pause to allow the user to see the output.
        Pause();
    }

    // This function will search the master list for a vehicle with a VIN that
    // matches
    // the users input and then allow them to edit the information for that vehicle.
    private static void EditVehicle(String vin) {
        // Loop through the master vehicle list to find the matching VIN.
        for (Automobile vehicle : vehicleList) {
            // Check to see if the VIN matches the user input.
            if (vehicle.getVIN().equals(vin)) {
                // Matching VIN found.

                // Initialize a variable to store the users choice.
                String userChoice = "";

                // Loop until the user chooses to cancel.
                // Using do allows the loop to be run once before exiting.
                do {
                    // Show the user the vehicle information that was found.
                    PrintVehicle(vehicle);

                    // Ask the user what they would like to change.
                    System.out.println();
                    System.out.println("    What would you like to change?");
                    System.out.println("        1: Color");
                    System.out.println("        2: Make");
                    System.out.println("        3: Mileage");
                    System.out.println("        4: Model");
                    System.out.println("        5: Year");
                    System.out.println("        C: Cancel");
                    System.out.println();
                    System.out.print("    Choice: ");

                    // Get the users choice and store it in the userChoice variable.
                    userChoice = scnr.nextLine().toLowerCase();

                    // Determine what the users choice was.
                    switch (userChoice) {
                        // User wants to change the color.
                        case "1":
                            // Ask what the new color is.
                            System.out.print("What is the new color? ");
                            vehicle.setColor(scnr.nextLine());
                            break;
                        // User wants to change the make.
                        case "2":
                            // Ask what the new make is.
                            System.out.print("What is the new make? ");
                            vehicle.setMake(scnr.nextLine());
                            break;
                        // User wants to change the mileage.
                        case "3":
                            // Ask what the new mileage is.
                            System.out.print("What is the new mileage? ");
                            vehicle.setMileage(scnr.nextInt());
                            // Call the nextLine method of the Scanner to consume the errant new line that
                            // nextInt does not process.
                            scnr.nextLine();
                            break;
                        // User wants to change the model.
                        case "4":
                            // Ask what the new model is.
                            System.out.print("What is the new model? ");
                            vehicle.setModel(scnr.nextLine());
                            break;
                        // User wants to change the year.
                        case "5":
                            // Ask what the new year is.
                            System.out.print("What is the new year? ");
                            vehicle.setYear(scnr.nextInt());
                            // Call the nextLine method of the Scanner to consume the errant new line that
                            // nextInt does not process.
                            scnr.nextLine();
                            break;
                        // User wants to cancel and return to the main menu.
                        case "c":
                            // Return to the main menu.
                            return;
                        // User entered an invalid option.
                        default:
                            break;
                    }

                    // Clear the screen before continuing.
                    ClearScreen();
                } while (true);
            }
        }

        // Inform the user that no vehicle with a matching VIN was found.
        System.out.println();
        System.out.print("No vehicle was found with a VIN that matches ");
        System.out.println(vin);

        // Pause so the user can see the output.
        Pause();
    }

    // This function will search the master list for a vehicle with a VIN that
    // matches
    // the users input and then delete the vehicle from the list.
    private static void DeleteVehicle(String vin) {
        // Initialize an Automobile object to store the vehicle found.
        // This has to be used because you cannot remove an object from the
        // list you are iterating through in a for loop. You have to remove
        // it outside the loop.
        Automobile foundAutomobile = null;

        // Loop through the master vehicle list to find the matching VIN.
        for (Automobile vehicle : vehicleList) {
            // Check to see if the VIN matches the user input.
            if (vehicle.getVIN().equals(vin)) {
                // Matching VIN found.

                // Initialize a variable to store the users choice.
                String userChoice = "";

                // Show the user the vehicle information that was found.
                PrintVehicle(vehicle);

                // Confirm that this the user wants to delete this vehicle.
                System.out.println();
                System.out.println("    Are you sure you want to delete this vehicle from the master list?");
                System.out.println();
                System.out.print("    yes or no? ");
                userChoice = scnr.nextLine().toLowerCase();

                // Check if the user entered yes or no.
                if (userChoice.equals("yes")) {
                    // Set the found Automobile variable to the current vehicle.
                    foundAutomobile = vehicle;

                    // Break out of the for loop.
                    break;
                }
            }
        }

        // Check to see if a matching record was found.
        if (foundAutomobile != null) {
            // Remove the found vehicle from the list.
            vehicleList.remove(foundAutomobile);

            // Advise the user it was removed.
            System.out.println();
            System.out.println("Vehicle removed from master list.");
        } else {
            // Advise the user no vehicle found.
            System.out.println();
            System.out.println("No vehicle found to delete.");
        }

        // Pause so the user can see the output.
        Pause();
    }

    // This function will ask the user what field they want to search on and then
    // iterate through the master vehicle list and return an ArrayList of all the
    // vehicles found that match the specified search criteria.
    private static ArrayList<Automobile> FindVehicles() {
        // Initialize an ArrayList to store the found vehicles
        ArrayList<Automobile> results = new ArrayList<Automobile>();

        // Initialize a variable to store the users choice.
        String userChoice = "";

        // Find out what field the user would like to search on.
        System.out.println();
        System.out.println("    Which field would you like to search?");
        System.out.println("        1: Color");
        System.out.println("        2: Make");
        System.out.println("        3: Mileage");
        System.out.println("        4: Model");
        System.out.println("        5: Year");
        System.out.println("        C: Cancel");
        System.out.println();
        System.out.print("    Choice: ");

        // Get the users choice.
        userChoice = scnr.nextLine().toLowerCase();

        // Determine which option the user chose.
        switch (userChoice) {
            // User wants to search by color.
            case "1":
                // Ask the user what to search for.
                System.out.println("    What color would you like to search for?");
                System.out.println();
                System.out.print("    Color: ");

                // Get the users input.
                userChoice = scnr.nextLine();

                // Loop through the master list for all matching records.
                for (Automobile vehicle : vehicleList) {
                    // Check if the current vehicle color matches the user input.
                    if (vehicle.getColor().equals(userChoice)) {
                        // A matching entry was found.

                        // Add the current vehicle to the results.
                        results.add(vehicle);
                    }
                }
                break;
            // User wants to search by make.
            case "2":
                // Ask the user what to search for.
                System.out.println("    What make would you like to search for?");
                System.out.println();
                System.out.print("    Make: ");

                // Get the users input.
                userChoice = scnr.nextLine();

                // Loop through the master list for all matching records.
                for (Automobile vehicle : vehicleList) {
                    // Check if the current vehicle make matches the user input.
                    if (vehicle.getMake().equals(userChoice)) {
                        // A matching entry was found.

                        // Add the current vehicle to the results.
                        results.add(vehicle);
                    }
                }
                break;
            // User wants to search by mileage.
            case "3":
                // Ask the user what to search for.
                System.out.println("    What mileage would you like to search for?");
                System.out.println();
                System.out.print("    Mileage: ");

                // Get the users input.
                userChoice = scnr.nextLine();

                // Loop through the master list for all matching records.
                for (Automobile vehicle : vehicleList) {
                    // Check if the current vehicle mileage matches the user input.
                    // The users input has to be converted to an int since we are
                    // reusing the userChoice String variable.
                    if (vehicle.getMileage() == Integer.parseInt(userChoice)) {
                        // A matching entry was found.

                        // Add the current vehicle to the results.
                        results.add(vehicle);
                    }
                }
                break;
            // User wants to search by model.
            case "4":
                // Ask the user what to search for.
                System.out.println("    What model would you like to search for?");
                System.out.println();
                System.out.print("    Model: ");

                // Get the users input.
                userChoice = scnr.nextLine();

                // Loop through the master list for all matching records.
                for (Automobile vehicle : vehicleList) {
                    // Check if the current vehicle model matches the user input.
                    if (vehicle.getModel().equals(userChoice)) {
                        // A matching entry was found.

                        // Add the current vehicle to the results.
                        results.add(vehicle);
                    }
                }
                break;
            // User wants to search by year.
            case "5":
                // Ask the user what to search for.
                System.out.println("    What year would you like to search for?");
                System.out.println();
                System.out.print("    Year: ");

                // Get the users input.
                userChoice = scnr.nextLine();

                // Loop through the master list for all matching records.
                for (Automobile vehicle : vehicleList) {
                    // Check if the current vehicle year matches the user input.
                    // The users input has to be converted to an int since we are
                    // reusing the userChoice String variable.
                    if (vehicle.getYear() == Integer.parseInt(userChoice)) {
                        // A matching entry was found.

                        // Add the current vehicle to the results.
                        results.add(vehicle);
                    }
                }
                break;
            // User wants to cancel the search.
            case "c":
                break;
            // User entered an invalid choice.
            default:
                break;
        }

        // Return the ArrayList of found vehicles.
        return results;
    }

    // This function will print out the entire master vehicle list.
    private static void PrintVehicleList() {
        if (vehicleList.size() > 0) {
            // Loop through the master vehicle list.
            for (Automobile vehicle : vehicleList) {
                // Output the vehicles information.
                PrintVehicle(vehicle);
            }
        } else {
            // Advise user that there are no vehicles in the list.
            System.out.println("There are no vehicles in the list.");
        }

        // Pause so the user can view the output.
        Pause();
    }

    // This function will print out all the vehicles in the provided list.
    private static void PrintVehicleList(ArrayList<Automobile> list) {
        if (vehicleList.size() > 0) {
            // Loop through the provided list.
            for (Automobile vehicle : list) {
                // Output the vehicles information.
                PrintVehicle(vehicle);
            }
        } else {
            // Advise user that there are no vehicles in the list.
            System.out.println("There are no vehicles in the list.");
        }

        // Pause so the user can view the output.
        Pause();
    }

    // This function will print out all the details for the specified vehicle.
    private static void PrintVehicle(Automobile vehicle) {
        // Print the vehicles information to the console.
        System.out.print("  VIN: ");
        System.out.println(vehicle.getVIN());
        System.out.print("  Year: ");
        System.out.println(vehicle.getYear());
        System.out.print("  Make: ");
        System.out.println(vehicle.getMake());
        System.out.print("  Model: ");
        System.out.println(vehicle.getModel());
        System.out.print("  Color: ");
        System.out.println(vehicle.getColor());
        System.out.print("  Mileage: ");
        System.out.println(vehicle.getMileage());
        System.out.println();
    }

    // This function will prompt the user to press enter to continue and then clear
    // the screen. This is used to pause the program to allow the user to see the
    // output before continuing.
    private static void Pause() {
        // Advise the user to press enter to continue.
        System.out.println();
        System.out.println("Press ENTER to continue...");

        // Wait for the user to press enter.
        scnr.nextLine();

        // Clear the console before continuing.
        ClearScreen();
    }

    // This function will clear the console screen.
    private static void ClearScreen() {
        // Call the cls command from the Runtime Exec object.
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
