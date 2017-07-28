package DAO;

import entity.Address;
import entity.Users;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

interface UserDAOInterface {
        boolean addUser(Users User, Address address) throws SQLException;
        boolean update(int user_id, Users user);
        boolean updateUsersName(int user_id, String name) throws SQLException;
        boolean updateUsersLastname (int user_id, String lastname) throws SQLException;
        boolean updateUsersEmail (int user_id, String email) throws SQLException;
        boolean updateUsersUsername (int user_id, String username) throws SQLException;
        boolean updateUsersPassword (int user_id, String password) throws SQLException;
        boolean updateUsersBirthday (int user_id, Date date) throws SQLException;
        boolean updateUsersActivity (int user_id, int activiy) throws SQLException;
        boolean updateUsersRole (int user_id, String role) throws SQLException;
        Users getUsersById(int user_id) throws SQLException;
        Collection getAllUsers() throws SQLException;
        Users getUsersByUsername(String username) throws SQLException;
        boolean deleteUserById(int user_id) throws SQLException;

        Collection getUsersByBirth(Date date) throws SQLException;
        Collection getUsersByEmail(String email) throws SQLException;
        Collection getUsersByName(String partOfName) throws  SQLException;
}
