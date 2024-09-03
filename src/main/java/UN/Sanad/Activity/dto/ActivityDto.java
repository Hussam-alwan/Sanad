package UN.Sanad.Activity.dto;

import java.time.LocalDateTime;

public record ActivityDto(
         Integer id,
         String description,
         String category,
         LocalDateTime startDate,
         LocalDateTime endDate,
         int budget
) {
}
