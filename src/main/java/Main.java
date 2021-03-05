
import model.User;
import service.UserService;
import service.UserServiceImpl;

public class Main {

    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        User user1 = new User("Tanya", 22, "Moscow", "Russia");
        userService.saveUsers(user1);

        User user2 = new User("Vlad", 25, "Cartagena", "Spain");
        userService.saveUsers(user2);

        User user3 = new User("Leha", 16, "Saransk", "Russian");
        userService.saveUsers(user3);

        System.out.println(userService.getAllUsers().toString());

        userService.removeUserById(1);

        System.out.println(userService.getAllUsers().toString());
    }
}

