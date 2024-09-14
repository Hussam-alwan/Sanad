package UN.Sanad.User.Service;

import UN.Sanad.Handler.exceptions.EntityAlreadyExist;
import UN.Sanad.Handler.exceptions.EntityNotFoundException;
import UN.Sanad.User.Mapper.UserMapper;
import UN.Sanad.User.dto.UserDto;
import UN.Sanad.User.dto.UserResponseDto;
import UN.Sanad.User.model.Users;
import UN.Sanad.User.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;

    public UserService(UserMapper userMapper, UserRepo userRepo) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
    }

    public UserResponseDto createUser(UserDto userDto){
      if (userRepo.findByPhoneNumber(userDto.phoneNumber()) != null||userRepo.findByEmail(userDto.email()) != null) {
          throw new EntityAlreadyExist("User already exists");
      }
        Users users = userMapper.toUser(userDto);
        users = userRepo.save(users);
        return userMapper.toUserDto(users);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(Integer id) {
        return userRepo.findById(id).map(userMapper::toUserDto).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
    
    public Users getEmployeeById(Integer id) {
        return userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public UserResponseDto updateUser(Integer id, UserDto user) {
        userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Users users = userMapper.toUser(user);
        users.setId(id);
        users = userRepo.save(users);
        return userMapper.toUserDto(users);
    }

    public String deleteUser(Integer id) {
        userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepo.deleteById(id);
        return "User deleted successfully";
    }
}
