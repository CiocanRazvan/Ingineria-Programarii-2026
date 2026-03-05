public class OrderItem {

    private static Long idCounter = 1L;

    private Long orderItemId;
    private int quantity;
    private double unitPrice;
    private double subtotal;
    private Order order;
    private Product product;

    public OrderItem();
    public OrderItem(Order order, Product product, int quantity);

    public double calculateSubtotal();

    public Long getOrderItemId();
    public int getQuantity();
    public void setQuantity(int quantity);
    public double getUnitPrice();
    public void setUnitPrice(double unitPrice);
    public double getSubtotal();
    public Order getOrder();
    public void setOrder(Order order);
    public Product getProduct();
    public void setProduct(Product product);

    @Override
    public String toString();
}