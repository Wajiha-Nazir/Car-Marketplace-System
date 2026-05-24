public class SearchEngine {
    private Car[] cars;
    private int carCount;
    public SearchEngine(Car[] cars, int carCount) {
        this.cars = cars;
        this.carCount = carCount;
    }
    public void searchByPrice(double min, double max) {
        for(int i=0; i<carCount; i++) {
            if(cars[i].getPrice() >= min && cars[i].getPrice() <= max) {
                cars[i].displayInfo();
            }
        }
    }
    public void searchByYear(int year) {
        for(int i=0; i<carCount; i++) {
            if(cars[i].getYear() == year) {
                cars[i].displayInfo();
            }
        }
    }
    public void searchByMileage(int maxMileage) {
        for(int i=0; i<carCount; i++) {
            if(cars[i].getMileage() <= maxMileage) {
                cars[i].displayInfo();
            }
        }
    }
    public void searchByModel(String model) {
        for(int i=0; i<carCount; i++) {
            if(cars[i].getModel().equalsIgnoreCase(model)) {
                cars[i].displayInfo();
            }
        }
    }
}
