package UN.Sanad.Activity.repo;

import UN.Sanad.Activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity,Integer> {
    List<Activity> findAllByCityLike(String city);
    Activity findByNameAndCityAndStartDate(String name, String city, LocalDateTime startDate);

    @Query("SELECT a FROM Activity a INNER JOIN UserAct i ON a.id = i.activity.id WHERE i.user.id = :userId")
    List<Activity> findAllActivitiesByUserId(@Param("userId") Integer userId);

    @Query("select a from Activity a INNER join UserAct i on a.id = i.activity.id where i.favourite=true and i.user.id = :userId")
    List<Activity> findAllByFavoriteId(Integer userId);

    @Query("select a from Activity a INNER join UserAct i on a.id = i.activity.id where i.registered=true and i.user.id = :userId")
    List<Activity> findAllByRegisteredId(Integer userId);

    @Query("select a from Activity a INNER join UserAct i on a.id = i.activity.id where i.enrolled=true and i.user.id = :userId")
    List<Activity> findAllByEnrolledId(Integer userId);

    @Query("select a from Activity a INNER JOIN a.actEmps ea WHERE ea.employee.id = :id")
    List<Activity> findAllByEmployeeId(@Param("id") Integer id);
}
