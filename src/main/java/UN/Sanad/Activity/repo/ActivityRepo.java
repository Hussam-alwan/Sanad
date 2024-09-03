package UN.Sanad.Activity.repo;

import UN.Sanad.Activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity,Integer> {
}
