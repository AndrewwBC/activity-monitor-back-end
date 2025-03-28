package extension.extension.activity_history;

import extension.extension.activity.Activity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_history")
public class ActivityHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer stories = 0;
    private Integer instagramReels = 0;
    private Integer facebookReels = 0;
    private Integer facebookStories = 0;
    private Integer youtubeShorts = 0;

    @ManyToOne
    private Activity activity;

    public ActivityHistory(Integer stories, Integer instagramReels, Integer facebookReels, Integer facebookStories, Integer youtubeShorts, Activity activity) {
        this.stories = stories;
        this.instagramReels = instagramReels;
        this.facebookReels = facebookReels;
        this.facebookStories = facebookStories;
        this.youtubeShorts = youtubeShorts;
        this.activity = activity;
    }

    public ActivityHistory() {}

    public void setId(String id) {
        this.id = id;
    }

    public void setStories(Integer stories) {
        this.stories = stories;
    }

    public void setInstagramReels(Integer instagramReels) {
        this.instagramReels = instagramReels;
    }

    public void setFacebookReels(Integer facebookReels) {
        this.facebookReels = facebookReels;
    }

    public void setFacebookStories(Integer facebookStories) {
        this.facebookStories = facebookStories;
    }

    public void setYoutubeShorts(Integer youtubeShorts) {
        this.youtubeShorts = youtubeShorts;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getId() {
        return id;
    }

    public Integer getStories() {
        return stories;
    }

    public Integer getInstagramReels() {
        return instagramReels;
    }

    public Integer getFacebookReels() {
        return facebookReels;
    }

    public Integer getFacebookStories() {
        return facebookStories;
    }

    public Integer getYoutubeShorts() {
        return youtubeShorts;
    }

    public Activity getActivity() {
        return activity;
    }

    public static ActivityHistory fromActivityHistoryDTO(ActivityHistoryDTO activityHistoryDTO, Activity activity){
        return new ActivityHistory(
                activityHistoryDTO.stories(),
                activityHistoryDTO.instagramReels(),
                activityHistoryDTO.facebookReels(),
                activityHistoryDTO.facebookStories(),
                activityHistoryDTO.youtubeShorts(),
                activity
        );
    }

    @Override
    public String toString() {
        return "ActivityHistory{" +
                "id='" + id + '\'' +
                ", stories=" + stories +
                ", instagramReels=" + instagramReels +
                ", facebookReels=" + facebookReels +
                ", facebookStories=" + facebookStories +
                ", youtubeShorts=" + youtubeShorts +
                '}';
    }
}
