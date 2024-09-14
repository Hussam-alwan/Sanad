package UN.Sanad.EmployeeActivity.dto;

import jakarta.validation.constraints.Positive;

public record EmpActDto(
  @Positive Integer employeeId
)
{}
