public class Admin extends User {

    private UserRole role;

    public Admin(String firstName, String secName, String email,
                 String phoneNumber, String password, String username,
                 UserRole role) {
        super(firstName, secName, email, phoneNumber, password, username);
        this.role = role;
    }

    public void manageProducts() {
        System.out.println("Managing products...");
    }

    public void manageUsers() {
        System.out.println("Managing users...");
    }

    public void viewReports() {
        System.out.println("Viewing reports...");
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}