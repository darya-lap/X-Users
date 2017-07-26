package DAO;

import entity.Address;

import java.sql.SQLException;
import java.util.Collection;

public interface AddressDAOInterface {
    void addAddress(Address address) throws SQLException;
    void update(int id, Address address) throws SQLException;
    void updateZip(int id, int zip) throws SQLException;
    void updateCountry (int id, String country) throws SQLException;
    void updateCity (int id, String city) throws SQLException;
    void updateDistrict (int id, String district) throws SQLException;
    void updateStreet (int id, String street) throws SQLException;
    Address getAddressById(int id) throws SQLException;
    Collection getAllAddress() throws SQLException;
    void deleteAddressById(int id) throws SQLException;
}
