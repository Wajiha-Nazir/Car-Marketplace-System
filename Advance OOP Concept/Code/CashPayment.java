public class CashPayment extends Payment {
    private String receivedBy;
    public CashPayment(double amount, String receivedBy) {
        super(amount, "Cash");
        this.receivedBy = receivedBy;
    }
    public void processPayment() {
        System.out.println("Cash Payment of Rs." + amount + " received by " + receivedBy);
    }
    public double applyDiscount(double amt) {
        return amt * 0.97;
    }
    public double applyDiscount(double amt, double rate) {
        return amt * (1 - rate);
    }
}