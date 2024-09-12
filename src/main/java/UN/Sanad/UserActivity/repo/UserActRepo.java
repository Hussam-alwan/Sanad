package UN.Sanad.UserActivity.repo;

import UN.Sanad.UserActivity.model.UserAct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserActRepo extends JpaRepository<UserAct,Integer> {
    List<UserAct> findByActivityId(Integer activityId);
    UserAct findByActivityIdAndId(Integer activityId, Integer userId);
    void deleteByActivityIdAndUserId(Integer activityId, Integer userId);
}
