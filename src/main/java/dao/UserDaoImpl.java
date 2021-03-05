package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void createUsersTable() {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE if not exists Users (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), age INT, city VARCHAR(100), country VARCHAR(100))").executeUpdate();
            transaction.commit();
            System.out.println("table was created successfully");
        }
        catch (Exception e){
            System.out.println("some exception");
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = null;
        Transaction transaction;
        try {
            session = SessionUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE Users").executeUpdate();
            transaction.commit();
            System.out.println("Table was dropped complete");
        }
        catch (Exception e){
            System.out.println("some exception in dropUsers");
        }
        finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public void saveUsers(User user) {
        try(Session session = SessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("User was saved complete");
        }
        catch (Exception e){
            System.out.println("some exception in save user");
        }
    }

    @Override
    public void removeUserById(Integer id) {
        Session session = SessionUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.load(User.class, id));
        transaction.commit();
        System.out.println("user was removed complete");
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;

        try(Session session = SessionUtil.getSessionFactory().openSession()){
            users = session.createQuery("FROM User").list();
        }
        return users;
    }

    @Override
    public void cleanUsersTables() {
        Session session = SessionUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("DELETE FROM Users").executeUpdate();
        transaction.commit();
        System.out.println("Table was cleaned complete");
        session.close();
    }

}
