package UN.Sanad.Activity.controller;

import UN.Sanad.Activity.Service.ActivityService;
import UN.Sanad.Activity.dto.ActivityDto;
import UN.Sanad.Activity.model.Activity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityDto> getAllActivities() {
        return activityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Integer id) {
        Activity activity = activityService.getActivityById(id);
        if (activity != null) {
            return ResponseEntity.ok(activityMapper.toDTO(activity));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ActivityDto createActivity(@RequestBody ActivityDto activityDTO) {
        Activity activity = activityMapper.toEntity(activityDTO);
        Activity createdActivity = activityService.saveActivity(activity);
        return activityMapper.toDTO(createdActivity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDto> updateActivity(@PathVariable Integer id, @RequestBody ActivityDto activityDTO) {
        Activity activity = activityMapper.toEntity(activityDTO);
        activity.setId(id);
        Activity updatedActivity = activityService.updateActivity(activity);
        if (updatedActivity != null) {
            return ResponseEntity.ok(activityMapper.toDTO(updatedActivity));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Integer id) {
        if (activityService.deleteActivity(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}