package mk.ukim.finki.wpproekt.seminarska.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/rest")
public class LogoutController {

    @GetMapping("/logout")
    public void logout(HttpServletRequest request){
        request.getSession().invalidate();

    }
}
