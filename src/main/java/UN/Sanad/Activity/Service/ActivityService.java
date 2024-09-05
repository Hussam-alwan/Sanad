package UN.Sanad.Activity.Service;

import UN.Sanad.Activity.Mapper.ActivityMapper;
import UN.Sanad.Activity.dto.ActivityDto;
import UN.Sanad.Activity.model.Activity;
import UN.Sanad.Activity.repo.ActivityRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    private final ActivityRepo activityRepository;
    private final ActivityMapper activityMapper;

    public ActivityService(ActivityRepo activityRepository, ActivityMapper activityMapper) {
        this.activityRepository = activityRepository;
        this.activityMapper = activityMapper;
    }

    public List<ActivityDto> findAll() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream()
                .map(activityMapper::toActivity)
                .collect(Collectors.toList());
    }
}
