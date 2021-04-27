package mk.ukim.finki.wpproekt.seminarska.web;

import mk.ukim.finki.wpproekt.seminarska.model.User;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wpproekt.seminarska.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public void getRegisterPage(){

    }

    @PostMapping("/register/create")
    public void register(@RequestBody User user)
    {
        try{
            this.userService.register(user.getUsername(),user.getEmail(),user.getPassword(),user.getPassword(),user.getRole());

        }catch (InvalidArgumentsException | PasswordsDoNotMatchException exception){

        }
    }
}
