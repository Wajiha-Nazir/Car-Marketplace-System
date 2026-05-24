public class Listing {
    private final Car car;
    private Seller seller;
    private boolean approved;
    private final String listingId;
    public Listing(Car car, Seller seller) {
        this.car = car;
        this.seller = seller;
        this.approved = false;
        this.listingId = "LIST-" + car.getCarCount();
    }
    public void approve() { approved = true; }
    public void reject() { approved = false; }
    public void displayListing() {
        System.out.println("Listing ID: " + listingId + " Approved: " + approved);
        car.displayInfo();
    }
    public boolean isApproved() { return approved; }
}
