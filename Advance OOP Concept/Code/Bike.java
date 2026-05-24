public class Bike extends Vehicle implements Searchable {
    private final String listingId;
    private static int bikeCount = 0;
    private String type;
    public Bike(String brand, String model, int year, double price, int mileage, String type) {
        super(brand, model, year, price, mileage);
        this.type = type;
        listingId  = "BIKE" + (++bikeCount);
    }
    public void calculateTax() {
        System.out.println("Bike Tax (" + listingId + "): Rs." + (price * 0.05));
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Type: " + type + "  ID: " + listingId);
    }
    public boolean matchesQuery(String query) {
        String q = query.toLowerCase();
        return brand.toLowerCase().contains(q) || model.toLowerCase().contains(q);
    }
    public String getListingId() { return listingId; }
}