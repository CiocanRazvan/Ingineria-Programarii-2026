import java.time.LocalDateTime;

public class Review {
    private Long reviewId;
    private int rating;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private boolean isVerified;

    private Customer customer;
    private Product product;

    public Review(Long reviewId, int rating, String title, String body, boolean isVerified, Customer customer, Product product) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.title = title;
        this.body = body;
        this.createdAt = LocalDateTime.now();
        this.isVerified = isVerified;
        this.customer = customer;
        this.product = product;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}