package UN.Sanad.Employee.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EmployeeDto(
        @NotNull LocalDateTime startDate,
        @NotNull LocalDateTime endDate,
        @NotNull boolean isCoach,
        @NotNull int salary,
        @NotNull int hours,
        @NotNull Integer userId
) {
}
