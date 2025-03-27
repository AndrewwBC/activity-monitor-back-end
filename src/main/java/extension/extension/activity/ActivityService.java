package extension.extension.activity;

import extension.extension.activity.dto.ActivityDTO;
import extension.extension.activity_history.ActivityHistory;
import extension.extension.activity_history.ActivityHistoryDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Map<String, String> create(ActivityDTO activityDTO) {
        List<ActivityHistory> activityHistoryList = new ArrayList<>();

        Activity newActivity = Activity.fromDTOCreateActivity(activityDTO, activityHistoryList, null);
        System.out.println(newActivity);
        var novo =this.activityRepository.save(newActivity);
        System.out.println(novo);
        Map<String, String> response = new HashMap<>();
        response.put("message", "created");

        return response;
    }

    public Map<String, String> patch(ActivityHistoryDTO activityHistoryDTO, String url) {
        Activity activityToBePatched = this.activityRepository.findByUrl(url).orElseThrow(() -> {
            throw new NoSuchElementException("Activity Not Found");
        });

        String idOfActivity = activityToBePatched.getId();

        List<ActivityHistory> currentList = activityToBePatched.getActivityHistory();

        if(currentList.isEmpty()) {
            ActivityHistory newHistory = ActivityHistory.fromActivityHistoryDTO(activityHistoryDTO, activityToBePatched);
            currentList.add(newHistory);

            activityToBePatched.setActivityHistory(currentList);

            this.activityRepository.save(activityToBePatched);
        } else {
            currentList.forEach((item) -> {
                if(item.getActivity().getId().equals(idOfActivity) && item.getEndDateAndTime() == null) {

                        item.setStories(activityHistoryDTO.stories());
                        item.setInstagramReels(activityHistoryDTO.instagramReels());

                        item.setFacebookReels(activityHistoryDTO.facebookReels());
                        item.setFacebookStories(activityHistoryDTO.facebookStories());

                        item.setYoutubeShorts(activityHistoryDTO.youtubeShorts());
                }
            });
                activityToBePatched.setActivityHistory(currentList);
                this.activityRepository.save(activityToBePatched);
            }

        Map<String, String> response = new HashMap<>();
        response.put("message", "patched");
        return response;
    }
}
