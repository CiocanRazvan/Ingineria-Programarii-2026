public class Order {

    private static Long idCounter = 1L;

    private Long orderId;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private double totalPrice;
    private Customer customer;
    private List<OrderItem> items;
    private Payment payment;
    private Shipment shipment;
    private Address deliveryAddress;
    private Discount appliedDiscount;

    public Order();
    public Order(Customer customer, List<OrderItem> items, Address deliveryAddress, PaymentMethod paymentMethod);

    public void confirm();
    public void ship();
    public void deliver();
    public void cancel();
    public void requestReturn();
    public double calculateTotal();
    public boolean canBeCancelled();

    public Long getOrderId();
    public LocalDateTime getOrderDate();
    public OrderStatus getStatus();
    public void setStatus(OrderStatus status);
    public double getTotalPrice();
    public void setTotalPrice(double totalPrice);
    public Customer getCustomer();
    public void setCustomer(Customer customer);
    public List<OrderItem> getItems();
    public void setItems(List<OrderItem> items);
    public Payment getPayment();
    public void setPayment(Payment payment);
    public Shipment getShipment();
    public void setShipment(Shipment shipment);
    public Address getDeliveryAddress();
    public void setDeliveryAddress(Address deliveryAddress);
    public Discount getAppliedDiscount();
    public void setAppliedDiscount(Discount discount);

    @Override
    public String toString();
}