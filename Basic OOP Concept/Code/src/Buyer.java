public class Buyer {
    private String name;
    private String email;
    private Car[] favorites;
    private int favoriteCount;
    public Buyer(String name, String email) {
        this.name = name;
        this.email = email;
        this.favorites = new Car[5];
        this.favoriteCount = 0;
    }
    public void addFavorite(Car car) {
        if(favoriteCount < favorites.length) {
            favorites[favoriteCount++] = car;
        }
    }
    public void viewFavorites() {
        for(int i=0; i<favoriteCount; i++) {
            favorites[i].displayInfo();
        }
    }
    public void sendMessage(Seller seller, String message) {
        System.out.println("Message from " + name + " to " + seller.getListingCount() + " listings: " + message);
    }
    public int getFavoriteCount() { return favoriteCount; }
}
