package teamgeso.hotelback.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "hotel", catalog = "")
public class User {
    private int userId;
    private String password;
    private String role;
    private String userName;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User User = (User) o;
        return userId == User.userId &&
                Objects.equals(password, User.password) &&
                Objects.equals(role, User.role) &&
                Objects.equals(userName, User.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password, role, userName);
    }
}
