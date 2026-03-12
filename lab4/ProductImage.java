public class ProductImage {
    private int imageId;
    private String url;

    private Product product;

    public ProductImage(int imageId, String url, Product product) {
        this.imageId = imageId;
        this.url = url;
        this.product = product;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
