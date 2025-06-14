package service;

import model.User;
import repository.UserRepository;
import java.util.Comparator;

public class PrintAllUsersService {
    private final UserRepository repo;

    public PrintAllUsersService(UserRepository repo) {
        this.repo = repo;
    }

    public void execute() {
        repo.getAllUsers()
            .stream()
            .sorted(Comparator.comparing(User::getFirstName))
            .forEach(System.out::println);
    }
}
