package DAO;

import entity.Users;
import org.hibernate.Session;
import persistence.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class UserDAO implements UserDAOInterface{
    @Override
    public void addUser(Users user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при вставке");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateUser(int user_id, Users user) throws SQLException {

    }

    @Override
    public Users getUsersById(int user_id) throws SQLException {
        Session session = null;
        Users user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (Users) session.get(Users.class, user_id);
        } catch (Exception e) {
            System.out.println("Ошибка 'findById'");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public Collection getAllUsers() throws SQLException {
        Session session = null;
        List users = new ArrayList<Users>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Users> criteria = builder.createQuery(Users.class);

            Root<Users> contactRoot = criteria.from(Users.class);
            criteria.select(contactRoot);

            //Use criteria to query with session to fetch all contacts
            users = session.createQuery(criteria).getResultList();

        } catch (Exception e) {
            System.out.println("Ошибка 'getAll'");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    @Override
    public void deleteUsers(Users users) throws SQLException {

    }

    @Override
    public Collection getUsersByBirth(Date date) throws SQLException {
        return null;
    }

    @Override
    public Collection getUsersByEmail(String email) throws SQLException {
        return null;
    }

    @Override
    public Collection getUsersByName(String partOfName) throws SQLException {
        return null;
    }
}
