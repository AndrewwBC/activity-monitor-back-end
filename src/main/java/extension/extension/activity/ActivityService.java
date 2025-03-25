package extension.extension.activity;


import extension.extension.activity.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    ActivityRepository activityRepository;
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
}
