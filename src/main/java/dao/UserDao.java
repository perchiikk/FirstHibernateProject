package dao;

import model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUsers(User user);
    void removeUserById(Integer id);

    List<User> getAllUsers();

    void cleanUsersTables();
}
