package UN.Sanad.Activity.dto;

import java.time.LocalDateTime;

public record ActivityDto(

         String name,
         String description,
         String category,
         String city,
         LocalDateTime startDate,
         int duration,
         int budget
) {
}
