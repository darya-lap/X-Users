package DAO;

import entity.Address;
import entity.Users;
import org.hibernate.Session;
import persistence.HibernateUtil;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class UserDAO implements UserDAOInterface{
    @Override
    public boolean addUser(Users user, Address address) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            address.setId(getUsersByUsername(user.getUsername()).getId());
            boolean isSuccess = Factory.getInstance().getAddressDAO().addAddress(address);
            if (isSuccess) return true;
            else {
                deleteUserById(getUsersByUsername(user.getUsername()).getId());
                return false;
            }
        } catch (Exception e) {
            System.out.println("Ошибка при вставке");
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(int user_id, Users user){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            System.out.println("Update error");
            return false;
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public boolean updateUsersName(int id, String name) throws  SQLException{
        Users user = getUsersById(id);
        user.setFirstname(name);
        user.setLastUpdatedTimeStamp(new Date());
        return update(id, user);
    }

    @Override
    public boolean updateUsersLastname(int user_id, String lastname) throws SQLException {
        Users user = getUsersById(user_id);
        user.setLastname(lastname);
        user.setLastUpdatedTimeStamp(new Date());
        return update(user_id, user);
    }

    @Override
    public boolean updateUsersUsername(int user_id, String username) throws SQLException {
        Users user = getUsersById(user_id);
        user.setUsername(username);
        user.setLastUpdatedTimeStamp(new Date());
        return update(user_id, user);
    }

    @Override
    public boolean updateUsersPassword(int user_id, String password) throws SQLException {
        Users user = getUsersById(user_id);
        user.setPassword(password);
        user.setLastUpdatedTimeStamp(new Date());
        return update(user_id, user);
    }

    @Override
    public boolean updateUsersBirthday(int user_id, Date date) throws SQLException {
        Users user = getUsersById(user_id);
        user.setBirthday(date);
        user.setLastUpdatedTimeStamp(new Date());
        return update(user_id, user);
    }

    @Override
    public boolean updateUsersActivity(int user_id, int activiy) throws SQLException {
        Users user = getUsersById(user_id);
        user.setIsActive(activiy);
        user.setLastUpdatedTimeStamp(new Date());
        return update(user_id, user);
    }

    @Override
    public boolean updateUsersRole(int user_id, String role) throws SQLException {
        Users user = getUsersById(user_id);
        user.setRole(role);
        user.setLastUpdatedTimeStamp(new Date());
        return update(user_id, user);
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
            return null;
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
        List users = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String hql = "from Users";
            Query query = session.createQuery(hql);
            users = (List<Users>) query.getResultList();
            session.getTransaction().commit();
            if (users.size() > 0){
                return users;
            }
            else{
                return null;
            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Users getUsersByUsername(String username) throws SQLException {
        Session session = null;
        Users user = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String hql = "from Users u where u.username = :username_par";
            Query query = session.createQuery(hql);
            query.setParameter("username_par", username);

            List<Users> users = (List<Users>)query.getResultList();
            if (users.size() > 0){
                user = (Users)query.getResultList().get(0);
            }
            else{
                user = null;
            }
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public boolean deleteUserById(int user_id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Factory.getInstance().getAddressDAO().deleteAddressById(user_id);
            Users user = getUsersById(user_id);
            session.delete(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Ошибка при удалении");
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getUsersByBirth(Date date) throws SQLException {
        Session session = null;
        List users = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String hql = "from Users u where u.birthday = :date_par";
            Query query = session.createQuery(hql);
            query.setParameter("date_par", date);

            users = (List<Users>) query.getResultList();
            session.getTransaction().commit();
            if (users.size() <= 0) return null;

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    @Override
    public Collection getUsersByEmail(String email) throws SQLException {
        Session session = null;
        List users = new ArrayList<Users>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String hql = "from Users u where u.email = :email_par";
            Query query = session.createQuery(hql);
            query.setParameter("email_par", email);

            users = (List<Users>) query.getResultList();
            session.getTransaction().commit();
            if (users.size() <= 0) return null;

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    @Override
    public Collection getUsersByName(String partOfName) throws SQLException {
        return null;
    }
}
