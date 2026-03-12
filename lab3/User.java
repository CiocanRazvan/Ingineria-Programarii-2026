import java.util.*;
import java.time.LocalDate;

public class User {
    private static long contor = 0;
    private String firstName;
    private String lastName;
    private long id=0;
    private String email;
    private String phoneNumber;
    private LocalDate createdAt;
    private String password;
    private String username;
    private boolean acces = false;

    public User(String firstName, String secName, String email, String phoneNumber, String password, String username) {
        this.id = ++contor;
        this.firstName = firstName;
        this.lastName = secName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.username = username;

        this.createdAt = LocalDate.now();
    }

    public void logIn(String username, String password){
        if(this.username.equals(username) && this.password.equals(password)){
            this.acces = true;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String fullNume() {
        return firstName+lastName;
    }

    public void setNume(String firstName , String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void logOut(){
        this.acces = false;
    }
}