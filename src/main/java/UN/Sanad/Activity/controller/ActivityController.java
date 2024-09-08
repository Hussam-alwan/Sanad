package UN.Sanad.Activity.controller;

import UN.Sanad.Activity.Service.ActivityService;
import UN.Sanad.Activity.dto.ActivityDto;
import org.springframework.http.ResponseEntity;
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
    public List<ActivityDto> getAllActivities() {
        return this.activityService.findAll();
    }

    @GetMapping("/{id}")
    public ActivityDto getActivityById(@PathVariable Integer id) {
       return this.activityService.getActivityById(id);
    }

    @PostMapping
    public ActivityDto createActivity(@RequestBody ActivityDto activityDTO) {
        return activityService.createActivity(activityDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Integer id) {
        if (activityService.deleteActivity(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}