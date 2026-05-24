public class Car extends Vehicle implements Searchable, Discountable {
    private final String listingId;
    private static int carCount = 0;
    protected String fuelType;
    public Car(String brand, String model, int year, double price, int mileage, String fuelType) {
        super(brand, model, year, price, mileage);
        this.fuelType = fuelType;
        listingId = "CAR" + (++carCount);
    }
    public void calculateTax() {
        System.out.println("Car Tax (" + listingId + "): Rs." + (price * 0.10));
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Fuel: " + fuelType + "  ID: " + listingId);
    }
    public boolean matchesQuery(String query) {
        String q = query.toLowerCase();
        return brand.toLowerCase().contains(q) || model.toLowerCase().contains(q);
    }
    public double applyDiscount(double amt) {
        return amt * 0.95;
    }
    public double applyDiscount(double amt, double rate) {
        return amt * (1 - rate);
    }
    public String getListingId() { return listingId; }
    public String getFuelType()  { return fuelType; }
}