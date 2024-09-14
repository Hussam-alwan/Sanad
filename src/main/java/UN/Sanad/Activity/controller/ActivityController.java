package UN.Sanad.Activity.controller;

import UN.Sanad.Activity.Service.ActivityService;
import UN.Sanad.Activity.dto.ActivityDto;
import UN.Sanad.Activity.dto.ActivityResponseDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityResponseDto> getAllActivities() {
        return this.activityService.findAll();
    }

    @GetMapping("/id/{id}")
    public ActivityResponseDto getActivityById(@PathVariable("id") Integer id) {
       return this.activityService.getActivityById(id);
    }

    @GetMapping("/city/{cityName}")
    public List<ActivityResponseDto> getActivitiesByCity(@PathVariable("cityName") String city) {
        return this.activityService.getActivitiesByCity(city);
    }
    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityResponseDto createActivity(@Valid @RequestBody ActivityDto activityDTO) {
       return activityService.createActivity(activityDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActivityResponseDto updateActivity(@PathVariable("id") Integer id, @Valid @RequestBody ActivityDto activityDTO) {
        return activityService.updateActivity(id, activityDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteActivity(@PathVariable Integer id) {
       return activityService.deleteActivity(id);
    }


}