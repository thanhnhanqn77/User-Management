package service;

import model.User;
import repository.UserRepository;
import java.util.Scanner;

public class DeleteUserService {
    private final UserRepository repo;

    public DeleteUserService(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(Scanner sc) {
        System.out.print("Enter username to delete: ");
        String username = sc.nextLine().trim();

        User user = repo.findByUsername(username);
        if (user == null) {
            System.out.println("Username does not exist.");
            return;
        }

        repo.removeUser(user);
        System.out.println("Delete success.");
    }
}
