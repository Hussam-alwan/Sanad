package UN.Sanad.EmployeeActivity.Mapper;

import UN.Sanad.EmployeeActivity.dto.EmpActDto;
import UN.Sanad.EmployeeActivity.model.ActEmp;
import org.springframework.stereotype.Service;

@Service
public class EmpActMapper {
    public EmpActDto toEmpActDto(ActEmp empAct) {
        return new EmpActDto();
    }
}
