package extension.extension.activity.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import extension.extension.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "activity")
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
