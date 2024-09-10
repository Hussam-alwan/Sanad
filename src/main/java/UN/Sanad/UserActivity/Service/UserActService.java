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

    public List<UserActivityResponseDto> getStudentByActivityId(int activityId) {
        return userActRepo.findByActivityId(activityId).stream().map(userActMapper::toUserActDto).collect(Collectors.toList());
    }

    public UserAct saveUserAct(UserActDto userActDto) {
        UserAct userAct = userActMapper.toUserAct(userActDto);
        return userActRepo.save(userAct);
    }

    public UserActivityResponseDto getUserByActivityId(Integer activityId, Integer studentId) {
        return userActMapper.toUserActDto(userActRepo.findByActivityIdAndUserId(activityId, studentId));
    }

    public UserActivityResponseDto addUserToActivity(Integer activityId, UserActDto userActDto) {
        UserAct userAct = userActMapper.toUserAct(userActDto);
        userAct.getActivity().setId(activityId);
        return userActMapper.toUserActDto(userActRepo.save(userAct));
    }
    public UserActivityResponseDto updateUserAct(Integer activityId, Integer studentId, UserActDto userActDto) {
        UserAct userAct = userActMapper.toUserAct(userActDto);
        userAct.getActivity().setId(activityId);
        userAct.setUser(userActRepo.findByActivityIdAndUserId(activityId, studentId).getUser());
        return userActMapper.toUserActDto(userActRepo.save(userAct));
    }

    public void deleteUserAct(Integer activityId, Integer studentId) {
        userActRepo.deleteByActivityIdAndUserId(activityId, studentId);
    }
}
