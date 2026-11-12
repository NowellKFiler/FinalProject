public class Clothing extends Product {
    private final String brand;
    private final String size;
    private final double taxRate;

    public Clothing(String id, String name, double basePrice, int stockQuantity, String brand, String size,
            double taxRate) {
        super(id, name, basePrice, stockQuantity);
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand required.");
        }
        if (size == null || size.isBlank()) {
            throw new IllegalArgumentException("Size required.");
        }
        if (taxRate < 0) {
            throw new IllegalArgumentException("Tax rate cannot be negative.");
        }

        this.brand = brand;
        this.size = size;
        this.taxRate = taxRate;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize() {
        return size;
    }

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() * (1 + taxRate);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}
