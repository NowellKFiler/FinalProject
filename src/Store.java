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

    public String generateNextId(String prefix) {
        int number = 1;
        while (true) {
            String candidateId = String.format("%s%03d", prefix, number);
            if (findById(candidateId) == null) {
                return candidateId;
            }
            number++;
        }
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

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("Belum ada produk.");
            return;
        }

        System.out.println("\n" + "-".repeat(78));
        System.out.printf("%-6s %-18s %-12s %18s %8s%n", "ID", "Nama", "Kategori", "Harga Akhir", "Stok");
        System.out.println("-".repeat(78));
        for (Product p : products) {
            System.out.printf("%-6s %-18s %-12s %,18.2f %8d%n",
                    p.getId(), p.getName(), p.getCategory(),
                    p.calculateFinalPrice(), p.getStockQuantity());
        }
        System.out.println("-".repeat(78));
    }

    public void loadSampleData(User admin) {
        addProduct(admin, new Electronics("E001", "Laptop", 8000000, 5, "Asus", 24, 0.11));
        addProduct(admin, new Electronics("E002", "Headphone", 500000, 10, "Sony", 12, 0.11));
        addProduct(admin, new Clothing("C001", "Kaos Polos", 80000, 20, "Uniqlo", "L", 0.05));
    }

    private void requireManager(User u) {
        if (u == null || !u.canManageProducts())
            throw new SecurityException("Only admins may modify products");
    }
}