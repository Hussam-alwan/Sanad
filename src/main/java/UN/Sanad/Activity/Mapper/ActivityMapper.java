package UN.Sanad.Activity.Mapper;

import UN.Sanad.Activity.dto.ActivityDto;
import UN.Sanad.Activity.model.Activity;
import org.springframework.stereotype.Service;

@Service
public class ActivityMapper {

    public ActivityDto toActivityDto(Activity activity) {
        return new ActivityDto(
                activity.getName(),
                activity.getDescription(),
                activity.getCategory(),
                activity.getCity(),
                activity.getStartDate(),
                activity.getDuration(),
                activity.getBudget()
        );
    }

    public Activity toActivity(ActivityDto activityDto) {
        var activity = new Activity();
        activity.setName(activityDto.name());
        activity.setDescription(activityDto.description());
        activity.setCategory(activityDto.category());
        activity.setCity(activityDto.city());
        activity.setStartDate(activityDto.startDate());
        activity.setDuration(activityDto.duration());
        activity.setBudget(activityDto.budget());
        return activity;
    }

}
