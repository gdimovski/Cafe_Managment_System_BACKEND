package mk.ukim.finki.wpproekt.seminarska.service.Impl;

import mk.ukim.finki.wpproekt.seminarska.model.User;
import mk.ukim.finki.wpproekt.seminarska.model.enums.Role;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.*;
import mk.ukim.finki.wpproekt.seminarska.repository.UserRepository;
import mk.ukim.finki.wpproekt.seminarska.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                passwordEncoder.encode(password)).orElseThrow(InvalidUserCredentialsException::new);
    }




    @Override
    public User register(String username, String email, String password, String repeatPassword, Role role) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidArgumentsException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        if(this.userRepository.findByUsername(username).isPresent() ){
            throw new UsernameAlreadyExistsException(username);
        }
        User user = new User(username,passwordEncoder.encode(password),email,role);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(s).orElseThrow(UserNotFoundException::new);

    }

//    @Override
//    public User login(String username, String password) {
//        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
//            throw new InvalidArgumentsException();
//        }
//        return userRepository.findByUsernameAndPassword(username,
//                password).orElseThrow(InvalidUserCredentialsException::new);
//    }
//
//    @Override
//    public User register(String username, String email, String password, String repeatPassword) {
//        if (username==null || username.isEmpty()  || password==null || password.isEmpty()){
//            throw new InvalidArgumentsException();}
//        if (!password.equals(repeatPassword)){
//            throw new PasswordsDoNotMatchException();}
//        if(this.userRepository.findByUsername(username).isPresent()){
//            throw new UsernameAlreadyExistsException(username);}
//        User user = new User(username,email,passwordEncoder.encode(password));
//        return userRepository.save(user);
//    }


}
