public class Main {
    public static void main(String[] args) {
        // ── Create Users
        Buyer buyer = new Buyer("Wajiha", "wajiha@example.com");
        Seller seller = new Seller("Ali", "ali@example.com");
        Admin admin = new Admin("Admin1", "admin@example.com");
        PremiumSeller premiumSeller = new PremiumSeller("Sara", "sara@example.com", "Gold");
        // ── Create Vehicles
        Car corolla = new Car("Toyota",  "Corolla",  2020, 3_000_000, 25_000, "Petrol");
        Car civic = new Car("Honda",   "Civic",    2022, 3_800_000, 10_000, "Petrol");
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2023, 8_000_000, 5_000, 500);
        LuxuryCar bmw = new LuxuryCar("BMW", "7 Series", 2023, 15_000_000.0, 2_000, "Petrol", new String[]{"Heated Seats", "Sunroof", "Massage Seats"});
        Bike cd70 = new Bike("Honda",  "CD70",     2021,   100_000,  5_000, "Standard");
        Bike ybr = new Bike("Yamaha", "YBR 125",  2022,   250_000,  8_000, "Sport");
        // ── Create Payments
        Payment onlinePay = new OnlinePayment(3_000_000, "JazzCash");
        Payment cashPay   = new CashPayment(3_800_000, "Dealer Office");
        System.out.println("----------------------------------------------------");
        System.out.println("        PAKWHEELS — CAR MARKETPLACE DEMO         ");
        System.out.println("----------------------------------------------------");
        // ── Registered Users
        System.out.println("\n[ Registered Users ]");
        buyer.displayDetails();
        seller.displayDetails();
        admin.displayDetails();
        premiumSeller.displayDetails();
        System.out.println("Total admins on platform: " + Admin.getAdminCount());
        // ── Vehicle Listings
        System.out.println("\n[ Available Vehicle Listings ]");
        corolla.displayInfo();
        civic.displayInfo();
        tesla.displayInfo();
        bmw.displayInfo();
        cd70.displayInfo();
        ybr.displayInfo();
        // ── Seller Adds Listings
        System.out.println("\n[ Sellers Adding Their Listings ]");
        seller.addListing(corolla);
        seller.addListing(civic);
        premiumSeller.addListing(bmw);
        premiumSeller.addBikeListing(cd70);
        premiumSeller.addBikeListing(ybr);
        seller.displayListings();
        premiumSeller.displayListings();
        premiumSeller.displayBikeListings();
        // ── Admin Approves
        System.out.println("\n[ Admin Approvals ]");
        admin.approveListing(corolla, "All documents verified");
        admin.approveListing(bmw, "Verified luxury listing — document check passed");
        // ── Buyer Browses & Saves Favorites
        System.out.println("\n[ Buyer Browsing & Adding Favourites ]");
        buyer.addFavorite(corolla);
        buyer.addFavorite(tesla, "Top choice for eco-friendly driving");
        buyer.viewFavorites();
        // ── Search Demo
        System.out.println("\n[ Search Results for 'toyota' ]");
        Searchable[] searchables = { corolla, civic, tesla, cd70, ybr };
        for (Searchable s : searchables)
            if (s.matchesQuery("toyota"))
                System.out.println("  Match found: " + ((Vehicle) s).getBrand()
                        + " " + ((Vehicle) s).getModel());
        System.out.println("\n[ Search Results for 'yamaha' ]");
        for (Searchable s : searchables)
            if (s.matchesQuery("yamaha"))
                System.out.println("  Match found: " + ((Vehicle) s).getBrand() + " " + ((Vehicle) s).getModel());
        // ── Tax Calculations
        System.out.println("\n[ Tax Calculations per Vehicle ]");
        Vehicle[] vehicles = { corolla, tesla, bmw, cd70 };
        for (Vehicle v : vehicles) v.calculateTax();
        // ── Discount Comparison
        System.out.println("\n[ Discount Applied on Rs.3,000,000 ]");
        Discountable[] discountables = { corolla, seller, premiumSeller, (CashPayment) cashPay };
        for (Discountable d : discountables)
            System.out.printf("  %-18s → Rs.%,.0f%n",
                    d.getClass().getSimpleName(), d.applyDiscount(3_000_000));
        // ── Marketplace & DataStore
        System.out.println("\n[ Marketplace Loaded ]");
        Marketplace market = new Marketplace("PakWheels Marketplace");
        market.addCar(corolla);
        market.addCar(civic);
        market.addCar(tesla);
        market.addCar(bmw);
        Marketplace.PromoBanner.displayWelcome();
        Marketplace.PromoBanner banner = new Marketplace.PromoBanner("SUMMER SALE — Up to 15% off all listings!");
        banner.display();
        Marketplace.MemberInner dashboard = market.new MemberInner();
        dashboard.showStats();
        dashboard.showMostExpensive();
        System.out.println();
        market.filterByBudget(4_000_000);
        System.out.println("\n[ Sorted by Price ]");
        market.sortByPrice();
        market.displayAllCars();
        // ── DataStore<Car>
        System.out.println("\n[ DataStore — Car Inventory ]");
        DataStore<Car> carStore = new DataStore<>(10);
        carStore.add(corolla);
        carStore.add(civic);
        carStore.add(tesla);
        carStore.add(bmw);
        carStore.displayAll();
        System.out.println("\nSearching for Corolla:");
        carStore.search(corolla);
        System.out.println("\nSwapping index 0 and 3:");
        carStore.swap(0, 3);
        carStore.displayAll();
        System.out.println("\nSorted by price (ascending):");
        carStore.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        carStore.displayAll();
        System.out.println("\n[ DataStore — Bike Inventory ]");
        DataStore<Bike> bikeStore = new DataStore<>(5);
        bikeStore.add(cd70);
        bikeStore.add(ybr);
        bikeStore.displayAll();
        bikeStore.swap(0, 1);
        bikeStore.displayAll();
        // ── Generic Utilities
        System.out.println("\n[ Generic Utilities ]");
        Double[] prices  = { 3_000_000.0, 8_000_000.0, 15_000_000.0, 100_000.0 };
        String[] brands  = { "Toyota", "Honda", "BMW", "Tesla" };
        System.out.println("Most expensive in array: Rs." + DataStore.findMax(prices));
        System.out.println("Lexicographic max brand: "    + DataStore.findMax(brands));
        Car[] allCars = { corolla, civic, tesla, bmw };
        int expensiveCount = DataStore.countMatching(allCars, car -> car.getPrice() > 5_000_000);
        int electricCount  = DataStore.countMatching(allCars, car -> car instanceof ElectricCar);
        System.out.println("Cars priced above Rs.5,000,000: " + expensiveCount);
        System.out.println("Electric cars in listing: "       + electricCount);
        DataStore.printAll(brands);
        // ── Payment Processing
        System.out.println("\n[ Payment Processing ]");
        onlinePay.processPayment();
        cashPay.processPayment();
        System.out.println("\n[ Final Purchase — Corolla via EasyPaisa ]");
        Payment finalPayment = new OnlinePayment(3_000_000, "EasyPaisa");
        finalPayment.processPayment();
        double discounted = finalPayment.applyDiscount(3_000_000);
        double tax        = finalPayment.calculateTax(discounted);
        System.out.printf("  Original price : Rs.%,.0f%n", 3_000_000.0);
        System.out.printf("  After discount : Rs.%,.0f%n", discounted);
        System.out.printf("  Tax (15%%)      : Rs.%,.0f%n", tax);
        System.out.printf("  Final payable  : Rs.%,.0f%n", discounted + tax);
        System.out.println("\n---------------------------------------------------");
        System.out.println("          Transaction complete. Drive safe!        ");
        System.out.println("-----------------------------------------------------");
    }
}