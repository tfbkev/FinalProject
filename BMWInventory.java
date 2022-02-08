// import java.util.Scanner;

public class BMWInventory {
    private static String make;
    private static String model;
    private static String color;
    private static int year;
    private static int mileage;

    public BMWInventory(String make, String model, String color, int year, int mileage) {
        BMWInventory.make = make;
        BMWInventory.model = model;
        BMWInventory.color = color;
        BMWInventory.year = year;
        BMWInventory.mileage = mileage;
    }

    public String getCarMake() {
        return make;
    }

    public static void setCarMake(String string) {
        BMWInventory.make = string;
    }

    public String getCarModel() {
        return model;
    }

    public static void setCarModel(String string) {
        BMWInventory.model = string;
    }

    public String getCarColor() {
        return color;
    }

    public static void setCarColor(String string) {
        BMWInventory.color = string;
    }

    public int getCarYear() {
        return year;
    }

    public static void setCarYear(int year) {
        BMWInventory.year = year;
    }

    public int getCarMileage() {
        return mileage;
    }

    public static void setCarMileage(int mileage) {
        BMWInventory.mileage = mileage;
    }

    public static String toSearch(String theAnswerEnter) throws IllegalArgumentException {
        final String enterSearch = "Search";
        if (theAnswerEnter.equals(enterSearch)) {
            return"Car make: " + make + " Car model: " + model + " Car color: " + color + " Car year: " + year
                    + " Car mileage: " + mileage;
        }
        throw new IllegalArgumentException("Error");

    }
}