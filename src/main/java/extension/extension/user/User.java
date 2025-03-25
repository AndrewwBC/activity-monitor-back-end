package extension.extension.user;

import jakarta.persistence.*;

@Entity(name = "Users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
}
