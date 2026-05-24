public abstract class Vehicle implements Taxable {
    protected String brand;
    protected String model;
    protected int    year;
    protected double price;
    protected int    mileage;
    public Vehicle(String brand, String model, int year, double price, int mileage) {
        this.brand   = brand;
        this.model   = model;
        this.year    = year;
        this.price   = price;
        this.mileage = mileage;
    }
    public abstract void calculateTax();
    public double calculateTax(double amount) {
        return amount * 0.10;
    }
    public void displayInfo() {
        System.out.println(brand + " " + model + " (" + year + ")  Price: Rs." + price + "  Mileage: " + mileage + " km");
    }
    public void displayInfo(boolean showTax) {
        displayInfo();
        if (showTax) calculateTax();
    }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
}