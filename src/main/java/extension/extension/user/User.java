package extension.extension.user;

import extension.extension.activity.Activity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "Users")
@Table(name = "users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Activity> activities;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", activities=" + activities +
                '}';
    }
}
