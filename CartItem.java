public class CartItem {

    private Produse produs;
    private int cantitate;
    private double pretUnitate;

    public CartItem(Produse produs, int cantitate, double pretUnitate);

    public Produse getProdus();

    public int getCantitate();

    public double getPretUnitate();

    public double getTotal();

    public void setProdus(Produse produs);

    public void setCantitate(int cantitate);

    public void setPretUnitate(double pretUnitate);

    public void increaseQuantity(int cantitate);

    public void decreaseQuantity(int cantitate);
}