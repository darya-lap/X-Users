package DAO;

import entity.Address;
import entity.Users;
import org.hibernate.Session;
import persistence.HibernateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class AddressDAO implements AddressDAOInterface {

    @Override
    public void addAddress(Address address) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(address);
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
    public void update(int id, Address address) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Update address error");
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateZip(int id, int zip) throws SQLException {
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setZip(zip);
        user.setLastUpdatedTimeStamp(new Date());
        update(id, address);
        Factory.getInstance().getUserDAO().update(id,user);
    }

    @Override
    public void updateCountry(int id, String country) throws SQLException {
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setCountry(country);
        user.setLastUpdatedTimeStamp(new Date());
        update(id, address);
        Factory.getInstance().getUserDAO().update(id,user);
    }

    @Override
    public void updateCity(int id, String city) throws SQLException {
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setCity(city);
        user.setLastUpdatedTimeStamp(new Date());
        update(id, address);
        Factory.getInstance().getUserDAO().update(id,user);
    }

    @Override
    public void updateDistrict(int id, String district) throws SQLException {
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setDistrict(district);
        user.setLastUpdatedTimeStamp(new Date());
        update(id, address);
        Factory.getInstance().getUserDAO().update(id,user);
    }

    @Override
    public void updateStreet(int id, String street) throws SQLException {
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setStreet(street);
        user.setLastUpdatedTimeStamp(new Date());
        update(id, address);
        Factory.getInstance().getUserDAO().update(id,user);
    }

    @Override
    public Address getAddressById(int id) throws SQLException {
        Session session = null;
        Address address = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            address = (Address) session.get(Address.class, id);
        } catch (Exception e) {
            System.out.println("Ошибка 'getAddressById'");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return address;
    }

    @Override
    public Collection getAllAddress() throws SQLException {
        return null;
    }

    @Override
    public void deleteAddressById(int id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Address address = getAddressById(id);
            session.delete(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при удалении");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
