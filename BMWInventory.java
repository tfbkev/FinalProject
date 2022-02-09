// import java.util.Scanner;

public class BMWInventory {
    private String make="";
    private String model="";
    private String color="";
    private int year=0;
    private int mileage=0;

    public BMWInventory(String make, String model, String color, int year, int mileage) {
        this.make = make="";
        this.model = model="";
        this.color = color="";
        this.year = year=0;
        this.mileage = mileage=0;
    }

    public String getCarMake() {
        return make;
    }

    public void setCarMake(String string) {
        this.make = string;
    }

    public String getCarModel() {
        return model;
    }

    public void setCarModel(String string) {
        this.model = string;
    }

    public String getCarColor() {
        return color;
    }

    public void setCarColor(String string) {
        this.color = string;
    }

    public int getCarYear() {
        return year;
    }

    public void setCarYear(int year) {
        this.year = year;
    }

    public int getCarMileage() {
        return mileage;
    }

    public void setCarMileage(int mileage) {
        this.mileage = mileage;
    }

    public String toSearch(String theAnswerEnter) throws IllegalArgumentException {
        final String enterSearch = "Search";
        if (theAnswerEnter.equals(enterSearch)) {
            return"Car make: " + make + " Car model: " + model + " Car color: " + color + " Car year: " + year
                    + " Car mileage: " + mileage;
        }
        throw new IllegalArgumentException("Error");

    }
}
