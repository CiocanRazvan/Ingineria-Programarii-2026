public class OrderItem {

    private static Long idCounter = 1L;

    private Long orderItemId;
    private int quantity;
    private double unitPrice;
    private double subtotal;
    private Order order;
    private Product product;

    public OrderItem() {
        this.orderItemId = idCounter++;
        this.quantity = 0;
        this.unitPrice = 0.0;
        this.subtotal = 0.0;
    }

    public OrderItem(Order order, Product product, int quantity) {
        this();
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
        this.subtotal = calculateSubtotal();
    }

    public double calculateSubtotal() {
        return quantity * unitPrice;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = calculateSubtotal();
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        this.subtotal = calculateSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product='" + product.getName() + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                '}';
    }
}
