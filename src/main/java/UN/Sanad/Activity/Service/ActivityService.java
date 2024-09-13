package UN.Sanad.Activity.Service;

import UN.Sanad.Activity.Mapper.ActivityMapper;
import UN.Sanad.Activity.dto.ActivityDto;
import UN.Sanad.Activity.dto.ActivityResponseDto;
import UN.Sanad.Activity.model.Activity;
import UN.Sanad.Activity.repo.ActivityRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    private final ActivityRepo activityRepository;
    private final ActivityMapper activityMapper;
    private final ActivityRepo activityRepo;

    public ActivityService(ActivityRepo activityRepository, ActivityMapper activityMapper, ActivityRepo activityRepo) {
        this.activityRepository = activityRepository;
        this.activityMapper = activityMapper;
        this.activityRepo = activityRepo;
    }

    public List<ActivityResponseDto> findAll() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream()
                .map(activityMapper::activityResponseDto)
                .collect(Collectors.toList());
    }


    public ActivityResponseDto getActivityById(Integer id) {
        Activity activity = activityRepository.findById(id).orElse(null);
        if (activity != null) {
            return activityMapper.activityResponseDto(activity);
        }
        return null;
    }
    public Activity getActivityUserById(Integer id) {
        return activityRepository.findById(id).orElse(null);
    }

    public ActivityResponseDto createActivity(ActivityDto activityDto) {
        Activity activity = activityMapper.toActivity(activityDto);
        if (activityRepo.findByNameAndCityAndStartDate(activity.getName(), activity.getCity(), activity.getStartDate()) != null) {
            throw new RuntimeException("Activity already exists");
        }
        activityRepository.save(activity);
        return activityMapper.activityResponseDto(activity);
    }


    public String deleteActivity(Integer id) {
        var findActivity=activityRepository.findById(id);
        if(findActivity.isPresent()){
            activityRepository.deleteById(id);
            return "Deleted";
        }
        return "Not Found";
    }

    public List<ActivityResponseDto> getActivitiesByCity(String city) {
         List<Activity> activities = activityRepository.findAllByCityLike(city);
        return activities.stream()
                .map(activityMapper::activityResponseDto)
                .collect(Collectors.toList());
    }

    public ActivityResponseDto updateActivity(Integer id, ActivityDto activityDTO) {
        activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
        Activity activity;
        activity = activityMapper.toActivity(activityDTO);
        activity.setId(id);
        activityRepository.save(activity);
        return activityMapper.activityResponseDto(activity);
    }
}
