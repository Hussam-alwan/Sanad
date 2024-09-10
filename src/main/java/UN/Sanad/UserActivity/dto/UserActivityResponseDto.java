package UN.Sanad.UserActivity.dto;

public record UserActivityResponseDto(
    int id,
    boolean isEnrolled,
    boolean isRegistered,
    boolean isFavourite,
    int bucketMoney,
String UsersName,
    String ActivityName
) {
}
