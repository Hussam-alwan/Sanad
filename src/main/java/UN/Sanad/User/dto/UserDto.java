package UN.Sanad.User.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotEmpty String firstName,
        @NotEmpty String lastName,
        @NotEmpty String email,
        @NotEmpty String password,
        @NotEmpty String gender,
        @NotEmpty String address,
        @NotEmpty @Size(min = 10, max = 10) String phoneNumber
) {
}
