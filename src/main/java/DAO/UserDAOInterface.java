package DAO;

import entity.Address;
import entity.Users;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

interface UserDAOInterface {
        void addUser(Users User, Address address) throws SQLException;
        void update(int user_id, Users user);
        void updateUsersName(int user_id, String name) throws SQLException;
        void updateUsersLastname (int user_id, String lastname) throws SQLException;
        void updateUsersUsername (int user_id, String username) throws SQLException;
        void updateUsersPassword (int user_id, String password) throws SQLException;
        void updateUsersBirthday (int user_id, Date date) throws SQLException;
        void updateUsersActivity (int user_id, int activiy) throws SQLException;
        void updateUsersRole (int user_id, String role) throws SQLException;
        Users getUsersById(int user_id) throws SQLException;
        Collection getAllUsers() throws SQLException;
        void deleteUserById(int user_id) throws SQLException;

        Collection getUsersByBirth(Date date) throws SQLException;
        Collection getUsersByEmail(String email) throws SQLException;
        Collection getUsersByName(String partOfName) throws  SQLException;
}
