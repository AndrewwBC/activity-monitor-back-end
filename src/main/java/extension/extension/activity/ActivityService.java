package extension.extension.activity;


import extension.extension.activity.ActivityRepository;
import extension.extension.activity.dto.ActivityDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ActivityService {

    ActivityRepository activityRepository;
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Map<String, String> create(ActivityDTO activityDTO) {
        Activity newActivity = Activity.fromDTOCreateActivity(activityDTO);
        this.activityRepository.save(newActivity);

        Map<String, String> response = new HashMap<>();
        response.put("message", "created");

        return response;
    }
}
