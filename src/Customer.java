public class Customer extends User {
    public Customer(String id, String name, String password) {
        super(id, name, password);
        if (!id.toUpperCase().startsWith("C")) {
            throw new IllegalArgumentException("ID Customer harus diawali huruf 'C' (contoh: C001).");
        }
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    @Override
    public boolean canManageProducts() {
        return false;
    }

    @Override
    public void showMenu(Store store) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- MENU CUSTOMER ---");
            System.out.println("1. Lihat produk");
            System.out.println("2. Beli produk");
            System.out.println("0. Logout");
            int choice = InputHelper.readInt("Pilih: ");

            try {
                switch (choice) {
                    case 1:
                        store.printProducts();
                        break;
                    case 2:
                        buyProduct(store);
                        break;
                    case 0:
                        loggedIn = false;
                        System.out.println("Logout berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Gagal: " + e.getMessage());
            }
        }
    }

    private void buyProduct(Store store) {
        store.printProducts();
        String id = InputHelper.readString("ID produk yang dibeli: ");
        Product p = store.findById(id);
        if (p == null) {
            System.out.println("Produk tidak ditemukan.");
            return;
        }

        int qty = InputHelper.readMinInt("Jumlah: ", 1);
        if (qty <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }
        if (!p.isInStock(qty)) {
            System.out.println("Stok tidak cukup. Sisa stok: " + p.getStockQuantity());
            return;
        }

        double total = p.calculateFinalPrice() * qty;
        System.out.printf("Total bayar: Rp %,.2f%n", total);
        String confirm = InputHelper.readString("Lanjutkan pembelian? (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
            p.reduceStock(qty);
            System.out.println("Pembelian berhasil! Terima kasih.");
        } else {
            System.out.println("Pembelian dibatalkan.");
        }
    }
}