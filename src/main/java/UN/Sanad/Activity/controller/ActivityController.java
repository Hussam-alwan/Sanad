package UN.Sanad.Activity.controller;

import UN.Sanad.Activity.Service.ActivityService;
import UN.Sanad.Activity.dto.ActivityDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @GetMapping("/id/{id}")
    public ActivityDto getActivityById(@Valid @PathVariable("id") Integer id) {
       return this.activityService.getActivityById(id);
    }

    @GetMapping("/city/{cityName}")
    public List<ActivityDto> getActivitiesByCity(@PathVariable("cityName") String city) {
        return this.activityService.getActivitiesByCity(city);
    }

    @PostMapping
    public ActivityDto createActivity(@RequestBody ActivityDto activityDTO) {
        return activityService.createActivity(activityDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActivityDto updateActivity(@PathVariable("id") Integer id, @RequestBody ActivityDto activityDTO) {
        return activityService.updateActivity(id, activityDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteActivity(@PathVariable Integer id) {
       return activityService.deleteActivity(id);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors().forEach((error)->{
            var fieldName= ((FieldError) error).getField();
            var errorMessage=error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

}