public class Review {
    private Buyer buyer;
    private Seller seller;
    private String comment;
    private int rating;
    private final long timestamp;
    public Review(Buyer buyer, Seller seller, String comment, int rating) {
        this.buyer = buyer;
        this.seller = seller;
        this.comment = comment;
        this.rating = rating;
        this.timestamp = System.currentTimeMillis();
    }
    public void editReview(String newComment, int newRating) {
        this.comment = newComment;
        this.rating = newRating;
    }
    public void displayReview() {
        System.out.println("Review by " + buyer.getFavoriteCount() + ": " + comment + " Rating: " + rating);
    }
    public int getRating() { return rating; }
    public long getTimestamp() { return timestamp; }
}
