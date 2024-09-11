package UN.Sanad.Employee.dto;

import java.time.LocalDateTime;

public record ResponseEmployeeDto(
        int id,
        String firstName,
        String lastName,
        String email,
        String gender,
        LocalDateTime startDate,
        Integer duration,
        boolean isCoach,
        int salary,
        int hours
)
{}
