import java.time.LocalDate;

public class Discount {

    private static Long idCounter = 1L;

    private Long discountId;
    private String code;
    private DiscountType discountType;
    private double value;
    private LocalDate expiryDate;
    private int maxUsages;
    private int usageCount;

    public Discount() {
        this.discountId = idCounter++;
        this.usageCount = 0;
    }

    public Discount(String code, DiscountType discountType, double value, LocalDate expiryDate, int maxUsages) {
        this();
        this.code = code;
        this.discountType = discountType;
        this.value = value;
        this.expiryDate = expiryDate;
        this.maxUsages = maxUsages;
    }

    public boolean isValid() {
        return !isExpired() && hasUsagesLeft();
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public boolean hasUsagesLeft() {
        return usageCount < maxUsages;
    }

    public double applyDiscount(double originalPrice) {
        if (!isValid()) {
            return originalPrice;
        }
        if (discountType == DiscountType.PERCENTAGE) {
            return originalPrice * (1 - value / 100);
        } else {
            return Math.max(0, originalPrice - value);
        }
    }

    public void incrementUsage() {
        if (hasUsagesLeft()) {
            usageCount++;
        }
    }

    public Long getDiscountId() {
        return discountId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getMaxUsages() {
        return maxUsages;
    }

    public void setMaxUsages(int maxUsages) {
        this.maxUsages = maxUsages;
    }

    public int getUsageCount() {
        return usageCount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "code='" + code + '\'' +
                ", discountType=" + discountType +
                ", value=" + value +
                ", valid=" + isValid() +
                '}';
    }
}
