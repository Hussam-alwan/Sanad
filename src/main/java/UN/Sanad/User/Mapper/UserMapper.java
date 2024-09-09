package UN.Sanad.User.Mapper;

import UN.Sanad.User.dto.UserDto;
import UN.Sanad.User.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDto toUserDto(Users user) {
        return new UserDto(
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
                userDto.gender(),
                userDto.address(),
                userDto.phoneNumber()
        );
    }

}
