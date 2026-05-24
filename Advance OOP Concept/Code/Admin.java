public class Admin extends User {
    private static int adminCount = 0;
    public Admin(String name, String email) {
        super(name, email);
        adminCount++;
    }
    public void approveListing(Car car) {
        System.out.println("Admin " + name + " approved: " + car.getListingId());
    }
    public void approveListing(Car car, String comment) {
        approveListing(car);
        System.out.println("  Admin comment: " + comment);
    }
    public void displayDetails() {
        System.out.println("Admin  | Name: " + name + "  Email: " + email);
    }
    public void displayDetails(boolean showEmail) {
        System.out.print("Admin  | Name: " + name);
        if (showEmail) System.out.print("  Email: " + email);
        System.out.println();
    }
    public static int getAdminCount() { return adminCount; }
}