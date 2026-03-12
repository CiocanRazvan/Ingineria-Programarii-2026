public class CartItem {

    private Product product;
    private int cantitate;
    private double pretUnitate;

    public CartItem(Product product, int cantitate, double pretUnitate) {
        this.product = product;
        this.cantitate = cantitate;
        this.pretUnitate = pretUnitate;
    }

    public Product getProduct() {
        return product;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getPretUnitate() {
        return pretUnitate;
    }

    public double getTotal() {
        return cantitate * pretUnitate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setPretUnitate(double pretUnitate) {
        this.pretUnitate = pretUnitate;
    }

    public void increaseQuantity(int cantitate) {
        this.cantitate += cantitate;
    }

    public void decreaseQuantity(int cantitate) {
        this.cantitate = Math.max(0, this.cantitate - cantitate);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product='" + product.getName() + '\'' +
                ", cantitate=" + cantitate +
                ", pretUnitate=" + pretUnitate +
                ", total=" + getTotal() +
                '}';
    }
}
