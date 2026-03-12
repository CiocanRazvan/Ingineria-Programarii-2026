public class Seller extends User {

    private String storeName;
    private double rating;
    private boolean isVerified;
    private double commissionRate;

    public Seller(String firstName, String secName, String email, String phoneNumber,
                  String password, String username, String storeName, double rating,
                  boolean isVerified, double commissionRate) {

        super(firstName, secName, email, phoneNumber, password, username);
        this.storeName = storeName;
        this.rating = rating;
        this.isVerified = isVerified;
        this.commissionRate = commissionRate;
    }

    public void listProduct(Product product) {
    }

    public void updateStock(long productId, int qty) {
    }

    public void respondToReview(long reviewId) {
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}