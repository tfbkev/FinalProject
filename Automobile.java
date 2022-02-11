
public class Automobile {
    // Private variables to store the information about the vehicle.
    // The color of the vehicle. (e.g. White, Blue, Green, etc...)
    private String color;
    // The make of the vehicle. (e.g. BMW, Chevrolet, Ford, etc...)
    private String make;
    // The model of the vehicle. (e.g. Malibu, F150, Corvette, etc...)
    private String model;
    // The vehicle identification number for the vehicle.
    // This will be used to verify that each vehicle record is unique
    // and easy to locate in the vehicle list.
    private String vin;
    // The year the vehicle was made.
    // Should be between 1886 and the current year + 1.
    private int year;
    // The mileage of the vehicle.
    // Should be 0 or greater.
    private int mileage;

    // The default constructor
    // This is included to make it easier to use in a loop.
    public Automobile() {
        // Initialize all the string variables to an empty string.
        color = make = model = vin = "";
        // Initialize all the integer variables to 0;
        year = mileage = 0;
    }

    // A constructor that takes all the vehicle information and initializes the
    // private variables
    // to the information provided.
    public Automobile(String make, String model, String color, String vin, int year, int mileage) {
        this.color = color;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.year = year;
        this.mileage = mileage;
    }

    // A setter method to set the color of the vehicle.
    public void setColor(String color) {
        this.color = color;
    }

    // A getter method to get the color of the vehicle.
    public String getColor() {
        return this.color;
    }

    // A setter method to set the make of the vehicle.
    public void setMake(String make) {
        this.make = make;
    }

    // A getter method to get the make of the vehicle.
    public String getMake() {
        return this.make;
    }

    // A setter method to set the model of the vehicle.
    public void setModel(String model) {
        this.model = model;
    }

    // A getter method to get the model of the vehicle.
    public String getModel() {
        return this.model;
    }

    // A setter method to set the VIN of the vehicle.
    public void setVIN(String vin) {
        this.vin = vin;
    }

    // A getter method to get the VIN of the vehicle.
    public String getVIN() {
        return this.vin;
    }

    // A setter method to set the year of the vehicle.
    public void setYear(int year) {
        if (year < 1886) {
            this.year = 1886;
        } else if (year > 2023) {
            this.year = 2023;
        } else {
            this.year = year;
        }
    }

    // A getter method to get the year of the vehicle.
    public int getYear() {
        return this.year;
    }

    // A setter method to set the mileage of the vehicle.
    public void setMileage(int mileage) {
        if (mileage < 0) {
            this.mileage = 0;
        } else {
            this.mileage = mileage;
        }
    }

    // A getter method to get the mileage of the vehicle.
    public int getMileage() {
        return this.mileage;
    }
}
