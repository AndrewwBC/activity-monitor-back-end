package extension.extension.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import extension.extension.activity.dto.ActivityDTO;
import extension.extension.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany
    private List<ActivityHistory> activityHistory;

    @ManyToOne
    @JsonIgnore
    private User user;
    public Activity(String url, String title) {
        this.url = url;
        this.title = title;
    }
    public static Activity fromDTOCreateActivity(ActivityDTO activityDTO){
        return new Activity(
                activityDTO.url(),
                activityDTO.title()
        );
    }
    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
