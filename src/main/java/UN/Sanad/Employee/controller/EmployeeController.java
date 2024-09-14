package UN.Sanad.Employee.controller;

import UN.Sanad.Employee.Service.EmployeeService;
import UN.Sanad.Employee.dto.EmployeeDto;
import UN.Sanad.Employee.dto.ResponseEmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeController {
   private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("employees")
    public List<ResponseEmployeeDto> getEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("employee/{id}")
    public ResponseEmployeeDto getEmployeeById(@PathVariable("id") int id) {
        return this.employeeService.getEmployeeById(id);
    }
    @PostMapping("employee")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        return this.employeeService.createEmployee(employeeDto);
    }
    @PutMapping("employee/{id}")
    public ResponseEmployeeDto updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto) {
        return this.employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("employee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteEmployee(@PathVariable("id") int id) {
       return this.employeeService.deleteEmployee(id);
    }
}
