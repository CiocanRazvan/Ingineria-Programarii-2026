public class ProductImage {
    private Long imageId;
    private String url;
    private boolean isPrimary;i

    private Product product;

    public ProductImage(Long imageId, String url, boolean isPrimary, Product product) {
        this.imageId = imageId;
        this.url = url;
        this.isPrimary = isPrimary;
        this.product = product;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}