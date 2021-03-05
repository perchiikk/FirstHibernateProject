package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Override
    public void saveUsers(User user) {
        userDao.saveUsers(user);
    }

    @Override
    public void removeUserById(Integer id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTables() {
        userDao.cleanUsersTables();
    }
}
