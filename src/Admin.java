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
        String id = store.generateNextId("E");
        System.out.println("ID            : " + id);
        String name = InputHelper.readValidString("Nama          : ", 256);
        double price = InputHelper.readMinDouble("Harga dasar    : ", 0, false);
        int stock = InputHelper.readMinInt("Stok          : ", 1);
        String brand = InputHelper.readValidString("Brand         : ", 100);
        int warranty = InputHelper.readInt("Garansi (bulan): ");
        double tax = InputHelper.readMinDouble("Pajak (%)      : ", 0, true) / 100.0;

        store.addProduct(this, new Electronics(id, name, price, stock, brand, warranty, tax));
        System.out.println("Produk Electronics "+ name +" (" + id + ") ditambahkan.");
    }

    private void addClothing(Store store) {
        String id = store.generateNextId("C");
        System.out.println("ID            : " + id);
        String name = InputHelper.readValidString("Nama          : ", 256);
        double price = InputHelper.readMinDouble("Harga dasar    : ", 0, false);
        int stock = InputHelper.readMinInt("Stok          : ", 1);
        String brand = InputHelper.readValidString("Brand         : ", 100);
        String size = InputHelper.readValidString("Ukuran        : ", 20);
        double tax = InputHelper.readMinDouble("Pajak (%)      : ", 0, true) / 100.0;

        store.addProduct(this, new Clothing(id, name, price, stock, brand, size, tax));
        System.out.println("Produk Clothing "+ name +" (" + id + ") ditambahkan.");
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