package UN.Sanad.EmployeeActivity.Mapper;

import UN.Sanad.Activity.Service.ActivityService;
import UN.Sanad.Employee.Service.EmployeeService;
import UN.Sanad.EmployeeActivity.dto.EmpActDto;
import UN.Sanad.EmployeeActivity.dto.EmployeeActivityResponseDto;
import UN.Sanad.EmployeeActivity.model.ActEmp;
import org.springframework.stereotype.Service;

@Service
public class EmpActMapper {
    private final ActivityService activityService;
    private final EmployeeService employeeService;

    public EmpActMapper(ActivityService activityService, EmployeeService employeeService) {
        this.activityService = activityService;
        this.employeeService = employeeService;
    }

    public ActEmp toEntity(EmpActDto dto, Integer activityId) {
       ActEmp entity = new ActEmp();
       entity.setActivity(activityService.getActivityUserById(activityId));
       entity.setEmployee(employeeService.getManagerById(dto.employeeId()));
       return  entity;
   }

   public EmployeeActivityResponseDto toEmployeeActivityResponseDto(ActEmp entity) {
       return new EmployeeActivityResponseDto(
               entity.getId(),
               entity.getActivity().getName(),
               entity.getEmployee().getUser().getFirstName()
       );
   }
}
