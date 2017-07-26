package entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Proxy(lazy = false)
public class Users {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private Date birthday;
    private Date createdTimestamp;
    private Date lastUpdatedTimeStamp;
    private Integer isActive;

    public Users(String firstname, String lastname,String username, String password, String email,
          String birthday, Date createdTimestamp, Integer isActive) throws ParseException {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        this.createdTimestamp = createdTimestamp;
        this.lastUpdatedTimeStamp = new Date();
        this.isActive = isActive;
    }

    public Users() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 45)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 45)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "createdTimestamp", nullable = false)
    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Basic
    @Column(name = "lastUpdatedTimeStamp", nullable = false)
    public Date getLastUpdatedTimeStamp() {
        return lastUpdatedTimeStamp;
    }

    public void setLastUpdatedTimeStamp(Date lastUpdatedTimeStamp) {
        this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
    }

    @Basic
    @Column(name = "isActive", nullable = true)
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (firstname != null ? !firstname.equals(users.firstname) : users.firstname != null) return false;
        if (lastname != null ? !lastname.equals(users.lastname) : users.lastname != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (birthday != null ? !birthday.equals(users.birthday) : users.birthday != null) return false;
        if (createdTimestamp != null ? !createdTimestamp.equals(users.createdTimestamp) : users.createdTimestamp != null)
            return false;
        if (lastUpdatedTimeStamp != null ? !lastUpdatedTimeStamp.equals(users.lastUpdatedTimeStamp) : users.lastUpdatedTimeStamp != null)
            return false;
        if (isActive != null ? !isActive.equals(users.isActive) : users.isActive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (createdTimestamp != null ? createdTimestamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTimeStamp != null ? lastUpdatedTimeStamp.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }
}
