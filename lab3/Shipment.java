public class Shipment {

    private static Long idCounter = 1L;

    private Long shipmentId;
    private String trackingNumber;
    private String carrier;
    private LocalDate estimatedDelivery;
    private ShipmentStatus status;
    private Order order;
    private Address deliveryAddress;

    public Shipment();
    public Shipment(Order order, Address deliveryAddress, String carrier);

    public void markAsShipped();
    public void markAsDelivered();
    public void updateStatus(ShipmentStatus status);
    public boolean isDelivered();

    public Long getShipmentId();
    public String getTrackingNumber();
    public void setTrackingNumber(String trackingNumber);
    public String getCarrier();
    public void setCarrier(String carrier);
    public LocalDate getEstimatedDelivery();
    public void setEstimatedDelivery(LocalDate estimatedDelivery);
    public ShipmentStatus getStatus();
    public void setStatus(ShipmentStatus status);
    public Order getOrder();
    public void setOrder(Order order);
    public Address getDeliveryAddress();
    public void setDeliveryAddress(Address deliveryAddress);

    @Override
    public String toString();
}