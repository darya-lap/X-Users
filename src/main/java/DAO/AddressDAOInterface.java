package DAO;

import entity.Address;

import java.sql.SQLException;
import java.util.Collection;

public interface AddressDAOInterface {
    boolean addAddress(Address address) throws SQLException;
    boolean update(int id, Address address) throws SQLException;
    boolean updateZip(int id, int zip) throws SQLException;
    boolean updateCountry (int id, String country) throws SQLException;
    boolean updateCity (int id, String city) throws SQLException;
    boolean updateDistrict (int id, String district) throws SQLException;
    boolean updateStreet (int id, String street) throws SQLException;
    Address getAddressById(int id) throws SQLException;
    Collection getAllAddress() throws SQLException;
    boolean deleteAddressById(int id) throws SQLException;
}
