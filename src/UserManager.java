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

    public String generateCustomerId() {
        int number = 1;
        while (true) {
            String candidateId = String.format("C%03d", number);
            if (findUser(candidateId) == null) {
                return candidateId;
            }
            number++;
        }
    }
    
    public void register() {
        try {
            String id = generateCustomerId();
            String password;
            System.out.println("ID baru   : " + id);
            String name = InputHelper.readValidString("Nama      : ", 155);
            while (true) {
                password = InputHelper.readString("Password : ");
                if (password.isBlank() || password.length() < 4) {
                    System.out.println("Password minimal 4 karakter dan tidak boleh hanya spasi (kosong).");
                } else {
                    break;
                }
            }
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