package UN.Sanad.Employee.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record EmployeeDto(
        @NotNull @FutureOrPresent LocalDateTime startDate,
        @NotNull @Positive Integer duration,
        @NotNull boolean isCoach,
        @NotNull int salary,
        @NotNull int hours,
        @NotNull Integer userId
) {
}
