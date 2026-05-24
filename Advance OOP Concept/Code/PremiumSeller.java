public class PremiumSeller extends Seller {
    private Bike[] bikeListings;
    private int    bikeListingCount;
    private String badge;
    public PremiumSeller(String name, String email, String badge) {
        super(name, email);
        this.badge       = badge;
        bikeListings     = new Bike[10];
        bikeListingCount = 0;
    }
    public void addBikeListing(Bike bike) {
        if (bikeListingCount < bikeListings.length) bikeListings[bikeListingCount++] = bike;
    }
    public void displayBikeListings() {
        System.out.println("--- " + name + "'s Bike Listings ---");
        for (int i = 0; i < bikeListingCount; i++) bikeListings[i].displayInfo();
    }
    public double applyDiscount(double amt) {
        return amt * 0.85;
    }
    public void displayDetails() {
        System.out.println("Premium Seller [" + badge + "] | Name: " + name
                + "  Email: " + email + "  Car Listings: " + listingCount
                + "  Bike Listings: " + bikeListingCount);
    }
    public void displayDetails(boolean showEmail) {
        System.out.print("Premium Seller [" + badge + "] | Name: " + name);
        if (showEmail) System.out.print("  Email: " + email);
        System.out.println();
    }
}