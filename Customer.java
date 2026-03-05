public class Customer extends User {
    private int loyaltyPoints;
    private boolean newsletterSubscribed;

    private Cart cart;
    private Wishlist wishlist;
    private List<Address> addresses;
    private List<Order> orders;
    private List<Review> reviews;


    public Customer();

    public Customer(String firstName, String lastName, String email, String passwordHash, String phoneNumber) ;


    public Order placeOrder(Address deliveryAddress, PaymentMethod paymentMethod) ;

    public boolean cancelOrder(Long orderId);

    public Review writeReview(Product product, int rating, String title, String body);

    public void addToWishlist(Product product) ;

    public void addAddress(Address address) ;

    public void removeAddress(Long addressId) ;

    private boolean hasPurchasedProduct(Product product) ;

    public int getLoyaltyPoints() ;
    public void setLoyaltyPoints(int loyaltyPoints) ;

    public boolean isNewsletterSubscribed() ;
    public void setNewsletterSubscribed(boolean newsletterSubscribed) ;

    public Cart getCart() ;
    public Wishlist getWishlist() ;

    public List<Address> getAddresses() ;
    public List<Order> getOrders() ;
    public List<Review> getReviews() ;

    @Override
    public String toString() ;
}
