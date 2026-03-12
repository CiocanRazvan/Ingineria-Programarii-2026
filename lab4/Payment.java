import java.time.LocalDateTime;

public class Payment {

    private static Long idCounter = 1L;

    private Long paymentId;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime transactionDate;
    private Order order;

    public Payment() {
        this.paymentId = idCounter++;
        this.status = PaymentStatus.PENDING;
    }

    public Payment(Order order, double amount, PaymentMethod method) {
        this();
        this.order = order;
        this.amount = amount;
        this.method = method;
    }

    public boolean processPayment() {
        switch (method) {
            case CARD:
                return processCardPayment();
            case CASH_ON_DELIVERY:
                return processCashOnDelivery();
            case INSTALLMENTS:
                return processInstallments();
            case VOUCHER:
                return processVoucher();
            default:
                return false;
        }
    }

    private boolean processCardPayment() {
        this.status = PaymentStatus.COMPLETED;
        this.transactionDate = LocalDateTime.now();
        return true;
    }

    private boolean processCashOnDelivery() {
        this.status = PaymentStatus.PENDING;
        this.transactionDate = LocalDateTime.now();
        return true;
    }

    private boolean processInstallments() {
        this.status = PaymentStatus.COMPLETED;
        this.transactionDate = LocalDateTime.now();
        return true;
    }

    private boolean processVoucher() {
        this.status = PaymentStatus.COMPLETED;
        this.transactionDate = LocalDateTime.now();
        return true;
    }

    public boolean issueRefund() {
        if (status == PaymentStatus.COMPLETED) {
            status = PaymentStatus.REFUNDED;
            return true;
        }
        return false;
    }

    public void failPayment() {
        this.status = PaymentStatus.FAILED;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amount=" + amount +
                ", method=" + method +
                ", status=" + status +
                '}';
    }
}
