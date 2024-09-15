package UN.Sanad.Employee.repo;

import UN.Sanad.Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    List<Employee> findByStartDateAndCouchAndUserId(LocalDateTime startDate, Boolean coach, Integer userId);
}
