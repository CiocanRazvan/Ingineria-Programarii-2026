public class Payment {

    private static Long idCounter = 1L;

    private Long paymentId;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime transactionDate;
    private Order order;

    public Payment();

    public Payment(Order order, double amount, PaymentMethod method);

    public boolean processPayment() ;

    private boolean processCardPayment() ;

    private boolean processCashOnDelivery() ;

    private boolean processInstallments();

    private boolean processVoucher() ;

    public boolean issueRefund() ;

    public void failPayment() ;


    public Long getPaymentId() ;
    public double getAmount() ;
    public void setAmount(double amount);
    public PaymentMethod getMethod();
    public void setMethod(PaymentMethod method);
    public PaymentStatus getStatus() ;
    public void setStatus(PaymentStatus status) ;
    public LocalDateTime getTransactionDate() ;
    public Order getOrder();
    public void setOrder(Order order);


    @Override
    public String toString() ;
}