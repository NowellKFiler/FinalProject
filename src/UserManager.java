import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final List<User> users = new ArrayList<>();

    public UserManager() {
        users.add(new Admin("A001", "Admin", "admin123"));
        users.add(new Customer("C001", "Budi", "budi123"));
    }

    public User login() {
        String id = InputHelper.readString("ID       : ");
        String password = InputHelper.readString("Password : ");

        User u = findUser(id);
        if (u != null && u.authenticate(password)) {
            System.out.println("Login berhasil. Selamat datang, " + u.getName() + " (" + u.getRole() + ")");
            return u;
        }
        System.out.println("ID atau password salah.");
        return null;
    }

    public void register() {
        try {
            String id = InputHelper.readString("ID baru   : ");
            if (findUser(id) != null) {
                System.out.println("ID sudah dipakai.");
                return;
            }
            String name = InputHelper.readString("Nama      : ");
            String password = InputHelper.readString("Password  : ");
            users.add(new Customer(id, name, password));
            System.out.println("Registrasi berhasil. Silakan login.");
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    public User findUser(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }
}