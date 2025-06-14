package repository;

import model.User;
import util.FileUtils;
import java.util.*;

public class UserRepository {
    private final String filename;
    private final List<User> users;

    public UserRepository(String filename) {
        this.filename = filename;
        this.users = FileUtils.loadFromFile(filename);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void save() {
        FileUtils.saveToFile(users, filename);
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
