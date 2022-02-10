// import java.util.Scanner;

// Declare ver and int 
public class Automobile {
    private String make = "";
    private String model = "";
    private String color = "";
    private int year = 0;
    private int mileage = 0;

    // Parameterized Constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    public String getCarMake() {
        return make;
    }

    public void setCarMake(String make) {
        this.make = make;
    }

    public String getCarModel() {
        return model;
    }

    public void setCarModel(String model) {
        this.model = model;
    }

    public String getCarColor() {
        return color;
    }

    public void setCarColor(String color) {
        this.color = color;
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

    @Override
    public String toString() {
        return this.getCarYear() + " " + this.getCarMake() + " " + this.getCarModel() + " " + this.getCarColor() + " "
                + this.getCarMileage() + " Miles";
    }

}
