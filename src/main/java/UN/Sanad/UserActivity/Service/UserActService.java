package UN.Sanad.UserActivity.Service;

import UN.Sanad.UserActivity.Mapper.UserActMapper;
import UN.Sanad.UserActivity.dto.UserActDto;
import UN.Sanad.UserActivity.dto.UserActivityResponseDto;
import UN.Sanad.UserActivity.model.UserAct;
import UN.Sanad.UserActivity.repo.UserActRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserActService {
    private final UserActRepo userActRepo;
    private final UserActMapper userActMapper;

    public UserActService(UserActRepo userActRepo, UserActMapper userActMapper) {
        this.userActRepo = userActRepo;
        this.userActMapper = userActMapper;
    }

    public List<UserActivityResponseDto> getUsersByActivityId(Integer activityId) {
        return userActRepo.findByActivityId(activityId)
                .stream()
                .map(userActMapper::toUserActResponseDto)
                .collect(Collectors.toList());
    }

    public UserActivityResponseDto createUserAct(Integer activityId, UserActDto userActDto) {
        UserAct userAct = userActMapper.toUserAct(userActDto);
        userAct.getActivity().setId(activityId); // Set activity ID
        userAct = userActRepo.save(userAct);
        return userActMapper.toUserActResponseDto(userAct);
    }

    public UserActivityResponseDto updateUserAct(Integer activityId, Integer userId, UserActDto userActDto) {
        UserAct existingUserAct = userActRepo.findByActivityIdAndUserId(activityId, userId);
        if (existingUserAct == null) {
            throw new RuntimeException("User activity not found");
        }
        UserAct userAct = userActMapper.toUserAct(userActDto);
        userAct.setId(existingUserAct.getId());
        userAct = userActRepo.save(userAct);
        return userActMapper.toUserActResponseDto(userAct);
    }

    public void deleteUserAct(Integer activityId, Integer userId) {
        UserAct existingUserAct = userActRepo.findByActivityIdAndUserId(activityId, userId);
        if (existingUserAct == null) {
            throw new RuntimeException("User activity not found");
        }
        userActRepo.deleteByActivityIdAndUserId(activityId, userId);
    }

    public UserActivityResponseDto getUserByActivityIdAndUserId(Integer activityId, Integer userId) {
        UserAct uses= userActRepo.findByActivityIdAndUserId(activityId, userId);
        return userActMapper.toUserActResponseDto(uses);
    }
}