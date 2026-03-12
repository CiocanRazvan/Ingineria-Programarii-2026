import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Order() {
        this.orderId = idCounter++;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public Order(Customer customer, List<OrderItem> items, Address deliveryAddress, PaymentMethod paymentMethod) {
        this();
        this.customer = customer;
        this.items = items;
        this.deliveryAddress = deliveryAddress;
        this.payment = new Payment(this, calculateTotal(), paymentMethod);
        this.totalPrice = calculateTotal();
    }

    public void confirm() {
        if (status == OrderStatus.PENDING) {
            status = OrderStatus.CONFIRMED;
        }
    }

    public void ship() {
        if (status == OrderStatus.CONFIRMED) {
            status = OrderStatus.SHIPPED;
            shipment = new Shipment(this, deliveryAddress, "Standard Courier");
            shipment.markAsShipped();
        }
    }

    public void deliver() {
        if (status == OrderStatus.SHIPPED) {
            status = OrderStatus.DELIVERED;
            if (shipment != null) {
                shipment.markAsDelivered();
            }
        }
    }

    public void cancel() {
        if (canBeCancelled()) {
            status = OrderStatus.CANCELLED;
        }
    }

    public void requestReturn() {
        if (status == OrderStatus.DELIVERED) {
            status = OrderStatus.RETURNED;
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.calculateSubtotal();
        }
        if (appliedDiscount != null) {
            total = appliedDiscount.applyDiscount(total);
        }
        return total;
    }

    public boolean canBeCancelled() {
        return status == OrderStatus.PENDING || status == OrderStatus.CONFIRMED;
    }

    public Long getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Discount getAppliedDiscount() {
        return appliedDiscount;
    }

    public void setAppliedDiscount(Discount discount) {
        this.appliedDiscount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
