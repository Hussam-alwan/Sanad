package UN.Sanad.User.repo;

import UN.Sanad.User.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {
}
