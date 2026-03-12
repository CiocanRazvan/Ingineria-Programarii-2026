import java.time.LocalDate;
import java.util.UUID;

public class Shipment {

    private static Long idCounter = 1L;

    private Long shipmentId;
    private String trackingNumber;
    private String carrier;
    private LocalDate estimatedDelivery;
    private ShipmentStatus status;
    private Order order;
    private Address deliveryAddress;

    public Shipment() {
        this.shipmentId = idCounter++;
        this.trackingNumber = UUID.randomUUID().toString().substring(0, 10).toUpperCase();
        this.status = ShipmentStatus.PENDING;
        this.estimatedDelivery = LocalDate.now().plusDays(5);
    }

    public Shipment(Order order, Address deliveryAddress, String carrier) {
        this();
        this.order = order;
        this.deliveryAddress = deliveryAddress;
        this.carrier = carrier;
    }

    public void markAsShipped() {
        this.status = ShipmentStatus.SHIPPED;
    }

    public void markAsDelivered() {
        this.status = ShipmentStatus.DELIVERED;
    }

    public void updateStatus(ShipmentStatus status) {
        this.status = status;
    }

    public boolean isDelivered() {
        return status == ShipmentStatus.DELIVERED;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public LocalDate getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(LocalDate estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "trackingNumber='" + trackingNumber + '\'' +
                ", carrier='" + carrier + '\'' +
                ", status=" + status +
                ", estimatedDelivery=" + estimatedDelivery +
                '}';
    }
}
