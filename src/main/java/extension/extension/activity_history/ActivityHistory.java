package extension.extension.activity_history;

import extension.extension.activity.Activity;
import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "activity_history")
public class ActivityHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ElementCollection
    private Map<String, String> listOfActiviesPerSite = new HashMap<>();

    @ManyToOne
    private Activity activity;

    public ActivityHistory(Activity activity) {
        this.activity = activity;
    }

    public ActivityHistory() {}

    public void setId(String id) {
        this.id = id;
    }


    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getId() {
        return id;
    }


    public Activity getActivity() {
        return activity;
    }

    public static ActivityHistory fromActivityHistoryDTO(ActivityHistoryDTO activityHistoryDTO, Activity activity){
        return new ActivityHistory(
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
