package UN.Sanad.Activity.Service;

import UN.Sanad.Activity.Mapper.ActivityMapper;
import UN.Sanad.Activity.dto.ActivityDto;
import UN.Sanad.Activity.dto.ActivityResponseDto;
import UN.Sanad.Activity.model.Activity;
import UN.Sanad.Activity.repo.ActivityRepo;
import UN.Sanad.Handler.exceptions.EntityAlreadyExist;
import UN.Sanad.Handler.exceptions.EntityNotFoundException;
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
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity not found"));
        return activityMapper.activityResponseDto(activity);
    }

    public Activity getActivityUserById(Integer id) {
        return activityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity not found"));
    }

    public ActivityResponseDto createActivity(ActivityDto activityDto) {
        Activity activity = activityMapper.toActivity(activityDto);
        if (activityRepo.findByNameAndCityAndStartDate(activity.getName(), activity.getCity(), activity.getStartDate()) != null) {
            throw new EntityAlreadyExist("Activity already exists");
        }
        activityRepository.save(activity);
        return activityMapper.activityResponseDto(activity);
    }

    public List<ActivityResponseDto> getActivitiesByUserId(Integer userId) {
        activityRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return activityRepository.findAllActivitiesByUserId(userId)
                .stream()
                .map(activityMapper::activityResponseDto).collect(Collectors.toList());
    }
    public List<ActivityResponseDto> getFavoriteActivities(Integer userId) {
        activityRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return activityRepository.findAllByFavoriteId(userId)
                .stream()
                .map(activityMapper::activityResponseDto).collect(Collectors.toList());
    }

    public String deleteActivity(Integer id) {
        if (activityRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("Activity not found");

        activityRepository.deleteById(id);
        return "Deleted";
    }

    public List<ActivityResponseDto> getActivitiesByCity(String city) {
         List<Activity> activities = activityRepository.findAllByCityLike(city);
        return activities.stream()
                .map(activityMapper::activityResponseDto)
                .collect(Collectors.toList());
    }

    public ActivityResponseDto updateActivity(Integer id, ActivityDto activityDTO) {
        activityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity not found"));
        Activity activity = activityMapper.toActivity(activityDTO);
        activity.setId(id);
        activityRepository.save(activity);
        return activityMapper.activityResponseDto(activity);
    }

    public List<ActivityResponseDto> getRegisteredActivities(Integer id) {
        activityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return activityRepository.findAllByRegisteredId(id).stream().map(activityMapper::activityResponseDto).collect(Collectors.toList());
    }

    public List<ActivityResponseDto> getAllEmployeeActivities(Integer id) {
        activityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        return activityRepository.findAllByEmployeeId(id).stream().map(activityMapper::activityResponseDto).collect(Collectors.toList());
    }

    public List<ActivityResponseDto> getEnrolledActivities(Integer id) {
        activityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return activityRepository.findAllByEnrolledId(id).stream().map(activityMapper::activityResponseDto).collect(Collectors.toList());
    }
}
