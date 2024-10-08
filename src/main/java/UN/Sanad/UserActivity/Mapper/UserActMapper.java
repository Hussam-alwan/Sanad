package UN.Sanad.UserActivity.Mapper;

import UN.Sanad.Activity.Service.ActivityService;
import UN.Sanad.Activity.model.Activity;
import UN.Sanad.User.Service.UserService;
import UN.Sanad.User.model.Users;
import UN.Sanad.UserActivity.dto.UserActCreatDto;
import UN.Sanad.UserActivity.dto.UserActivityResponseDto;
import UN.Sanad.UserActivity.model.UserAct;
import org.springframework.stereotype.Service;

@Service
public class UserActMapper {
    private final UserService userService;
    private final ActivityService activityService;

    public UserActMapper(UserService userService, ActivityService activityService) {
        this.userService = userService;
        this.activityService = activityService;
    }

    public UserActivityResponseDto toUserActResponseDto(UserAct userAct){
        Users users=userService.getEmployeeById(userAct.getUser().getId());
        Activity activity=activityService.getActivityUserById(userAct.getActivity().getId());
        return new UserActivityResponseDto(
                userAct.getId(),
                userAct.isEnrolled(),
                userAct.isRegistered(),
                userAct.isFavourite(),
                userAct.getBucketMoney(),
                users.getFirstName(),
                activity.getName()
        );
    }



    public UserAct toUserAct(UserActCreatDto userActDto,Integer activityId){
        var userAct = new UserAct();
        userAct.setRegistered(userActDto.isRegistered());
        userAct.setFavourite(userActDto.isFavourite());
        userAct.setBucketMoney(userActDto.bucketMoney());
        userAct.setUser(userService.getEmployeeById(userActDto.userId()));
        userAct.setActivity(activityService.getActivityUserById(activityId));
        return userAct;
    }


}
