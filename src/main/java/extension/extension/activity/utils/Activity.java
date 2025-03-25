package extension.extension.activity.utils;

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
}
