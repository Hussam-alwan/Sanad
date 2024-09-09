package UN.Sanad.User.Service;

import UN.Sanad.User.Mapper.UserMapper;
import UN.Sanad.User.dto.UserDto;
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

    public UserDto createUser(UserDto userDto){
        Users users = userMapper.toUser(userDto);
        users = userRepo.save(users);
        return userMapper.toUserDto(users);
    }

    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id) {
        return userRepo.findById(id).map(userMapper::toUserDto).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDto updateUser(Integer id, UserDto user) {
        Users users = userRepo.findById(id).orElse(null);
        if (users == null) {
            throw  new RuntimeException("User not found");
        }
        users = userMapper.toUser(user);
        users.setId(id);
        users = userRepo.save(users);
        return userMapper.toUserDto(users);
    }

    public void deleteUser(Integer id) {
        userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.deleteById(id);
    }
}
