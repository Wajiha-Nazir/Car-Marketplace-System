public class OnlinePayment extends Payment {
    private String transactionId;
    public OnlinePayment(double amount, String gateway) {
        super(amount, gateway);
        this.transactionId = "TXN" + System.currentTimeMillis();
    }
    public void processPayment() {
        System.out.println("Online Payment of Rs." + amount + " via " + method
                + "  [Transaction ID: " + transactionId + "]");
    }
    public double applyDiscount(double amt, double rate) {
        return amt * (1 - rate);
    }
}