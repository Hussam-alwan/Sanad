package UN.Sanad.UserActivity.Mapper;

import UN.Sanad.UserActivity.dto.UserActDto;
import UN.Sanad.UserActivity.model.UserAct;
import org.springframework.stereotype.Service;

@Service
public class UserActMapper {
    public UserActDto toUserActDto(UserAct userAct){
        return new UserActDto(
                userAct.isEnrolled(),
                userAct.isRegistered(),
                userAct.isFavourite(),
                userAct.getBucketMoney(),
                userAct.getUser(),
                userAct.getActivity()
        );
    }
    public UserAct toUserAct(UserActDto userActDto){
        var userAct = new UserAct();
        userAct.setEnrolled(userActDto.isEnrolled());
        userAct.setRegistered(userActDto.isRegistered());
        userAct.setFavourite(userActDto.isFavourite());
        userAct.setBucketMoney(userActDto.bucketMoney());
        userAct.setUser(userActDto.user());
        userAct.setActivity(userActDto.activity());
        return userAct;
    }

}
