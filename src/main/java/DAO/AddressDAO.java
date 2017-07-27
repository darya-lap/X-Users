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
    public boolean addAddress(Address address) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
            return true;
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
    public boolean update(int id, Address address) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            System.out.println("Update address error");
            return false;
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public boolean updateZip(int id, int zip) throws SQLException {
        boolean ret;
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setZip(zip);
        user.setLastUpdatedTimeStamp(new Date());
        ret = Factory.getInstance().getUserDAO().update(id,user);
        if (ret) {
            return update(id, address);
        }
        else return ret;
    }

    @Override
    public boolean updateCountry(int id, String country) throws SQLException {
        boolean ret;
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setCountry(country);
        user.setLastUpdatedTimeStamp(new Date());
        ret = Factory.getInstance().getUserDAO().update(id,user);
        if (ret){
            return update(id, address);
        }
        else return ret;
    }

    @Override
    public boolean updateCity(int id, String city) throws SQLException {
        boolean ret;
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setCity(city);
        user.setLastUpdatedTimeStamp(new Date());
        ret = Factory.getInstance().getUserDAO().update(id,user);
        if (ret) return update(id, address);
        else return ret;
    }

    @Override
    public boolean updateDistrict(int id, String district) throws SQLException {
        boolean ret;
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setDistrict(district);
        user.setLastUpdatedTimeStamp(new Date());
        ret = Factory.getInstance().getUserDAO().update(id,user);
        if (ret) return update(id, address);
        else return ret;
    }

    @Override
    public boolean updateStreet(int id, String street) throws SQLException {
        boolean ret;
        Address address = getAddressById(id);
        Users user = Factory.getInstance().getUserDAO().getUsersById(id);
        address.setStreet(street);
        user.setLastUpdatedTimeStamp(new Date());
        ret = Factory.getInstance().getUserDAO().update(id,user);
        if (ret) return update(id, address);
        else return ret;
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
            return null;
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
    public boolean deleteAddressById(int id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Address address = getAddressById(id);
            session.delete(address);
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
}
