package UN.Sanad.Activity.dto;

import java.time.LocalDateTime;

public record ActivityResponseDto(
    Integer id,
    String name,
    String description,
    String category,
    String city,
    String managerName,
    LocalDateTime startDate,
    int duration,
    int budget
) {
}
