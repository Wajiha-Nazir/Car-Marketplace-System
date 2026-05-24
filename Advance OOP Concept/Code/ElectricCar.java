public class ElectricCar extends Car {
    private int batteryRangeKm;
    private int chargePercent;
    public ElectricCar(String brand, String model, int year, double price,
                       int mileage, int batteryRangeKm) {
        super(brand, model, year, price, mileage, "Electric");
        this.batteryRangeKm = batteryRangeKm;
        this.chargePercent  = 100;
    }
    public void calculateTax() {
        System.out.println("Electric Car Tax (" + getListingId() + "): Rs."
                + (price * 0.05) + " (50% green discount applied)");
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Battery Range: " + batteryRangeKm + " km  Charge: "
                + chargePercent + "%");
    }
    public void charge() {
        chargePercent = 100;
        System.out.println(brand + " " + model + " fully charged.");
    }
    public int getBatteryRange() { return batteryRangeKm; }
}