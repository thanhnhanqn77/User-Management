package service;

import model.User;
import repository.UserRepository;
import java.util.Scanner;

public class UpdateUserService {
    private final UserRepository repo;

    public UpdateUserService(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(Scanner sc) {
        System.out.print("Enter username to update: ");
        String username = sc.nextLine().trim();

        User user = repo.findByUsername(username);
        if (user == null) {
            System.out.println("Username does not exist.");
            return;
        }

        System.out.print("New first name (leave blank to skip): ");
        String fn = sc.nextLine().trim();
        if (!fn.isEmpty()) user.setFirstName(fn);

        System.out.print("New last name (leave blank to skip): ");
        String ln = sc.nextLine().trim();
        if (!ln.isEmpty()) user.setLastName(ln);

        System.out.print("New phone (leave blank to skip): ");
        String phone = sc.nextLine().trim();
        if (!phone.isEmpty() && phone.matches("\\d{10}")) user.setPhone(phone);

        System.out.print("New email (leave blank to skip): ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty() && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) user.setEmail(email);

        System.out.println("Update success.");
    }
}
