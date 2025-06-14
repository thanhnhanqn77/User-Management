package service;

import model.User;
import repository.UserRepository;
import java.util.*;

public class SearchUserService {
    private final UserRepository repo;

    public SearchUserService(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(Scanner sc) {
        System.out.print("Enter name to search: ");
        String keyword = sc.nextLine().trim().toLowerCase();
        List<User> found = new ArrayList<>();

        for (User u : repo.getAllUsers()) {
            if (u.getFirstName().toLowerCase().contains(keyword) || u.getLastName().toLowerCase().contains(keyword)) {
                found.add(u);
            }
        }

        if (found.isEmpty()) {
            System.out.println("Have no any user.");
        } else {
            found.sort(Comparator.comparing(User::getFirstName));
            found.forEach(System.out::println);
        }
    }
}
