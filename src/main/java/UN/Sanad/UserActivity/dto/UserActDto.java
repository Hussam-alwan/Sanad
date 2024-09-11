package UN.Sanad.UserActivity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record UserActDto(
        @NotNull
        boolean isEnrolled,

        @NotNull
        boolean isRegistered,

        @NotNull
        boolean isFavourite,

        @PositiveOrZero
        int bucketMoney,

        @Positive
        Integer userId,
        
        @Positive
        Integer activityId
) {
}
