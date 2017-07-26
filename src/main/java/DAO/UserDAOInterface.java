package DAO;

import entity.Users;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

interface UserDAOInterface {
        void addUser(Users User) throws SQLException;
        void updateUser(int user_id, Users user) throws SQLException;
        Users getUsersById(int user_id) throws SQLException;
        Collection getAllUsers() throws SQLException;
        void deleteUsers(Users users) throws SQLException;

        Collection getUsersByBirth(Date date) throws SQLException;
        Collection getUsersByEmail(String email) throws SQLException;
        Collection getUsersByName(String partOfName) throws  SQLException;
}
