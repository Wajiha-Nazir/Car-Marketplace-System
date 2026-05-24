public class Buyer extends User {
    private Car[] favorites;
    private int   favoriteCount;
    public Buyer(String name, String email) {
        super(name, email);
        favorites     = new Car[5];
        favoriteCount = 0;
    }
    public void addFavorite(Car car) {
        if (favoriteCount < favorites.length) favorites[favoriteCount++] = car;
    }
    public void addFavorite(Car car, String note) {
        addFavorite(car);
        System.out.println("Note saved for " + car.getBrand() + ": " + note);
    }
    public void viewFavorites() {
        System.out.println("--- " + name + "'s Favorites ---");
        for (int i = 0; i < favoriteCount; i++) favorites[i].displayInfo();
    }
    public void displayDetails() {
        System.out.println("Buyer  | Name: " + name + "  Email: " + email);
    }
    public void displayDetails(boolean showEmail) {
        System.out.print("Buyer  | Name: " + name);
        if (showEmail) System.out.print("  Email: " + email);
        System.out.println();
    }
}