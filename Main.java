import repository.UserRepository;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserRepository repo = new UserRepository("user.dat");

        // Khởi tạo các service
        CreateUserService createUser = new CreateUserService(repo);
        CheckExistUserService checkExistUser = new CheckExistUserService(repo);
        SearchUserService searchUser = new SearchUserService(repo);
        UpdateUserService updateUser = new UpdateUserService(repo);
        DeleteUserService deleteUser = new DeleteUserService(repo);
        PrintAllUsersService printAllUsers = new PrintAllUsersService(repo);

        while (true) {
            System.out.println("\n===== User Management =====");
            System.out.println("1. Create User");
            System.out.println("2. Check Exist User");
            System.out.println("3. Search User");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Save to File");
            System.out.println("7. Print All Users");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": createUser.execute(sc); break;
                case "2": checkExistUser.execute(sc); break;
                case "3": searchUser.execute(sc); break;
                case "4": updateUser.execute(sc); break;
                case "5": deleteUser.execute(sc); break;
                case "6": repo.save(); break;
                case "7": printAllUsers.execute(); break;
                case "0": 
                    repo.save(); 
                    System.out.println("Bye!"); 
                    return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
