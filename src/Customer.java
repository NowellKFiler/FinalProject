public class Customer extends User {
    public Customer(String id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    @Override
    public boolean canManageProducts() {
        return false;
    }
}
