package UN.Sanad.Activity.repo;

import UN.Sanad.Activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity,Integer> {
    List<Activity> findAllByCityLike(String city);
    Activity findByNameAndCityAndStartDate(String name, String city, LocalDateTime startDate);

}
