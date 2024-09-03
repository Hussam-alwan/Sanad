package UN.Sanad.Activity.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
//    private ActivityService activityService;
//    public ActivityController(ActivityMapper activityMapper) {
//        this.activityMapper = activityMapper;
//    }
//
//    @GetMapping
//    public List<ActivityDto> getAllActivities() {
//        List<Activity> activities = activityService.getAllActivities();
//        return activities.stream()
//                .map(activityMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Integer id) {
//        Activity activity = activityService.getActivityById(id);
//        if (activity != null) {
//            return ResponseEntity.ok(activityMapper.toDTO(activity));
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public ActivityDto createActivity(@RequestBody ActivityDto activityDTO) {
//        Activity activity = activityMapper.toEntity(activityDTO);
//        Activity createdActivity = activityService.saveActivity(activity);
//        return activityMapper.toDTO(createdActivity);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ActivityDto> updateActivity(@PathVariable Integer id, @RequestBody ActivityDto activityDTO) {
//        Activity activity = activityMapper.toEntity(activityDTO);
//        activity.setId(id);
//        Activity updatedActivity = activityService.updateActivity(activity);
//        if (updatedActivity != null) {
//            return ResponseEntity.ok(activityMapper.toDTO(updatedActivity));
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteActivity(@PathVariable Integer id) {
//        if (activityService.deleteActivity(id)) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}