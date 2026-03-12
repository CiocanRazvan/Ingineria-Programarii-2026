import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private int loyaltyPoints;
    private boolean newsletterSubscribed;

    private Cart cart;
    private Wishlist wishlist;
    private List<Address> addresses;
    private List<Order> orders;
    private List<Review> reviews;

    public Customer() {
        super("", "", "", "", "", "");
        this.loyaltyPoints = 0;
        this.newsletterSubscribed = false;
        this.cart = new Cart(this.getId());
        this.wishlist = new Wishlist(this.getId());
        this.addresses = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public Customer(String firstName, String lastName, String email, String passwordHash, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber, passwordHash, firstName);
        this.loyaltyPoints = 0;
        this.newsletterSubscribed = false;
        this.cart = new Cart(this.getId());
        this.wishlist = new Wishlist(this.getId());
        this.addresses = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public Order placeOrder(Address deliveryAddress, PaymentMethod paymentMethod) {
        Order order = new Order(this, new ArrayList<>(), deliveryAddress, paymentMethod);
        orders.add(order);
        return order;
    }

    public boolean cancelOrder(Long orderId) {
        return orders.removeIf(order -> order.getOrderId().equals(orderId) && order.canBeCancelled());
    }

    public Review writeReview(Product product, int rating, String title, String body) {
        if (!hasPurchasedProduct(product)) {
            return null;
        }
        Review review = new Review(System.nanoTime(), rating, title, body, true, this, product);
        reviews.add(review);
        product.getReviews().add(review);
        return review;
    }

    public void addToWishlist(Product product) {
        wishlist.addProduct(product);
    }

    public void addAddress(Address address) {
        address.setCustomer(this);
        addresses.add(address);
    }

    public void removeAddress(Long addressId) {
        addresses.removeIf(addr -> addr.getAddressId().equals(addressId));
    }

    private boolean hasPurchasedProduct(Product product) {
        return orders.stream()
                .anyMatch(order -> order.getItems().stream()
                        .anyMatch(item -> item.getProduct().equals(product)));
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public boolean isNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    public void setNewsletterSubscribed(boolean newsletterSubscribed) {
        this.newsletterSubscribed = newsletterSubscribed;
    }

    public Cart getCart() {
        return cart;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + fullNume() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
