public abstract class Product {
    private String id;
    private String name;
    private double basePrice;
    private int stockQuantity;

    public Product(String id, String name, double basePrice, int stockQuantity) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("ID required");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name required");
        if (basePrice < 0)
            throw new IllegalArgumentException("Price must be larger or equal to 0");
        if (stockQuantity < 0)
            throw new IllegalArgumentException("Stock Quantity must be Larger than 0");

        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.stockQuantity = stockQuantity;
    }

    public abstract double calculateFinalPrice();

    public abstract String getCategory();

    public boolean isInStock(int qty) {
        return stockQuantity >= qty;
    }

    public void reduceStock(int qty) {
        if (qty < 0)
            throw new IllegalArgumentException("Quantity must be >= 0");
        if (qty > stockQuantity)
            throw new IllegalArgumentException("Not enough stock");
        stockQuantity -= qty;
    }

    public void increaseStock(int qty) {
        if (qty < 0)
            throw new IllegalArgumentException("Quantity must be a non-zero value");
        stockQuantity += qty;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
