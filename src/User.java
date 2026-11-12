public abstract class User {
    private final String id;
    private final String name;
    private String password;

    public User(String id, String name, String password) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("ID required");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name required");
        if (password == null || password.length() < 4)
            throw new IllegalArgumentException("Password must be at least 4 chars");

        this.id = id;
        this.name = name;
        this.password = password;
    }

    public abstract String getRole();

    public abstract boolean canManageProducts();

    public boolean authenticate(String attempt) {
        return password.equals(attempt);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getRole() + "[" + id + ", " + name + "]";
    }
}
