package UN.Sanad.Employee.Service;

import UN.Sanad.Employee.Mapper.EmployeeMapper;
import UN.Sanad.Employee.dto.EmployeeDto;
import UN.Sanad.Employee.dto.ResponseEmployeeDto;
import UN.Sanad.Employee.model.Employee;
import UN.Sanad.Employee.repo.EmployeeRepo;
import UN.Sanad.Handler.exceptions.EntityAlreadyExist;
import UN.Sanad.Handler.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepo employeeRepo) {
        this.employeeMapper = employeeMapper;
        this.employeeRepo = employeeRepo;
    }

    public List<ResponseEmployeeDto> getAllEmployees(){
        return employeeRepo.findAll().
                stream().
                map(employeeMapper::toEmployeeResponseDto)
                .collect(Collectors.toList());
    }

    public ResponseEmployeeDto createEmployee(EmployeeDto employeeDto){
        if(!employeeRepo.findByStartDateAndCouch(employeeDto.startDate(), employeeDto.isCoach()).isEmpty()){
            throw new EntityAlreadyExist("Employee already exists");
        }
        Employee employee = employeeMapper.toEmployee(employeeDto);
        employeeRepo.save(employee);
        return employeeMapper.toEmployeeResponseDto(employee);
    }

    public ResponseEmployeeDto getEmployeeById(int id){
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee not found"));
        return employeeMapper.toEmployeeResponseDto(employee);
    }

    public Employee getManagerById(int id){
        return employeeRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee not found"));

    }

    public ResponseEmployeeDto updateEmployee(int id,EmployeeDto employeeDto){
        employeeRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee not found"));
        Employee employee=employeeMapper.toEmployee(employeeDto);
        employee.setId(id);
        employeeRepo.save(employee);
        return employeeMapper.toEmployeeResponseDto(employee);
    }

    public String deleteEmployee(int id){
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee not found"));
        employeeRepo.delete(employee);
        return "Employee deleted successfully";
    }

}