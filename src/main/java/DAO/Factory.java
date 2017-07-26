package DAO;

public class Factory {

    private static UserDAO userDAO = null;
    private static AddressDAO addressDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO getUserDAO(){
        if (userDAO == null){
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public AddressDAO getAddressDAO(){
        if (addressDAO == null){
            addressDAO = new AddressDAO();
        }
        return addressDAO;
    }

}
