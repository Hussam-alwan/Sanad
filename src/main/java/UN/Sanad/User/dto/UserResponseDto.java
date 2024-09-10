package UN.Sanad.User.dto;

public record UserResponseDto(
    Integer id,
    String firstName,
    String lastName,
    String email,
    String gender,
    String address,
    String phoneNumber
) {}
