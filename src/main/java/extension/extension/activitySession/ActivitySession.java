package extension.extension.activitySession;

import extension.extension.activity.Activity;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class ActivitySession {

    private LocalDateTime sessionStartDateTime = LocalDateTime.now();
    private LocalDateTime sessionClosedDateTime = null;
    private Activity activity;
}
