package UN.Sanad.UserAct.repo;

import UN.Sanad.Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActRepo extends JpaRepository<Employee,Integer> {
}
