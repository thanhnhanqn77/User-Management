package service;

import model.User;
import repository.UserRepository;
import util.PasswordUtils;

import java.util.Scanner;

public class CreateUserService {
    private final UserRepository repo;

    public CreateUserService(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(Scanner sc) {
        String username;
        while (true) {
            System.out.print("Username: ");
            username = sc.nextLine().trim();
            if (username.length() < 5 || username.contains(" ")) {
                System.out.println("Username must be at least 5 characters and no spaces.");
            } else if (repo.findByUsername(username) != null) {
                System.out.println("Username already exists.");
            } else break;
        }

        System.out.print("First name: ");
        String firstName = sc.nextLine().trim();
        System.out.print("Last name: ");
        String lastName = sc.nextLine().trim();

        String password;
        while (true) {
            System.out.print("Password: ");
            password = sc.nextLine().trim();
            if (password.length() < 6 || password.contains(" ")) {
                System.out.println("Password must be at least 6 characters.");
            } else {
                System.out.print("Confirm password: ");
                String confirm = sc.nextLine().trim();
                if (!password.equals(confirm)) {
                    System.out.println("Passwords do not match.");
                } else break;
            }
        }

        String phone;
        while (true) {
            System.out.print("Phone (10 digits): ");
            phone = sc.nextLine().trim();
            if (!phone.matches("\\d{10}"))
                System.out.println("Phone must be exactly 10 digits.");
            else break;
        }

        String email;
        while (true) {
            System.out.print("Email: ");
            email = sc.nextLine().trim();
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
                System.out.println("Invalid email format.");
            else break;
        }

        String hashed = PasswordUtils.hashPassword(password);
        User user = new User(username, firstName, lastName, hashed, phone, email);
        repo.addUser(user);
        System.out.println("User created successfully.");
    }
}
