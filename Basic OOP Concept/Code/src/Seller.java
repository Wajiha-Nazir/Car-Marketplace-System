public class Seller {
    private String name;
    private String email;
    private String phone;
    private Car[] listings;
    private int listingCount;
    public Seller(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.listings = new Car[10];
        this.listingCount = 0;
    }
    public void addListing(Car car) {
        if(listingCount < listings.length) {
            listings[listingCount++] = car;
        }
    }
    public void removeListing(String listingId) {
        for(int i=0; i<listingCount; i++) {
            if(listings[i] != null && listings[i].equals(listingId)) {
                listings[i] = listings[listingCount-1];
                listings[listingCount-1] = null;
                listingCount--;
                break;
            }
        }
    }
    public void displayListings() {
        for(int i=0; i<listingCount; i++) {
            listings[i].displayInfo();
        }
    }
    public int getListingCount() { return listingCount; }
}
