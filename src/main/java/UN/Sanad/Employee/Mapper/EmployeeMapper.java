package UN.Sanad.Employee.Mapper;

import UN.Sanad.Employee.dto.EmployeeDto;
import UN.Sanad.Employee.dto.ResponseEmployeeDto;
import UN.Sanad.Employee.model.Employee;
import UN.Sanad.User.Service.UserService;
import UN.Sanad.User.model.Users;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    private final UserService userService;

    public EmployeeMapper(UserService userService) {
        this.userService = userService;
    }

    public Employee toEmployee(EmployeeDto employeeDto) {
    Employee employee = new Employee();
        employee.setStartDate(employeeDto.startDate());
        employee.setDuration(employeeDto.duration());
        employee.setCoach(employeeDto.isCoach());
        employee.setHours(employeeDto.hours());
        employee.setSalary(employeeDto.salary());
        employee.setUser(userService.getEmployeeById(employeeDto.userId()));
    return employee;
    }

    public ResponseEmployeeDto toEmployeeResponseDto(Employee employee) {
        Users users=userService.getEmployeeById(employee.getUser().getId());
        return new ResponseEmployeeDto(
                employee.getId(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getGender(),
                employee.getStartDate(),
                employee.getDuration(),
                employee.isCoach(),
                employee.getSalary(),
                employee.getHours()
        );
    }
}
