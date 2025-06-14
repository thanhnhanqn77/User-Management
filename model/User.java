package model;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;

    public User(String username, String firstName, String lastName, String password, String phone, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String toFileString() {
        return username + "|" + firstName + "|" + lastName + "|" + password + "|" + phone + "|" + email;
    }

    @Override
    public String toString() {
        return String.format("Username: %s, Name: %s %s, Phone: %s, Email: %s", username, firstName, lastName, phone, email);
    }

    // Getters & Setters
    public String getUsername() { return username; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
