package util;

import model.User;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtils {
    public static void saveToFile(List<User> users, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (User u : users) {
                pw.println(u.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public static List<User> loadFromFile(String filename) {
        List<User> userList = new ArrayList<>();
        try {
            if (!Files.exists(Paths.get(filename))) return userList;
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    User u = new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                    userList.add(u);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
        return userList;
    }
}
