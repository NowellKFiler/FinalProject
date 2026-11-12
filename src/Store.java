import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(User requester, Product p) {
        requireManager(requester);
        if (findById(p.getId()) != null)
            throw new IllegalArgumentException("Duplicate product id: " + p.getId());
        products.add(p);
    }

    public void removeProduct(User requester, String id) {
        requireManager(requester);
        Product p = findById(id);
        if (p == null)
            throw new IllegalArgumentException("No such product: " + id);
        products.remove(p);
    }

    public Product findById(String id) {
        for (Product p : products)
            if (p.getId().equals(id))
                return p;
        return null;
    }

    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    public double totalInventoryValue() {
        double total = 0;
        for (Product p : products) {
            total += p.calculateFinalPrice() * p.getStockQuantity();
        }
        return total;
    }

    private void requireManager(User u) {
        if (u == null || !u.canManageProducts())
            throw new SecurityException("Only admins may modify products");
    }
}
