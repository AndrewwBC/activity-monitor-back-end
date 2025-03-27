package extension.extension.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import extension.extension.activity.dto.ActivityDTO;
import extension.extension.activity_history.ActivityHistory;
import extension.extension.user.User;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String url;
    private String title;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ActivityHistory> activityHistory = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private User user;
    public Activity(String url, String title, List<ActivityHistory> activityHistory, User user) {
        this.url = url;
        this.title = title;
        this.activityHistory = activityHistory;
        this.user = user;
    }

    public Activity() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public List<ActivityHistory> getActivityHistory() {
        return activityHistory;
    }

    public void setActivityHistory(List<ActivityHistory> activityHistory) {
        this.activityHistory = activityHistory;
    }

    public static Activity fromDTOCreateActivity(ActivityDTO activityDTO, List<ActivityHistory> activityHistory, User user){
        return new Activity(
                activityDTO.url(),
                activityDTO.title(),
                activityHistory,
                user
        );
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", activityHistory=" + activityHistory +
                ", user=" + user +
                '}';
    }
}
