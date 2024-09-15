package UN.Sanad.UserActivity.controller;

import UN.Sanad.UserActivity.Service.UserActService;
import UN.Sanad.UserActivity.dto.UserActCreatDto;
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

    @GetMapping("/{id}/students")
    @ResponseStatus(HttpStatus.OK)
    public List<UserActivityResponseDto> getUsersByActivityId(@PathVariable("id") Integer activityId) {
        return userActService.getUsersByActivityId(activityId);
    }

    @GetMapping("/{id}/students/{userId}")
    public UserActivityResponseDto getUserByActivityIdAndUserId(@PathVariable("id") Integer activityId, @PathVariable("userId") Integer userId) {
        return userActService.getUserByActivityIdAndUserId(activityId, userId);
    }

    @PostMapping("/{id}/students")
    @ResponseStatus(HttpStatus.CREATED)
    public UserActivityResponseDto addUserToActivity(@PathVariable("id") Integer activityId, @Valid @RequestBody UserActCreatDto userActDto) {
        return userActService.createUserAct(activityId, userActDto);
    }

    @PutMapping("/{id}/students/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserActivityResponseDto updateUserInActivity(@PathVariable("id") Integer activityId, @PathVariable("userId") Integer userId, @Valid @RequestBody UserActCreatDto userActDto) {
        return userActService.updateUserAct(activityId, userId, userActDto);
    }

    @DeleteMapping("/{id}/students/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String removeUserFromActivity(@PathVariable("id") Integer activityId, @PathVariable("userId") Integer userId) {
        return userActService.deleteUserAct(activityId, userId);
    }
}