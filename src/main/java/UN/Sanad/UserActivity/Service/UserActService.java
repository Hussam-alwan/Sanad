package UN.Sanad.UserActivity.Service;

import UN.Sanad.Activity.model.Activity;
import UN.Sanad.Activity.repo.ActivityRepo;
import UN.Sanad.Handler.exceptions.EntityAlreadyExist;
import UN.Sanad.Handler.exceptions.EntityNotFoundException;
import UN.Sanad.UserActivity.Mapper.UserActMapper;
import UN.Sanad.UserActivity.dto.UserActCreatDto;
import UN.Sanad.UserActivity.dto.UserActivityResponseDto;
import UN.Sanad.UserActivity.model.UserAct;
import UN.Sanad.UserActivity.repo.UserActRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserActService {
    private final UserActRepo userActRepo;
    private final UserActMapper userActMapper;
    private final ActivityRepo activityRepo;

    public UserActService(UserActRepo userActRepo, UserActMapper userActMapper, ActivityRepo activityRepo) {
        this.userActRepo = userActRepo;
        this.userActMapper = userActMapper;
        this.activityRepo = activityRepo;
    }

    public List<UserActivityResponseDto> getUsersByActivityId(Integer activityId) {
        return userActRepo.findByActivityId(activityId)
                .stream()
                .map(userActMapper::toUserActResponseDto)
                .collect(Collectors.toList());
    }

    public UserActivityResponseDto createUserAct(Integer activityId, UserActCreatDto userActCreatDto) {
        if (userActRepo.findByUserIdAndRegistered(userActCreatDto.userId(), userActCreatDto.isRegistered()) != null) {
            throw new EntityAlreadyExist("User activity already exists");
        }
        Activity activity=activityRepo.findById(activityId).orElse(null);
        if(activity.getActivityManager().getId()==userActCreatDto.userId()){
            throw new EntityAlreadyExist("User is activity manager");
        }
        UserAct userAct = userActMapper.toUserAct(userActCreatDto,activityId);// Set activity ID
        userAct = userActRepo.save(userAct);
        return userActMapper.toUserActResponseDto(userAct);
    }

    public UserActivityResponseDto updateUserAct(Integer activityId, Integer userId, UserActCreatDto userActDto) {
        UserAct existingUserAct = userActRepo.findByActivityIdAndId(activityId, userId);
        if (existingUserAct == null) {
            throw new EntityNotFoundException("User activity not found");
        }
        UserAct userAct = userActMapper.toUserAct(userActDto,activityId);
        userAct.setId(existingUserAct.getId());
        userAct = userActRepo.save(userAct);
        return userActMapper.toUserActResponseDto(userAct);
    }

    @Transactional
    public String deleteUserAct(Integer activityId, Integer userId) {
        UserAct existingUserAct = userActRepo.findByActivityIdAndId(activityId, userId);
        if (existingUserAct == null) {
            throw new EntityNotFoundException("User activity not found");
        }
        userActRepo.deleteByActivityIdAndId(activityId, userId);
        return "deleted successfully";
    }

    public UserActivityResponseDto getUserByActivityIdAndUserId(Integer activityId, Integer userId) {
        UserAct uses= userActRepo.findByActivityIdAndId(activityId, userId);
        if (uses == null) {
            throw new EntityNotFoundException("User activity not found");
        }
        return userActMapper.toUserActResponseDto(uses);
    }
}