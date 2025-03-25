package extension.extension.activity;

import extension.extension.activity.dto.ActivityDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {
    ActivityService activityService;
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createActivity(@RequestBody ActivityDTO activityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.activityService.create(activityDTO));
    }
}