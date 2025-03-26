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
    private Integer stories;
    private Integer instagramReels;
    private Integer facebookReels;
    private Integer facebookStories;
    private Integer youtubeShorts;

    @ManyToOne
    @JsonIgnore
    private User user;
    public Activity(String tabId, String url, String title, String creationDate, String endDate,
                    Integer stories, Integer instagramReels,
                    Integer facebookReels,
                    Integer facebookStories,
                    Integer youtubeShorts
    ){
        this.tabId = tabId;
        this.url = url;
        this.title = title;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.stories =stories;
        this.instagramReels = instagramReels;
        this.facebookReels = facebookReels;
        this.facebookStories = facebookStories;
        this.youtubeShorts = youtubeShorts;
    }
    public static Activity fromDTOCreateActivity(ActivityDTO activityDTO){
        return new Activity(
                activityDTO.tabId(),
                activityDTO.url(),
                activityDTO.title(),
                activityDTO.creationDate(),
                activityDTO.endDate(),
                activityDTO.stories(),
                activityDTO.instagramReels(),
                activityDTO.facebookReels(),
                activityDTO.facebookStories(),
                activityDTO.youtubeShorts()
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
