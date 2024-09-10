package UN.Sanad.User.Mapper;

import UN.Sanad.User.dto.UserDto;
import UN.Sanad.User.dto.UserResponseDto;
import UN.Sanad.User.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserResponseDto toUserDto(Users user) {
        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getGender(),
                user.getAddress(),
                user.getPhoneNumber()
        );
    }

    public Users toUser(UserDto userDto) {
        return new Users(
                userDto.firstName(),
                userDto.lastName(),
                userDto.email(),
                userDto.password(),
                userDto.gender(),
                userDto.address(),
                userDto.phoneNumber()
        );
    }

}
