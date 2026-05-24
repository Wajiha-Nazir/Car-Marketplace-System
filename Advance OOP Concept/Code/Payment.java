public abstract class Payment implements Discountable, Taxable, Payable {
    protected double amount;
    protected String method;
    public Payment(double amount, String method) {
        this.amount = amount;
        this.method = method;
    }
    public abstract void processPayment();
    public void processPayment(String confirmationCode) {
        System.out.println("Processing " + amount + " via " + method + " Code: " + confirmationCode);
    }
    public double applyDiscount(double amt) {
        return amt * 0.90;
    }
    public double calculateTax(double amt) {
        return amt * 0.15;
    }
}