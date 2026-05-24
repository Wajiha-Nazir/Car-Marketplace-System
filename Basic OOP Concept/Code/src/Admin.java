public class Admin {
    private String username;
    private String role;
    private static int adminCount = 0;
    public Admin(String username, String role) {
        this.username = username;
        this.role = role;
        adminCount++;
    }
    public void approveListing(Car car) {
        System.out.println("Admin approved listing: " + car);
    }
    public void removeListing(Car car) {
        System.out.println("Admin removed listing: " + car);
    }
    public void displayAdminInfo() {
        System.out.println("Admin: " + username + " (" + role + ")");
    }
    public static int getAdminCount() { return adminCount; }
}
