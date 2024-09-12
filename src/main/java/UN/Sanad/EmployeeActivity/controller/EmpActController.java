package UN.Sanad.EmployeeActivity.controller;

import UN.Sanad.EmployeeActivity.Service.EmpActService;
import UN.Sanad.EmployeeActivity.dto.EmpActDto;
import UN.Sanad.EmployeeActivity.dto.EmployeeActivityResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/activity")
public class EmpActController {
    private final EmpActService service;

    public EmpActController(EmpActService service) {
        this.service = service;
    }

    @GetMapping("{id}/employees")
    public List<EmployeeActivityResponseDto> getEmployeesByActivityId(@PathVariable("id") Integer activityId) {
        return service.getEmployeesByActivityId(activityId);
    }

    @GetMapping("{id}/employees/{empId}")
    public EmployeeActivityResponseDto getEmployeeByActivityIdAndEmpId(@PathVariable("id") Integer activityId, @PathVariable("empId") Integer empId) {
        return service.getEmployeeByActivityIdAndEmpId(activityId, empId);
    }
    @PostMapping("{id}/employees")
    public EmployeeActivityResponseDto addEmployeeToActivity(@PathVariable("id") Integer activityId, @Valid @RequestBody EmpActDto dto) {
        return service.addEmployeeToActivity(activityId, dto);
    }
    @PutMapping("{id}/employees/{empId}")
    public EmployeeActivityResponseDto updateEmployeeInActivity(@PathVariable("id") Integer activityId, @PathVariable("empId") Integer empId, @Valid @RequestBody EmpActDto dto) {
        return service.updateEmployeeInActivity(activityId, empId, dto);
    }

    @DeleteMapping("{id}/employees/{empId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeeFromActivity(@PathVariable("id") Integer activityId, @PathVariable("empId") Integer empId) {
        service.deleteEmployeeFromActivity(activityId, empId);
    }
}
