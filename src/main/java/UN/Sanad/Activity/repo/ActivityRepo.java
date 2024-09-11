package UN.Sanad.Activity.repo;

import UN.Sanad.Activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity,Integer> {
    List<Activity> findAllByCityLike(String city);
    Activity findActivityById(Integer id);
}
