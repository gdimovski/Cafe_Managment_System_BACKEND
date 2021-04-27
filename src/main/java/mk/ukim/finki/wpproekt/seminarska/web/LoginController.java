package mk.ukim.finki.wpproekt.seminarska.web;

import mk.ukim.finki.wpproekt.seminarska.model.User;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wpproekt.seminarska.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest")
public class LoginController {

    private final UserService userService;


    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public void getLoginPage(){

    }

    @PostMapping("/login/check")
    public User login(@RequestBody User user){

        try{
            return this.userService.login(user.getUsername(),user.getPassword());


        }catch (InvalidUserCredentialsException exception){
            return null;
        }
    }

}
