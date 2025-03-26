package extension.extension.activity;

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

    private LocalDateTime initialDate;
    private LocalDateTime endDate;

    private Integer stories;
    private Integer instagramReels;
    private Integer facebookReels;
    private Integer facebookStories;
    private Integer youtubeShorts;

}
