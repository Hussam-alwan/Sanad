package UN.Sanad.EmployeeActivity.repo;

import UN.Sanad.EmployeeActivity.model.ActEmp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpActRepo extends JpaRepository<ActEmp,Integer> {
}
