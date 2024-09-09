package UN.Sanad.Activity.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record ActivityDto(

         @NotEmpty(message = "Name cannot be empty") String name,
         @NotEmpty(message = "Description cannot be empty") String description,
         @NotEmpty(message = "category cannot be empty") String category,
         @NotEmpty(message = "city cannot be empty") String city,
         @FutureOrPresent(message = "startDate cannot be in the past") @NotNull LocalDateTime startDate,
         @Positive(message = "duration cannot be negative or zero") int duration,
         @PositiveOrZero(message = "budget cannot be negative") int budget
) {
}