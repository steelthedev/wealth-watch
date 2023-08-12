package dev.steelthedev.WealthWatch.API.Auth.Services;

import dev.steelthedev.WealthWatch.API.Security.TokenService;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import dev.steelthedev.WealthWatch.API.User.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServices implements AuthServiceInt {

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

    @Override
    public Optional<User> getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        if (authentication != null && authentication.isAuthenticated()) {
            return userRepository.findByUsername(authentication.getName());

        }else return null;
    }
}
