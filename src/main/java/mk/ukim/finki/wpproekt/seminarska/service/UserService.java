package mk.ukim.finki.wpproekt.seminarska.service;

import mk.ukim.finki.wpproekt.seminarska.model.User;

import mk.ukim.finki.wpproekt.seminarska.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    public User login(String username, String password);
    public User register(String username, String email, String password, String repeatPassword, Role role);

}
