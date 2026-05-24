public class LuxuryCar extends Car {
    private String[] premiumFeatures;
    public LuxuryCar(String brand, String model, int year, double price,
                     int mileage, String fuelType, String[] premiumFeatures) {
        super(brand, model, year, price, mileage, fuelType);
        this.premiumFeatures = premiumFeatures;
    }
    public void calculateTax() {
        System.out.println("Luxury Car Tax (" + getListingId() + "): Rs." + (price * 0.18) + " (luxury surcharge applied)");
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.print("  Premium Features: ");
        for (String f : premiumFeatures) System.out.print(f + "  ");
        System.out.println();
    }
}