import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private static Long idCounter = 1L;

    private Long productId;
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private double rating;
    private int reviewCount;
    private LocalDateTime createdAt;
    private boolean disponibil;
    private Seller seller;
    private Category category;
    private List<ProductImage> images;
    private List<Review> reviews;

    public Product() {
        this.productId = idCounter++;
        this.createdAt = LocalDateTime.now();
        this.disponibil = true;
        this.images = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.rating = 0.0;
        this.reviewCount = 0;
    }

    public Product(String name, String description, double price, int stock, Seller seller, Category category) {
        this();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
        this.category = category;
    }

    public Product(String id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public void updateStock(int quantity) {
        this.stock = quantity;
    }

    public boolean isInStock() {
        return stock > 0;
    }

    public void addImage(ProductImage image) {
        images.add(image);
    }

    public void removeImage(int imgId) {
        images.removeIf(img -> img.getImageId() == imgId);
    }

    public double getAverageRating() {
        return rating;
    }

    public void addInCart() {
        if (stock > 0) {
            stock--;
        }
    }

    public void removeFromCart() {
        stock++;
    }

    public Long getProductId() {
        return productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
