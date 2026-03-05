import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private Long wishlistId;
    private LocalDateTime createdAt;
    private List<Product> products;

    public Wishlist(Long wishlistId) {
        this.wishlistId = wishlistId;
        this.createdAt = LocalDateTime.now();
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
    }

    public void removeProduct(Product product) {
    }

    public Long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}