package extension.extension.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import extension.extension.activity.dto.ActivityDTO;
import extension.extension.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity")
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String tabId;
    @Column(unique = true)
    private String url;
    private String title;
    private String creationDate;
    private String endDate;

    @ManyToOne
    @JsonIgnore
    private User user;
    public Activity(String tabId, String url, String title, String creationDate, String endDate) {
        this.tabId = tabId;
        this.url = url;
        this.title = title;
        this.creationDate = creationDate;
        this.endDate = endDate;
    }
    public static Activity fromDTOCreateActivity(ActivityDTO activityDTO){
        return new Activity(
                activityDTO.tabId(),
                activityDTO.url(),
                activityDTO.title(),
                activityDTO.creationDate(),
                activityDTO.endDate()
        );
    }
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
