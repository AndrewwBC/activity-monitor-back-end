package extension.extension.activity_history;

import extension.extension.activity.Activity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "activity_history")
@AllArgsConstructor
@NoArgsConstructor
public class ActivityHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime initialDateAndTime = LocalDateTime.now();
    private LocalDateTime endDateAndTime = null;

    private Integer stories;
    private Integer instagramReels;
    private Integer facebookReels;
    private Integer facebookStories;
    private Integer youtubeShorts;

    @ManyToOne
    private Activity activity;

    public ActivityHistory(Integer stories, Integer instagramReels, Integer facebookReels, Integer facebookStories, Integer youtubeShorts){
        this.stories = stories;
        this.instagramReels = instagramReels;
        this.facebookReels = facebookReels;
        this.facebookStories = facebookStories;
        this.youtubeShorts = youtubeShorts;
    }

}
