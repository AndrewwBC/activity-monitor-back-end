package extension.extension.activity;

import extension.extension.activity.dto.ActivityDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {
    ActivityService activityService;
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createActivity(@RequestBody @Valid ActivityDTO activityDTO) {
        System.out.println(activityDTO);
        return ResponseEntity.status(HttpStatus.OK).body(this.activityService.create(activityDTO));
    }

    @PatchMapping
    public ResponseEntity<Map<String, String>> patchActivity(@RequestBody @Valid ActivityDTO activityDTO) {
        System.out.println(activityDTO);
        return ResponseEntity.status(HttpStatus.OK).body(this.activityService.create(activityDTO));
    }
}