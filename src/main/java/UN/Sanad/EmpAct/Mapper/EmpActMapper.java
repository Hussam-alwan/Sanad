package UN.Sanad.EmpAct.Mapper;

import UN.Sanad.EmpAct.dto.EmpActDto;
import UN.Sanad.EmpAct.model.ActEmp;
import org.springframework.stereotype.Service;

@Service
public class EmpActMapper {
    public EmpActDto toEmpActDto(ActEmp empAct) {
        return new EmpActDto();
    }
}
