package UN.Sanad.EmployeeActivity.repo;

import UN.Sanad.EmployeeActivity.model.ActEmp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpActRepo extends JpaRepository<ActEmp,Integer> {
    List<ActEmp> findByActivityId(Integer activityId);
    ActEmp findByActivityIdAndId(Integer activityId, Integer id);
    void deleteByActivityIdAndId(Integer activityId, Integer id);
}
