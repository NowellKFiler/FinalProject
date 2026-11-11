public class Electronics extends Product {
    private final String brand;
    private final int warrantyMonths;
    private final double taxRate;

    public Electronics(String id, String name, double basePrice, int stockQuantity, String brand, int warrantyMonths,
            double taxRate) {
        super(id, name, basePrice, stockQuantity);

        if (brand == null || brand.isBlank())
            throw new IllegalArgumentException("Brand Required.");
        if (warrantyMonths < 0)
            throw new IllegalArgumentException("Warranty must be a non-zero private value.");
        if (taxRate < 0)
            throw new IllegalArgumentException("Tax Rate must be a non-zero value.");

        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() * (1 + taxRate);
    }

    @Override
    public String getCategory() {
        return super.toString()
                + String.format(" [brand=%s, warranty=%dmo, tax=%.0f%%]", brand, warrantyMonths, taxRate * 100);
    }
}
