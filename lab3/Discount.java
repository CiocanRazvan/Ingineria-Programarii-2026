public class Discount {

    private static Long idCounter = 1L;

    private Long discountId;
    private String code;
    private DiscountType discountType;
    private double value;
    private LocalDate expiryDate;
    private int maxUsages;
    private int usageCount;

    public Discount();
    public Discount(String code, DiscountType discountType, double value, LocalDate expiryDate, int maxUsages);

    public boolean isValid();
    public boolean isExpired();
    public boolean hasUsagesLeft();
    public double applyDiscount(double originalPrice);
    public void incrementUsage();

    public Long getDiscountId();
    public String getCode();
    public void setCode(String code);
    public DiscountType getDiscountType();
    public void setDiscountType(DiscountType discountType);
    public double getValue();
    public void setValue(double value);
    public LocalDate getExpiryDate();
    public void setExpiryDate(LocalDate expiryDate);
    public int getMaxUsages();
    public void setMaxUsages(int maxUsages);
    public int getUsageCount();

    @Override
    public String toString();
}