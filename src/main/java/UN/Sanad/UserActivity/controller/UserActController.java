package UN.Sanad.UserActivity.controller;

import UN.Sanad.UserActivity.Service.UserActService;
import UN.Sanad.UserActivity.dto.UserActDto;
import UN.Sanad.UserActivity.dto.UserActivityResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class UserActController {

    private final UserActService userActService;

    public UserActController(UserActService userActService) {
        this.userActService = userActService;
    }

    @GetMapping("/{activityId}/students")

    public List<UserActivityResponseDto> getUsersByActivityId(@PathVariable("activityId") int activityId) {
        return this.userActService.getStudentByActivityId(activityId);
    }

    @GetMapping("/{activityId}/students/{studentId}")
    public UserActivityResponseDto getUserByActivityId(@PathVariable("activityId") Integer activityId, @PathVariable("studentId") Integer studentId) {
        return this.userActService.getUserByActivityId(activityId, studentId);
    }

    @PostMapping("/{activityId}/students")
    @ResponseStatus(HttpStatus.CREATED)
    public UserActivityResponseDto addUserToActivity(@PathVariable("activityId") Integer activityId,@Valid @RequestBody UserActDto userActDto) {
        return this.userActService.addUserToActivity(activityId, userActDto);
    }

    @PutMapping("/{activityId}/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public UserActivityResponseDto updateUserAct(@PathVariable("activityId") Integer activityId, @PathVariable("studentId") Integer studentId,@Valid @RequestBody UserActDto userActDto) {
        return this.userActService.updateUserAct(activityId, studentId, userActDto);
    }

    @DeleteMapping("/{activityId}/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserAct(@PathVariable("activityId") Integer activityId, @PathVariable("studentId") Integer studentId) {
        this.userActService.deleteUserAct(activityId, studentId);
    }
}
