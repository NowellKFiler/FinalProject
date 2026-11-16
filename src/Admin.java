public class Admin extends User {
    public Admin(String id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public boolean canManageProducts() {
        return true;
    }

    @Override
    public void showMenu(Store store) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Lihat semua produk");
            System.out.println("2. Tambah produk Electronics");
            System.out.println("3. Tambah produk Clothing");
            System.out.println("4. Hapus produk");
            System.out.println("5. Tambah stok produk");
            System.out.println("6. Total nilai inventori");
            System.out.println("0. Logout");
            int choice = InputHelper.readInt("Pilih: ");

            try {
                switch (choice) {
                    case 1:
                        store.printProducts();
                        break;
                    case 2:
                        addElectronics(store);
                        break;
                    case 3:
                        addClothing(store);
                        break;
                    case 4:
                        String removeId = InputHelper.readString("ID produk yang dihapus: ");
                        store.removeProduct(this, removeId);
                        System.out.println("Produk dihapus.");
                        break;
                    case 5:
                        addStock(store);
                        break;
                    case 6:
                        System.out.printf("Total nilai inventori: Rp %,.2f%n", store.totalInventoryValue());
                        break;
                    case 0:
                        loggedIn = false;
                        System.out.println("Logout berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (IllegalArgumentException | SecurityException e) {
                System.out.println("Gagal: " + e.getMessage());
            }
        }
    }

    private void addElectronics(Store store) {
        String id = InputHelper.readString("ID            : ");
        String name = InputHelper.readString("Nama          : ");
        double price = InputHelper.readDouble("Harga dasar    : ");
        int stock = InputHelper.readInt("Stok          : ");
        String brand = InputHelper.readString("Brand         : ");
        int warranty = InputHelper.readInt("Garansi (bulan): ");
        double tax = InputHelper.readDouble("Pajak (%)      : ") / 100.0;

        store.addProduct(this, new Electronics(id, name, price, stock, brand, warranty, tax));
        System.out.println("Produk Electronics ditambahkan.");
    }

    private void addClothing(Store store) {
        String id = InputHelper.readString("ID            : ");
        String name = InputHelper.readString("Nama          : ");
        double price = InputHelper.readDouble("Harga dasar    : ");
        int stock = InputHelper.readInt("Stok          : ");
        String brand = InputHelper.readString("Brand         : ");
        String size = InputHelper.readString("Ukuran        : ");
        double tax = InputHelper.readDouble("Pajak (%)      : ") / 100.0;

        store.addProduct(this, new Clothing(id, name, price, stock, brand, size, tax));
        System.out.println("Produk Clothing ditambahkan.");
    }

    private void addStock(Store store) {
        String id = InputHelper.readString("ID produk     : ");
        Product p = store.findById(id);
        if (p == null) {
            System.out.println("Produk tidak ditemukan.");
            return;
        }
        int qty = InputHelper.readInt("Jumlah tambahan: ");
        p.increaseStock(qty);
        System.out.println("Stok sekarang: " + p.getStockQuantity());
    }
}