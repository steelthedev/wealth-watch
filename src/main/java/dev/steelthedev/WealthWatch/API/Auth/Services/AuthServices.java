package dev.steelthedev.WealthWatch.API.Auth.Services;

import dev.steelthedev.WealthWatch.API.Security.TokenService;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import dev.steelthedev.WealthWatch.API.User.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    public AuthServices(UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;


    public void signUp(User user){
         if (userRepository.findByUsername(user.getUsername()).isPresent()){
             throw new IllegalStateException("This user already exists");
         }

         if ( userRepository.findByEmail(user.getEmail()).isPresent()){
             throw new IllegalStateException("This user already exists");
         }

         userRepository.save(user);

    }

    public String login(String username, String password){
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        return tokenService.generateToken(authentication);
    }
}
