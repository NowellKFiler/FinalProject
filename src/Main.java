public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Store store = new Store();
        store.loadSampleData(userManager.findUser("A001"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== TOKO ONLINE ===");
            System.out.println("1. Login");
            System.out.println("2. Register (Customer)");
            System.out.println("0. Keluar");

            switch (InputHelper.readInt("Pilih: ")) {
                case 1: {
                    User user = userManager.login();
                    if (user != null) {
                        user.showMenu(store);
                    }
                    break;
                }
                case 2:
                    userManager.register();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        System.out.println("Terima kasih!");
        InputHelper.close();
    }
}