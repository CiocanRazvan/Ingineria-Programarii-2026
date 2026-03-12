import java.time.LocalDate;
import java.util.*;

public class Cart {
    private long cartId;
    private LocalDate createdAt;
    private LocalDate lastModified;

    private Map<Product, Double> items;

    public Cart(long id) {
        this.cartId = id;
        this.createdAt = LocalDate.now();
        this.lastModified = LocalDate.now();
        this.items = new HashMap<>();
    }

    public void addItem(Product p, double cant) {
        if (!p.isDisponibil()) {
            System.out.println("Produsul nu este disponibil");
            return;
        }
        if (items.containsKey(p)) {
            items.put(p, items.get(p) + cant);
        } else {
            items.put(p, cant);
        }
        p.addInCart();
        lastModified = LocalDate.now();
    }

    public void removeItem(Product p) {
        if (items.containsKey(p)) {
            items.remove(p);
            p.removeFromCart();
            lastModified = LocalDate.now();
        }
    }

    public void showCart() {
        for (Map.Entry<Product, Double> entry : items.entrySet()) {
            Product produs = entry.getKey();
            double cant = entry.getValue();

            System.out.println(produs.getName() + " x " + cant);
        }
    }
}
