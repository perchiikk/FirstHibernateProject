package service;

import model.User;

import java.util.List;

public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUsers(User user);

    void removeUserById(Integer id);

    List<User> getAllUsers();

    void cleanUsersTables();

}
