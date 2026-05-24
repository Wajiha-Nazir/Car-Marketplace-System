public class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private int mileage;
    private final String listingId;
    private static int carCount = 0;
    public Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.price = 0.0;
        this.mileage = 0;
        this.listingId = "CAR" + (++carCount);
    }
    public Car(String brand, String model, int year, double price, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.listingId = "CAR" + (++carCount);
    }
    public Car(Car other) {
        this.brand = other.brand;
        this.model = other.model;
        this.year = other.year;
        this.price = other.price;
        this.mileage = other.mileage;
        this.listingId = other.listingId;
    }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public int getMileage() { return mileage; }
    public String getListingId() { return listingId; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setPrice(double price) { this.price = price; }
    public void setMileage(int mileage) { this.mileage = mileage; }
    public void updatePrice(double newPrice) { this.price = newPrice; }
    public void updateMileage(int newMileage) { this.mileage = newMileage; }
    public void displayInfo() {
        System.out.println(brand + " " + model + " (" + year + ") - " + price + ", Mileage: " + mileage);
    }
    public static int getCarCount() { return carCount; }
}
