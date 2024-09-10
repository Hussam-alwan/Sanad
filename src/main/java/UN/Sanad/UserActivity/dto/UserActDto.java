package UN.Sanad.UserActivity.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record UserActDto(
        @NotEmpty
        boolean isEnrolled,

        @NotEmpty
        boolean isRegistered,

        @NotEmpty
        boolean isFavourite,

        @PositiveOrZero
        int bucketMoney,

        @Positive
        Integer userId,
        
        @Positive
        Integer activityId
) {
}
