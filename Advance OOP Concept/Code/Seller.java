public class Seller extends User implements Discountable {
    protected Car[] listings;
    protected int   listingCount;
    public Seller(String name, String email) {
        super(name, email);
        listings     = new Car[10];
        listingCount = 0;
    }
    public void addListing(Car car) {
        if (listingCount < listings.length) listings[listingCount++] = car;
    }
    public void displayListings() {
        System.out.println("--- " + name + "'s Listings ---");
        for (int i = 0; i < listingCount; i++) listings[i].displayInfo();
    }
    public double applyDiscount(double amt) {
        return amt * 0.92;
    }
    public double applyDiscount(double amt, double rate) {
        return amt * (1 - rate);
    }
    public void displayDetails() {
        System.out.println("Seller | Name: " + name + "  Email: " + email
                + "  Listings: " + listingCount);
    }
    public void displayDetails(boolean showEmail) {
        System.out.print("Seller | Name: " + name);
        if (showEmail) System.out.print("  Email: " + email);
        System.out.println();
    }
}