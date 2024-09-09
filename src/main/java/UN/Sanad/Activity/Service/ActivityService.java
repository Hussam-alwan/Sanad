package UN.Sanad.Activity.Service;

import UN.Sanad.Activity.Mapper.ActivityMapper;
import UN.Sanad.Activity.dto.ActivityDto;
import UN.Sanad.Activity.model.Activity;
import UN.Sanad.Activity.repo.ActivityRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .map(activityMapper::toActivityDto)
                .collect(Collectors.toList());
    }


    public ActivityDto getActivityById(Integer id) {
        Activity activity = activityRepository.findById(id).orElse(null);
        if (activity != null) {
            return activityMapper.toActivityDto(activity);
        }
        return null;
    }

    public ActivityDto createActivity(ActivityDto activityDto) {
        Activity activity = activityMapper.toActivity(activityDto);
        activityRepository.save(activity);
        return activityMapper.toActivityDto(activity);
    }



    public String deleteActivity(Integer id) {
        var findActivity=activityRepository.findById(id);
        if(findActivity.isPresent()){
            activityRepository.deleteById(id);
            return "Deleted";
        }
        return "Not Found";
    }

    public List<ActivityDto> getActivitiesByCity(String city) {
         List<Activity> activities = activityRepository.findAllByCityLike(city);

        return activities.stream()
                .map(activityMapper::toActivityDto)
                .collect(Collectors.toList());
    }

    public ActivityDto updateActivity(Integer id, ActivityDto activityDTO) {
        Optional<Activity> activity = activityRepository.findById(id);

        if (activity.isPresent()) {
            Activity updatedActivity = activity.get();
            updatedActivity.setName(activityDTO.name());
            updatedActivity.setDescription(activityDTO.description());
            updatedActivity.setCategory(activityDTO.category());
            updatedActivity.setCity(activityDTO.city());
            updatedActivity.setStartDate(activityDTO.startDate());
            updatedActivity.setDuration(activityDTO.duration());
            updatedActivity.setBudget(activityDTO.budget());
            activityRepository.save(updatedActivity);
            return activityMapper.toActivityDto(updatedActivity);
        }
        throw new RuntimeException("Activity not found");
    }
}
