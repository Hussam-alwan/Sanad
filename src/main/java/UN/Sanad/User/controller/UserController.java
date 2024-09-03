package UN.Sanad.User.controller;

import UN.Sanad.User.model.Users;
import UN.Sanad.User.repo.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping(name = "Users")
    List<Users> getAllUsers(){
        return userRepo.findAll();
    }
}
