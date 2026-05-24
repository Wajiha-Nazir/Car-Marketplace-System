public class Payment {
    private final String paymentId;
    private Buyer buyer;
    private Seller seller;
    private double amount;
    private String method;
    private static int paymentCount = 0;
    public Payment(Buyer buyer, Seller seller, double amount, String method) {
        this.buyer = buyer;
        this.seller = seller;
        this.amount = amount;
        this.method = method;
        this.paymentId = "PAY" + (++paymentCount);
    }
    public void processPayment() {
        System.out.println("Processing payment of " + amount + " via " + method);
    }
    public void refund() {
        System.out.println("Refunding payment ID: " + paymentId);
    }
    public void displayPayment() {
        System.out.println("Payment ID: " + paymentId + " Amount: $" + amount + " Method: " + method);
    }
    public static int getPaymentCount() { return paymentCount; }
}
