package extension.extension.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import extension.extension.activity.dto.ActivityDTO;
import extension.extension.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "activity")
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String url;
    private String title;
    private String creationDate;
    private String endDate;
    @ManyToOne
    @JsonIgnore
    private User user;
    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
