package UN.Sanad.UserActivity.Service;

import UN.Sanad.Handler.exceptions.EntityAlreadyExist;
import UN.Sanad.Handler.exceptions.EntityNotFoundException;
import UN.Sanad.UserActivity.Mapper.UserActMapper;
import UN.Sanad.UserActivity.dto.UserActCreatDto;
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

    public UserActivityResponseDto createUserAct(Integer activityId, UserActCreatDto userActCreatDto) {
        if (userActRepo.findByUserIdAndFavouriteAndEnrolledAndRegistered(userActCreatDto.userId(), userActCreatDto.isFavourite(), userActCreatDto.isEnrolled(), userActCreatDto.isRegistered()) != null) {
            throw new EntityAlreadyExist("User activity already exists");
        }
        UserAct userAct = userActMapper.toUserAct(userActCreatDto,activityId);// Set activity ID
        userAct = userActRepo.save(userAct);
        return userActMapper.toUserActResponseDto(userAct);
    }

    public UserActivityResponseDto updateUserAct(Integer activityId, Integer userId, UserActDto userActDto) {
        UserAct existingUserAct = userActRepo.findByActivityIdAndId(activityId, userId);
        if (existingUserAct == null) {
            throw new EntityNotFoundException("User activity not found");
        }
        UserAct userAct = userActMapper.toUserAct(userActDto);
        userAct.setId(existingUserAct.getId());
        userAct = userActRepo.save(userAct);
        return userActMapper.toUserActResponseDto(userAct);
    }

    public String deleteUserAct(Integer activityId, Integer userId) {
        UserAct existingUserAct = userActRepo.findByActivityIdAndId(activityId, userId);
        if (existingUserAct == null) {
            throw new EntityNotFoundException("User activity not found");
        }
        userActRepo.deleteByActivityIdAndUserId(activityId, userId);
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