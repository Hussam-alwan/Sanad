package UN.Sanad.UserActivity.dto;

import UN.Sanad.Activity.model.Activity;
import UN.Sanad.User.model.Users;
import jakarta.validation.constraints.NotEmpty;
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
        Users user,
        Activity activity
) {
}
