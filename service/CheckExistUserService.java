package service;

import model.User;
import repository.UserRepository;
import java.util.Scanner;

public class CheckExistUserService {
    private final UserRepository repo;

    public CheckExistUserService(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(Scanner sc) {
        System.out.print("Enter username to check: ");
        String username = sc.nextLine().trim();

        User user = repo.findByUsername(username);
        if (user == null) {
            System.out.println("No User Found!");
        } else {
            System.out.println("Exist User");
        }
    }
}
