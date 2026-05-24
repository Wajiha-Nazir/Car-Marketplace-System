public class Marketplace {
    private Seller[] sellers;
    private Buyer[] buyers;
    private Car[] cars;
    private int sellerCount;
    private int buyerCount;
    private int carCount;
    public Marketplace() {
        sellers = new Seller[20];
        buyers = new Buyer[20];
        cars = new Car[50];
        sellerCount = buyerCount = carCount = 0;
    }
    public void addSeller(Seller s) { sellers[sellerCount++] = s; }
    public void addBuyer(Buyer b) { buyers[buyerCount++] = b; }
    public void addCar(Car c) { cars[carCount++] = c; }
    public void searchByBrand(String brand) {
        for(int i=0; i<carCount; i++) {
            if(cars[i].getBrand().equalsIgnoreCase(brand)) {
                cars[i].displayInfo();
            }
        }
    }
    public void displayAllCars() {
        for(int i=0; i<carCount; i++) {
            cars[i].displayInfo();
        }
    }
}
