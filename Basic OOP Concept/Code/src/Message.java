public class Message {
    private final String senderEmail;
    private final String receiverEmail;
    private String content;
    private final long timestamp;
    public Message(String senderEmail, String receiverEmail, String content) {
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }
    public void editMessage(String newContent) { this.content = newContent; }
    public void displayMessage() {
        System.out.println("From: " + senderEmail + " To: " + receiverEmail + " | " + content);
    }
    public String getContent() { return content; }
    public long getTimestamp() { return timestamp; }
}
