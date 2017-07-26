package DAO;

import entity.Address;
import entity.Users;
import org.hibernate.Session;
import persistence.HibernateUtil;

import javax.persistence.Query;
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
    public void addUser(Users user, Address address) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            address.setId(user.getId());
            Factory.getInstance().getAddressDAO().addAddress(address);
        } catch (Exception e) {
            System.out.println("Ошибка при вставке");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(int user_id, Users user){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Update error");
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateUsersName(int id, String name) throws  SQLException{
        Users user = getUsersById(id);
        user.setFirstname(name);
        user.setLastUpdatedTimeStamp(new Date());
        update(id, user);
    }

    @Override
    public void updateUsersLastname(int user_id, String lastname) throws SQLException {
        Users user = getUsersById(user_id);
        user.setLastname(lastname);
        user.setLastUpdatedTimeStamp(new Date());
        update(user_id, user);
    }

    @Override
    public void updateUsersUsername(int user_id, String username) throws SQLException {
        Users user = getUsersById(user_id);
        user.setUsername(username);
        user.setLastUpdatedTimeStamp(new Date());
        update(user_id, user);
    }

    @Override
    public void updateUsersPassword(int user_id, String password) throws SQLException {
        Users user = getUsersById(user_id);
        user.setPassword(password);
        user.setLastUpdatedTimeStamp(new Date());
        update(user_id, user);
    }

    @Override
    public void updateUsersBirthday(int user_id, Date date) throws SQLException {
        Users user = getUsersById(user_id);
        user.setBirthday(date);
        user.setLastUpdatedTimeStamp(new Date());
        update(user_id, user);
    }

    @Override
    public void updateUsersActivity(int user_id, int activiy) throws SQLException {
        Users user = getUsersById(user_id);
        user.setIsActive(activiy);
        user.setLastUpdatedTimeStamp(new Date());
        update(user_id, user);
    }

    @Override
    public void updateUsersRole(int user_id, String role) throws SQLException {
        Users user = getUsersById(user_id);
        user.setRole(role);
        user.setLastUpdatedTimeStamp(new Date());
        update(user_id, user);
    }

    @Override
    public Users getUsersById(int user_id) throws SQLException {
        Session session = null;
        Users user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (Users) session.get(Users.class, user_id);
            System.out.println(user.getEmail());
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
    public void deleteUserById(int user_id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Factory.getInstance().getAddressDAO().deleteAddressById(user_id);
            Users user = getUsersById(user_id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при удалении");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getUsersByBirth(Date date) throws SQLException {
        Session session = null;
        List users = new ArrayList<Users>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String hql = "from Users u where u.birthday = :date_par";
            Query query = session.createQuery(hql);
            query.setParameter("date_par", date);

            users = (List<Users>) query.getResultList();
            session.getTransaction().commit();

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
