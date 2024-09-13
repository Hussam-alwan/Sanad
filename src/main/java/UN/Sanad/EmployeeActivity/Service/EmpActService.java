package UN.Sanad.EmployeeActivity.Service;

import UN.Sanad.EmployeeActivity.Mapper.EmpActMapper;
import UN.Sanad.EmployeeActivity.dto.EmpActDto;
import UN.Sanad.EmployeeActivity.dto.EmployeeActivityResponseDto;
import UN.Sanad.EmployeeActivity.model.ActEmp;
import UN.Sanad.EmployeeActivity.repo.EmpActRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpActService {
    private final EmpActRepo empActRepo;
    private final EmpActMapper empActMapper;

    public EmpActService(EmpActRepo empActRepo, EmpActMapper empActMapper) {
        this.empActRepo = empActRepo;
        this.empActMapper = empActMapper;
    }


    public List<EmployeeActivityResponseDto> getEmployeesByActivityId(Integer activityId) {
        return  empActRepo.findByActivityId(activityId)
                .stream()
                .map(empActMapper::toEmployeeActivityResponseDto)
                .collect(Collectors.toList());
    }

    public EmployeeActivityResponseDto getEmployeeByActivityIdAndEmpId(Integer activityId, Integer empId) {
        ActEmp actEmp = empActRepo.findByActivityIdAndId(activityId, empId);
        return empActMapper.toEmployeeActivityResponseDto(actEmp);
    }

    public EmployeeActivityResponseDto addEmployeeToActivity(Integer activityId, @Valid EmpActDto dto) {
        ActEmp actEmp = empActMapper.toEntity(dto,activityId);
        actEmp = empActRepo.save(actEmp);
        return empActMapper.toEmployeeActivityResponseDto(actEmp);
    }

    public EmployeeActivityResponseDto updateEmployeeInActivity(Integer  activityId, Integer empId, @Valid EmpActDto dto) {
        ActEmp existing=empActRepo.findByActivityIdAndId(activityId,empId);
        if(existing==null)throw new RuntimeException("Employee Activity not found ");
        ActEmp actEmp=empActMapper.toEntity(dto,activityId);
        actEmp= empActRepo.save(actEmp);
        return empActMapper.toEmployeeActivityResponseDto(actEmp);
    }
    @Transactional
    public void deleteEmployeeFromActivity(Integer activityId, Integer empId) {
         ActEmp actEmp = empActRepo.findByActivityIdAndId(activityId, empId);
         if(actEmp==null) throw new RuntimeException("Employee not found");
         empActRepo.deleteByActivityIdAndId(activityId,empId);
    }
}
