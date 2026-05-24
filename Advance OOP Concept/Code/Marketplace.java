import java.util.Comparator;
public class Marketplace {
    private Car[] cars;
    private int   carCount;
    private String marketplaceName;
    public Marketplace(String name) {
        this.marketplaceName = name;
        cars     = new Car[20];
        carCount = 0;
    }
    public void addCar(Car c) {
        if (carCount < cars.length) cars[carCount++] = c;
    }
    public void displayAllCars() {
        System.out.println("=== " + marketplaceName + " — All Listings ===");
        for (int i = 0; i < carCount; i++) cars[i].displayInfo();
    }
    class MemberInner {
        public void showStats() {
            // Accesses outer instance fields directly
            System.out.println("[Dashboard] " + marketplaceName
                    + " currently has " + carCount + " cars listed.");
        }
        public void showMostExpensive() {
            if (carCount == 0) { System.out.println("No cars listed."); return; }
            Car best = cars[0];
            for (int i = 1; i < carCount; i++)
                if (cars[i].getPrice() > best.getPrice()) best = cars[i];
            System.out.println("[Dashboard] Most expensive: ");
            best.displayInfo();
        }
    }
    static class PromoBanner {
        private String message;
        public PromoBanner(String message) { this.message = message; }
        public void display() {
            System.out.println("--------------------------------------");
            System.out.println("  " + message);
            System.out.println("--------------------------------------");
        }
        public static void displayWelcome() {
            System.out.println("*** Welcome to the Car Marketplace! ***");
        }
    }
    public void filterByBudget(double maxBudget) {
        class PriceFilter {
            public boolean isAffordable(Car car) {
                return car.getPrice() <= maxBudget;
            }
            public void printResult(Car car) {
                System.out.println("  [Within budget] ");
                car.displayInfo();
            }
        }
        PriceFilter filter = new PriceFilter();
        System.out.println("Cars within Rs." + maxBudget + ":");
        boolean found = false;
        for (int i = 0; i < carCount; i++) {
            if (filter.isAffordable(cars[i])) {
                filter.printResult(cars[i]);
                found = true;
            }
        }
        if (!found) System.out.println("  No cars found within that budget.");
    }
    public void sortByPrice() {
        Comparator<Car> priceComparator = new Comparator<Car>() {
            public int compare(Car a, Car b) {
                return Double.compare(a.getPrice(), b.getPrice());
            }
        };
        for (int i = 1; i < carCount; i++) {
            Car key = cars[i];
            int j   = i - 1;
            while (j >= 0 && priceComparator.compare(cars[j], key) > 0) {
                cars[j + 1] = cars[j];
                j--;
            }
            cars[j + 1] = key;
        }
        System.out.println("Cars sorted by price (ascending).");
    }
}