package UN.Sanad.Employee.Service;

import UN.Sanad.Employee.Mapper.EmployeeMapper;
import UN.Sanad.Employee.dto.EmployeeDto;
import UN.Sanad.Employee.dto.ResponseEmployeeDto;
import UN.Sanad.Employee.model.Employee;
import UN.Sanad.Employee.repo.EmployeeRepo;
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
        Employee employee = employeeMapper.toEmployee(employeeDto);
        employeeRepo.save(employee);
        return employeeMapper.toEmployeeResponseDto(employee);
    }
    public ResponseEmployeeDto getEmployeeById(int id){
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        return employeeMapper.toEmployeeResponseDto(employee);
    }
    public Employee getManagerById(int id){
        return employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));

    }

    public ResponseEmployeeDto updateEmployee(int id,EmployeeDto employeeDto){
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        employee.setStartDate(employeeDto.startDate());
        employee.setEndDate(employeeDto.endDate());
        employee.setCoach(employeeDto.isCoach());
        employee.setHours(employeeDto.hours());
        employee.setSalary(employeeDto.salary());
        employeeRepo.save(employee);
        return employeeMapper.toEmployeeResponseDto(employee);
    }

    public void deleteEmployee(int id){
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        employeeRepo.delete(employee);
    }
}
