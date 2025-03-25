package extension.extension.activity;

import extension.extension.activity.dto.ActivityDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {
    public ResponseEntity<?> createActivity(@RequestBody ActivityDTO activityDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(activityDTO);
    }

}
