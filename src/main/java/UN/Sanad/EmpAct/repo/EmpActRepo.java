package UN.Sanad.EmpAct.repo;

import UN.Sanad.EmpAct.model.ActEmp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpActRepo extends JpaRepository<ActEmp,Integer> {
}
